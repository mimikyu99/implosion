package implosion;

import implosion.content.*;
import arc.util.*;
import mindustry.mod.*;

public class implosion extends Mod{

    @Override
    public void loadContent(){
        Log.info("Loading some example content.");
        ImplosionItems.loadContent();
        blocksMain.loadContent();

    };
}
