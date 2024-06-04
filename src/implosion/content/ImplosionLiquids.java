package implosion.content;

import mindustry.type.Liquid;
import arc.graphics.*;
public class ImplosionLiquids {
    public static Liquid iodide;

    public static void loadContent() {
        iodide = new Liquid("iodide", Color.valueOf("#bf7d5a"));
    }
}

