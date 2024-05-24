Events.on(ClientLoadEvent, (event) => {
    Log.info("MultiCrafterLib - Checking if the mod is installed");

    var mod = Vars.mods.getMod("test");

    if (mod == null) {
        Log.info("MultiCrafterLib - not installed");

        Vars.ui.showMenu(
            "test",
            "test",
            [["test"], ["test"]],
            (option) => {
                if (option == 1) {
                    Log.info("MultiCrafterLib - Downloading and installing the mod");

                    Vars.ui.mods.githubImportMod("liplum/MultiCrafterLib", true);

                    var shown = false;

                    Timer.schedule(() => {
                        if (Vars.mods.requiresReload() && !shown) {
                            shown = true;
                            Vars.ui.showInfoOnHidden("@mods.reloadexit", () => {
                                Core.app.exit();
                            });
                        }
                    }, 2, 1);
                }
            }
        );
    } else {
        Log.info("MultiCrafterLib - already installed");
    }
});
