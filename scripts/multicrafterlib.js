Events.on(ClientLoadEvent, (event) => {
    Log.info("MultiCrafterLib - Checking if the mod is installed");

    var mod = Vars.mods.getMod("multi-crafter");
    if (mod == null) {
        Log.info("MultiCrafterLib - not installed");

        Vars.ui.showMenu(
            Core.bundle.get("scripts.multicrafter.title"),
            Core.bundle.get("scripts.multicrafter.content"),
            [["[green]install[white]"], ["[red]Cancel(disable implosion)"]],
            (option) => {
                if (option == 0) {
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
                } else if (option == 1) {
                    Vars.mods.setEnabled(Vars.mods.getMod("implosion"), false)
                    Vars.ui.showInfoOnHidden("@mods.reloadexit", () => {
                        Core.app.exit();
                    });
                }
            }
        );
    } else {
        Log.info("MultiCrafterLib - already installed");
    }
});