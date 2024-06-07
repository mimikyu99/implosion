package implosion.content;

import arc.struct.Seq;
import mindustry.type.Item;
import arc.graphics.*;

public class ImplosionItems {
    public static Item silver, carbon, CarbonFiber, Sucrose, VulcanGlass;
    public static final Seq<Item> ImplosionItems = new Seq<>();

    public static void loadContent() {
        silver = new Item("silver", Color.valueOf("#9b9b9b"));
        carbon = new Item("carbon", Color.valueOf("#4a4a4a"));
        CarbonFiber = new Item("carbon-fiber", Color.valueOf("#2c2a2b"));
        VulcanGlass = new Item("vulcan-glass", Color.valueOf("#AF8994"));
        Sucrose = new Item("sucrose", Color.valueOf("#D0DAE0"));
    }
}
