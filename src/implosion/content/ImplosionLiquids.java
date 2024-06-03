package implosion.content;

import mindustry.type.Liquid;
import arc.graphics.*;
public class ImplosionLiquids {
    public static Liquid iodide;

    public void loadContent() {
        iodide = new Liquid("iodide", Color.valueOf("#ffff"));
    }
}
