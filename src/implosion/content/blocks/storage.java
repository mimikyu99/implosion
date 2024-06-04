package implosion.content.blocks;

import implosion.content.ImplosionItems;
import implosion.content.ImplosionUnits;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.meta.*;
import mindustry.world.blocks.storage.*;

import static mindustry.type.ItemStack.*;

public class storage {
    public static Block CoreCrab;

    public static void loadContent() {

        CoreCrab = new CoreBlock("core-crab") {{
            health = 550;
            alwaysUnlocked = true;
            isFirstTier = true;
            itemCapacity = 500;

            unitType = ImplosionUnits.Dromiacea;

            requirements(Category.effect, with(ImplosionItems.silver, 6));
        }};
    };

}
