package implosion.content;

import mindustry.ai.types.*;
import mindustry.gen.UnitEntity;
import mindustry.type.*;

public class ImplosionUnits {
    public static UnitType Dromiacea;

    public static void loadContent() {
        Dromiacea = new UnitType("dromiacea") {{
            aiController = BuilderAI::new;
            constructor = UnitEntity::create;

            flying = true;
            isEnemy = false;


            health = 100f;
            armor = 2f;
            hitSize = 2f;
            itemCapacity = 40;

            speed = 2f;
            canBoost = false;
            boostMultiplier = .75f;

            buildSpeed = .25f;
            buildRange = 150f;

            canAttack = true;
            mineSpeed = 2f;
            mineTier = 0;
            mineFloor = true;
            mineWalls = true;

            coreUnitDock = true;
            createScorch = false;
        }};
    };
}
