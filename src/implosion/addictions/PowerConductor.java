package implosion.addictions;

import arc.*;
import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.core.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.ui.*;
import mindustry.world.blocks.power.*;

import static mindustry.Vars.tilesize;

public class PowerConductor extends PowerNode {
    public final int debugUpdateTimer = timers++;
    final float debugUpdateTime = 40;
    public float lightningRange;
    public float thresholdPerTile;
    public Color lightningColor = Color.valueOf("#bf7d5a");

    public PowerConductor(String name) {
        super(name);
        this.maxNodes = 0;
        update = true;
        laserColor2 = Color.valueOf("#bf7d5a");
    }

    @Override
    public void init() {
        super.init();
        if(maxNodes == 0) laserRange = lightningRange / tilesize;
    }


    @Override
    public void setBars() {
        super.setBars();
        if(maxNodes == 0) {
            removeBar("batteries");
            removeBar("connections");
            addBar("power", entity -> new Bar(
                    () -> Core.bundle.format("bar.poweramount", UI.formatAmount((int)(entity.power.status * consPower.capacity))),
                    () -> Pal.powerBar,
                    () -> entity.power.status)
            );
        }
    }

    @Override
    public void drawPlace(int x, int y, int rotation, boolean valid){
    }

    public class LightningPowerNodeBuild extends PowerNodeBuild {
        final Seq<LightningPowerNodeBuild> nodes = new Seq<>();
        final float[] energyToSet = new float[1];


        @Override
        public void update() {
            super.update();
            if(!timer.get(debugUpdateTimer,debugUpdateTime)) return;

            float thisCap = powerCapacity(this), thisStored = powerStored(this);
            energyToSet[0] = thisStored;

            Vars.indexer.eachBlock(this, lightningRange, other -> {
                if (!other.isValid() || !other.isAdded() || other == this ||
                        !(other instanceof LightningPowerNodeBuild)) return false;

                float powerDelta = thisStored - powerStored(other);
                float requiredDelta = thresholdPerTile * Mathf.len(other.x - x, other.y - y);
                return powerDelta > requiredDelta;
            }, b -> {
                nodes.add((LightningPowerNodeBuild)b);
                energyToSet[0] += powerStored(b);
            });

            if(!nodes.isEmpty()) {
                energyToSet[0] /= nodes.size + 1;
                for(LightningPowerNodeBuild node : nodes) {
                    if(!node.isValid()) continue;
                    float capacity = powerCapacity(node), stored = powerStored(node);
                    float toSet = Math.min(capacity, energyToSet[0]);
                    float toGive = toSet - stored;
                    if(toSet <= stored) {
                        continue;
                    }

                    node.power.status += toGive / capacity;
                    power.status -= toGive / thisCap;

                }
                nodes.clear();
            }
        }

        @Override
        public void drawSelect() {
        }
    }

    private static float powerStored(Building b) {
        if(b.power == null || b.block.consPower == null) return 0;
        return b.block.consPower.capacity * b.power.status;
    }

    private static float powerCapacity(Building b) {
        if(b.block.consPower == null) return 0;
        return b.block.consPower.capacity;
    }
}