package implosion.content.blocks;


import implosion.content.ImplosionItems;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.distribution.Duct;
import mindustry.world.blocks.distribution.Router;

import static mindustry.type.ItemStack.*;


public class distribution {
    public static Block ItemTransporter, ItemTransporterRouter;
    public static void loadContent() {

        ItemTransporter = new Duct("item-transporter") {{
            health = 5;
            speed = 5.6f;

            requirements(Category.distribution, with(ImplosionItems.silver, 2));
        }};

        ItemTransporterRouter = new Router("item-transporter-router") {{
           health = 10;
            requirements(Category.distribution, with(ImplosionItems.silver, 5));
        }};
    };
}
