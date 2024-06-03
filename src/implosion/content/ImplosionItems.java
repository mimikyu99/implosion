package implosion.content;

import mindustry.type.Item;
import arc.graphics.*;

public class ImplosionItems {
    public static Item silver, carbon, CarbonFiber;
    public static void loadContent() {
        silver = new Item("silver", Color.valueOf("#bf7d5a"));
        carbon = new Item("carbon", Color.valueOf("#bf7d5a"));
        CarbonFiber = new Item("carbon-fiber", Color.valueOf("#bf7d5a"));
    }
}
