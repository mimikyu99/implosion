package implosion.content.blocks;


import mindustry.content.Items;
import mindustry.entities.part.RegionPart;
import mindustry.gen.Bullet;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import implosion.content.*;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.world.draw.DrawTurret;

import static mindustry.type.ItemStack.*;

public class turrets {
    public static Block Trailer;
    public static Bullet TrailerBullet;

    public static void loadContent() {
        Trailer = new ItemTurret("trailer") {{
            health = 270;
            size = 3;
            range = 100f;
            reload = 70f;
            maxAmmo = 40;
            inaccuracy = 4f;
            targetGround = true;
            targetAir = true;
            shootSound = Sounds.cannon;
            ammo(ImplosionItems.silver, new BasicBulletType() {{
                reloadMultiplier = 3f;
                ammoMultiplier = 3f;
                lifetime = 60f;
                damage = 24f;
                height = 9.5f;
                speed = 2f;
                width = 7f;
            }});

            requirements(Category.turret, with(Items.coal, 1, Items.copper, 5));

            drawer = new DrawTurret("trailer"){{
                parts.add(
                        new RegionPart("-sides"){{
                            progress = PartProgress.warmup;
                            mirror = false;
                            under = false;
                            moveY = 1f;
                        }},
                        new RegionPart("-barrel"){{
                            progress = PartProgress.recoil;
                            mirror = false;
                            under = false;
                            moveRot = -5f;
                    }},
                    new RegionPart("-barrel2"){{
                        progress = PartProgress.recoil;
                        mirror = false;
                        under = false;
                        moveRot = 5f;
                    }}

                );
            }};
       }};
    };
}
