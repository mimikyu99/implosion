package implosion.content.blocks;

import implosion.content.ImplosionItems;
import mindustry.content.Items;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.environment.*;
import mindustry.world.meta.*;

public class env {
    public static Block

    //coast//
    CoastSand, CoastWall,

    //cold seeps//
    ColdSeepsFLoor, ColdSeepsWall,

    //neritic//
    NeriticFLoor, NeriticWall,

    //shallow//
    ShallowFLoor,

    //Tar//
    TarFloor,

    //deco//
    Kelp,

    //ores//
    ImplosionCoalOre, SilverOre;

    public static void loadContent() {

        //coast//
        CoastSand = new Floor("coast-sand", 1) {{
            playerUnmineable = true;
            itemDrop = Items.sand;
            attributes.set(Attribute.get("sand"), .25f);
        }};
        CoastWall = new StaticWall("coast-wall") {{
            variants = 3;
        }};

        //cold seeps//
        ColdSeepsFLoor = new Floor("cold-seeps-floor", 5);
        CoastWall = new StaticWall("cold-seeps-wall") {{
            variants = 3;
        }};


        //neritic//
        NeriticFLoor = new Floor("neritic-floor", 5);
        NeriticWall = new StaticWall("neritic-wall") {{
            variants = 3;
        }};

        //shallow//
        ShallowFLoor = new Floor("shallow", 3);

        //tar//
        TarFloor = new Floor("tar-floor", 3);

        //ore//
        ImplosionCoalOre = new Floor("implosion-coal-ore-",3) {{
            playerUnmineable = true;
            itemDrop = Items.coal;
        }};

        SilverOre = new Floor("ore-silver",3) {{
            itemDrop = ImplosionItems.silver;
        }};
    };




}
