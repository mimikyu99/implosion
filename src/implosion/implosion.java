package implosion;

import implosion.content.*;
import arc.util.*;
import mindustry.mod.*;

public class implosion extends Mod{

    @Override
    public void loadContent(){
        Log.info("<prepare to implode your mind lol>");
        ImplosionItems.loadContent();
        ImplosionLiquids.loadContent();
        ImplosionUnits.loadContent();
        blocksMain.loadContent();
        planets.loadContent();

    };
}
