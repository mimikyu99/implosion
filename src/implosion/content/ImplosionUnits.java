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
        Dromiacea = new UnitType("dromiacea") {{
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

            weapons.add(new Weapon() {{
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

        //spooder tree//
        Blanc = new MechUnitType("blanc") {{
            hidden = false;
            speed = 0.8f;
            health = 280f;
            splittable = true;
            chainable = true;
            omniMovement = false;
            angleLimit = 65f;
            segmentLength = 5;
            segmentDamageScl = 8f;
            segmentCast = 8;
            segmentOffset = 7.3f;
            maxSegments = 4;
            preventDrifting = true;

            legCount = 6;
            legLength = 7f;
            lockLegBase = true;
            legContinuousMove = true;
            legExtension = -2f;
            legBaseOffset = 3f;
            legMaxLength = 1.3f;
            legMinLength = 0.2f;
            legLengthScl = 0.86f;
            legForwardScl = 0.8f;
            legGroupSize = 2;
            rippleScale = 0.3f;

            legMoveSpace = 2.3f;
            allowLegStep = true;
            hovering = false;
            legPhysicsLayer = true;

            segWeapSeq.add(new Weapon("blanc-shoot") {{
                top = true;
                rotate = true;
                mirror = false;
                reload = 55f;
                autoTarget = true;
                controllable = false;
                bullet = new BasicBulletType(5f, 7) {{
                    maxRange = 40f;
                    collidesTiles = collidesAir = collidesGround = true;
                    width = height = 11f;
                    splashDamage = 25f;
                    splashDamageRadius = 25f;
                    trailColor = hitColor = lightColor = backColor = Pal.thoriumPink;
                    frontColor = Pal.thoriumPink;
                }};
            }});
        }};
    }
}
