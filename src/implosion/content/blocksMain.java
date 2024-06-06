package implosion.content;

import implosion.addictions.PowerConductor;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.entities.part.RegionPart;
import mindustry.gen.Bullet;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.Item;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.distribution.Duct;
import mindustry.world.blocks.distribution.Router;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.environment.StaticWall;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.draw.*;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.Effect;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.Env;

import static mindustry.type.ItemStack.with;

public class blocksMain {
    // Turrets
    public static Block Trailer;
    public static Bullet TrailerBullet;

    // Production
    public static Block FiberSynthesizer, CoalMixer, PetroleumCracker, PressureDrill;

    // Power
    public static Block IodideReactor, PowerConductor;

    // Environment
    public static Block CoastSand, CoastWall, ColdSeepsFloor, ColdSeepsWall, NeriticFloor, NeriticWall, ShallowFloor,ShallowWall, TarFloor,TarWall, Kelp, ImplosionCoalOre, SilverOre;

    // Distribution
    public static Block ItemTransporter, ItemTransporterRouter;

    // Defense
    public static Block SilverWall, SilverWallLarge,

    // Storage
    CoreCrab;
    public static void loadContent() {
        // Turrets
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
            drawer = new DrawTurret("trailer") {{
                parts.add(
                        new RegionPart("-sides") {{
                            progress = PartProgress.warmup;
                            mirror = false;
                            under = false;
                            moveY = 1f;
                        }},
                        new RegionPart("-barrel") {{
                            progress = PartProgress.recoil;
                            mirror = false;
                            under = false;
                            moveRot = -5f;
                        }},
                        new RegionPart("-barrel2") {{
                            progress = PartProgress.recoil;
                            mirror = false;
                            under = false;
                            moveRot = 5f;
                        }}
                );
            }};
        }};

        // Production

        PressureDrill = new Drill("pressure-drill") {{
            requirements(Category.production, with(ImplosionItems.silver, 12));
            tier = 2;
            drillTime = 740;
            size = 2;

            consumeLiquid(ImplosionLiquids.fluorine, 0.05f).boost();
        }};
        FiberSynthesizer = new GenericCrafter("fiber-synthesizer") {{
            scaledHealth = 120;
            size = 3;
            craftTime = 90f;
            consumeItems(with(ImplosionItems.carbon, 1, Items.sand, 5));
            outputItems = with(ImplosionItems.CarbonFiber, 1);
            requirements(Category.crafting, with(ImplosionItems.silver, 125, Items.beryllium, 70));
        }};

        CoalMixer = new GenericCrafter("coal-mixer") {{
            scaledHealth = 60;
            size = 2;
            craftTime = 80f;
            consumeItems(with(Items.coal, 2));
            outputItems = with(ImplosionItems.carbon, 2);
            requirements(Category.crafting, with(ImplosionItems.silver, 70, Items.beryllium, 90));
        }};

        PetroleumCracker = new GenericCrafter("petroleum-cracker") {{
            hasLiquids = true;
            scaledHealth = 140;
            size = 4;
            craftTime = 60f;
            consumeLiquid(Liquids.oil, 0.1F);
            outputItems = with(ImplosionItems.carbon, 2);
            requirements(Category.crafting, with(ImplosionItems.silver, 120, Items.beryllium, 100, ImplosionItems.CarbonFiber, 40));
            drawer = new DrawMulti(new DrawDefault(), new DrawLiquidRegion());
        }};

        // Power
        IodideReactor = new ConsumeGenerator("iodide-reactor") {{
            requirements(Category.power, with(ImplosionItems.silver, 100, Items.beryllium, 70, ImplosionItems.CarbonFiber, 60));
            powerProduction = 2.5f;
            itemDuration = 130f;
            hasLiquids = true;
            consumeLiquid(ImplosionLiquids.iodide, 0.2F);
            size = 3;
            squareSprite = false;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.06f;
            drawer = new DrawMulti(new DrawRegion("-liquid"), new DrawLiquidTile(), new DrawDefault());
        }};

        PowerConductor = new PowerConductor("power-conductor") {{
            requirements(Category.power, with(ImplosionItems.silver, 100, Items.beryllium, 70, ImplosionItems.CarbonFiber, 60));
            consumePower(1F);
        }};

        // Environment
        CoastSand = new Floor("coast-sand", 1) {{
            playerUnmineable = true;
            itemDrop = Items.sand;
            attributes.set(Attribute.get("sand"), .25f);
        }};
        CoastWall = new StaticWall("coast-wall") {{
            variants = 3;
        }};
        ColdSeepsFloor = new Floor("cold-seeps-floor", 5);
        ColdSeepsWall = new StaticWall("cold-seeps-wall") {{
            variants = 3;
        }};
        NeriticFloor = new Floor("neritic-floor", 5);
        NeriticWall = new StaticWall("neritic-wall") {{
            variants = 3;
        }};
        ShallowFloor = new Floor("shallow", 3);
        TarFloor = new Floor("tar-floor", 3);

        SilverOre = new OreBlock("ore-silver", ImplosionItems.silver);
        ImplosionCoalOre = new OreBlock("imp-coal-ore", Items.coal) {{
            playerUnmineable = true;
        }};
        // Distribution
        ItemTransporter = new Duct("item-transporter") {{
            health = 5;
            speed = 5.6f;
            requirements(Category.distribution, with(ImplosionItems.silver, 2));
        }};

        ItemTransporterRouter = new Router("item-transporter-router") {{
            health = 10;
            requirements(Category.distribution, with(ImplosionItems.silver, 5));
        }};

        // Defense
        SilverWall = new Wall("silver-wall") {{
            requirements(Category.defense, with(ImplosionItems.silver, 18));
            health = 300;
        }};
        SilverWallLarge = new Wall("silver-wall-large") {{
            requirements(Category.defense, with(ImplosionItems.silver, 24));
            health = 600;
            size = 2;
        }};

        // storage
        CoreCrab = new CoreBlock("core-crab") {{
            health = 550;
            size = 3;
            alwaysUnlocked = true;
            isFirstTier = true;
            itemCapacity = 500;

            unitType = ImplosionUnits.Dromiacea;

            requirements(Category.effect, with(ImplosionItems.silver, 6));
        }};
    };
    }

