package implosion.content;

import arc.graphics.Color;
import mindustry.ai.types.*;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.units.AIController;
import mindustry.gen.Sounds;
import mindustry.gen.UnitEntity;
import mindustry.type.*;
import mindustry.type.unit.MissileUnitType;

public class ImplosionUnits {
    public static UnitType
            //core//
            Dromiacea,

            //spoder tree//
            Blanc,

            //submarine tree//
            Scout;

    public static void loadContent() {


        Dromiacea = new UnitType("dromiacea") {
            {
                aiController = BuilderAI::new;
                constructor = UnitEntity::create;

                flying = true;
                isEnemy = false;


                health = 100f;
                armor = 2f;
                hitSize = 2f;
                itemCapacity = 40;

                speed = 3f;
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
                weapons.add(
                        new Weapon() {{
                            x = y = 0f;
                            mirror = false;
                            reload = 20f;
                            soundPitchMin = 0.9f;
                            shootSound = Sounds.shoot;
                            shoot.shots = 2;
                            bullet = new BasicBulletType() {{
                                lifetime = 45f;
                                frontColor = Color.valueOf("ffffff");
                                shake = 0.5f;
                                width = 6.5f;
                                height = 7.5f;
                                speed = 3f;
                                keepVelocity = false;
                                inaccuracy = 3f;
                            }};
                        }});
            }};

        //spoder tree//
            Blanc = new Unit("blanc") {{
                aiController =
                constructor = UnitEntity::create;

                flying = true;
                isEnemy = false;


                health = 100f;
                armor = 2f;
                hitSize = 2f;
                itemCapacity = 40;

                speed = 3f;
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
                weapons.add(
                        new Weapon(){{
                            x = y = 0f;
                            mirror = false;
                            reload = 20f;
                            soundPitchMin = 0.9f;
                            shootSound = Sounds.shoot;
                            shoot.shots = 2;
                            bullet = new BasicBulletType(){{
                                lifetime = 45f;
                                frontColor = Color.valueOf("ffffff");
                                shake = 0.5f;
                                width = 6.5f;
                                height = 7.5f;
                                speed = 3f;
                                keepVelocity = false;
                                inaccuracy = 3f;
                            }};
                        }});
                    }};
    };
}
