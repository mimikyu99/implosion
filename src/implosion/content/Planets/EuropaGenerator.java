package implosion.content.Planets;

import arc.graphics.*;
import arc.math.*;
import arc.math.geom.*;
import arc.util.*;
import arc.util.noise.*;
import mindustry.ai.*;
import mindustry.content.*;
import mindustry.game.*;
import mindustry.maps.generators.*;
import mindustry.maps.planet.ErekirPlanetGenerator;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;

import implosion.content.*;
public class EuropaGenerator extends ErekirPlanetGenerator {

    Block[] terrain = {blocksMain.CoastSand, blocksMain.CoastWall, blocksMain.TarFloor, blocksMain.SilverOre};
    {
        baseSeed = 2;
    }
}