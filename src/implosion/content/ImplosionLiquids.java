package implosion.content;

import mindustry.type.Liquid;
import arc.graphics.*;
public class ImplosionLiquids {
    public static Liquid iodide;

    public static void loadContent() {
        iodide = new Liquid("iodide", Color.valueOf("#c555b0"));
    }
}

