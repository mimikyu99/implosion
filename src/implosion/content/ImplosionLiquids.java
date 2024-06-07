package implosion.content;

import mindustry.type.Liquid;
import arc.graphics.*;
public class ImplosionLiquids {
    public static Liquid iodide, fluorine, brine;

    public static void loadContent() {

        iodide = new Liquid("iodide", Color.valueOf("#c555b0"));
        fluorine = new Liquid("fluorine", Color.valueOf("#A3977E"));
        brine = new Liquid("brine", Color.valueOf("#A3977E"));
    }
}

