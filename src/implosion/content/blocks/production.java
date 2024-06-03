package implosion.content.blocks;


import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.production.*;
import mindustry.world.draw.*;
import static mindustry.type.ItemStack.*;
import mindustry.world.consumers.*;

import implosion.content.*;

public class production {
    public static Block FiberSynthesizer, CoalMixer, PetroleumCracker;
    public static void loadContent() {
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
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawLiquidRegion()
            );
        }};
    };
}

