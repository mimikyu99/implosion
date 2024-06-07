package implosion.content;
import implosion.content.Planets.EuropaGenerator;
import mindustry.type.Planet;
import mindustry.graphics.g3d.*;
import arc.graphics.Color;
import mindustry.content.Planets;
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.HexSkyMesh;


public class planets {
    public static Planet europa;

    public static void loadContent(){
        europa = new Planet("europa", Planets.sun, 1.2f, 3){{
            defaultCore = blocksMain.CoreCrab;
            generator = new EuropaGenerator();
            meshLoader = () -> new HexMesh(this, 6);
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 33, 0.32f, 0.1f, 4, Color.valueOf("#bf7d5a"), 2, 0.45f, 0.9f, 0.38f),
                    new HexSkyMesh(this, 69, 0.82f, 0.17f, 6, Color.white.cpy(), 2, 0.45f, 1f, 0.41f)
            );
            launchCapacityMultiplier = 0.5f;
            sectorSeed = 4;
            allowWaves = true;
            allowWaveSimulation = true;
            enemyCoreSpawnReplace = true;
            allowLaunchLoadout = true;
            allowLaunchSchematics = true;


            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.3f;
            startSector = 1;
            allowLaunchToNumbered = false;
            alwaysUnlocked = true;
            updateLighting = false;
            hiddenItems.addAll(ImplosionItems.ImplosionItems);
        }};
    }
}