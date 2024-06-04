package implosion.content.blocks;

import mindustry.content.Items;
import mindustry.entities.Effect;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.power.ConsumeGenerator;
import implosion.content.*;
import mindustry.gen.Sounds;
import mindustry.world.draw.*;

import static mindustry.type.ItemStack.*;

public class power {
    public static Block IodideReactor ;

    public static void loadContent() {
        IodideReactor = new ConsumeGenerator("iodide-reactor"){{


            requirements(Category.power, with(ImplosionItems.silver,100, Items.beryllium, 70, ImplosionItems.CarbonFiber, 60));
            powerProduction = 2.5f;
            itemDuration = 130f;

            hasLiquids = true;
            consumeLiquid(ImplosionLiquids.iodide, 0.2F);
            size = 3;
            squareSprite = false;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.06f;


            drawer = new DrawMulti(

                    new DrawRegion("-liquid"),
                    new DrawLiquidTile(),
                    new DrawDefault()

            );
        }};
        PowerConductor = new LightningPowerNode("power-conductor", 0) {{
            requirements(Category.power, with(ImplosionItems.silver, 5));
            
            consumePowerBuffered(5000f);
            lightningRange = 0;
            thresholdPerTile = 0.1f;
        }};
        

        
    };
}
