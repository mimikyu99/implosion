package implosion.content.blocks;

import implosion.content.ImplosionItems;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import static mindustry.type.ItemStack.*;
import arc.graphics.*;

public class defense {
    public static Block SilverWall, SilverWallLarge;

    public static void loadContent(){

        SilverWall = new Wall("silver-wall"){{
            requirements(Category.defense, with(ImplosionItems.silver, 6));
            health = 90;
        }};

        SilverWallLarge = new Wall("silver-wall-large"){{
            requirements(Category.defense, with(ImplosionItems.silver, 6));
            health = 90;
            size = 2;
        }};
    };
}
