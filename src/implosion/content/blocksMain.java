package implosion.content;

import implosion.content.blocks.*;
public class blocksMain {

    public static void loadContent(){
        storage.loadContent();
        defense.loadContent();
        distribution.loadContent();
        production.loadContent();
        env.loadContent();
        turrets.loadContent();
        power.loadContent();
    };
}
