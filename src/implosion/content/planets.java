package implosion.content;

import mindustry.type.Planet;
import mindustry.content.*;
import mindustry.graphics.g3d.*;
import mindustry.type.*;
import arc.graphics.*;

public class planets {
    public static Planet europa;

    public static void loadContent() {
        europa = new Planet("europa", Planets.sun, 2f, 1) {{
            iconColor = Color.valueOf("#158400");
            // generator = new europaGenerator();
            alwaysUnlocked = true;
            accessible = true;
            visible = true;
            defaultCore = Blocks.coreAcropolis;

            drawOrbit = true;
            orbitRadius = 32f;
            hasAtmosphere = false;
            rotateTime = 24 * 60; // first numbers becomes irl minutes(for day)
            orbitTime = rotateTime * 28; // second number becomes years

            atmosphereColor = Color.valueOf("#21c7eb");
            atmosphereRadIn = 0.1f;
            atmosphereRadOut = 0.3f;

            sectorSeed = 5948;
            startSector = 0;
            clearSectorOnLose = true;
            allowSectorInvasion = false;
            allowLaunchToNumbered = false;
            allowLaunchLoadout = true;

            ruleSetter = r -> {
                r.fog = true;
                r.staticFog = true;
            };

            itemWhitelist = ImplosionItems.ImplosionItems;

            // THIS NEEDS A REWORK //
            meshLoader = () -> new MultiMesh(
                    new NoiseMesh(this, 262436,
                            5, .9f, 4, 1f, .75f, 1.2f,
                            Color.valueOf("#219ebc"), Color.valueOf("#023047"),
                            4, .5f, .5f, .5f),

                    new HexSkyMesh(this, 5,
                            1.5f, .12f, 5, Color.valueOf("#7eb6debb"), 1, 2f, 2f, .45f)

                    // // Grass & Water
                    // new NoiseMesh(this, 262436,
                    //               6, 1f, 4, 1f, 0.75f, 1.2f,
                    //               Color.valueOf("#158400"), Color.valueOf("#7070ff"),
                    //               3, 0.5f, 0.25f, 0.5f),
                    // // Moutains
                    // new NoiseMesh(this, 373547,
                    //               6, 1f, 5, 0.5f, 1f, 1.3f,
                    //               Color.valueOf("#aaaaaa"), Color.valueOf("#cccccc"),
                    //               4, 0.7f, 0.7f, 0.8f),

                    // new HexSkyMesh(this, 5,
                    //                0.5f, 0.27f, 7, Color.valueOf("#7eb6debb"),
                    //                1, 2f, 2f, 0.45f)
            );
        }};
    };
}
