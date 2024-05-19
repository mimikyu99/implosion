Events.on(ClientLoadEvent, (event) => {
    Log.info("Implosion - Sending version check");

    Http.get("https://raw.githubusercontent.com/0rang30rang3/implosion/main/mod.hjson", (res) => {
        try {
            var resp = res.getResultAsString();
            Log.info("Implosion - response: \n" + resp);

            var json = Jval.read(resp);
            var remoteVersion = json.getString("version");
            Log.info("Implosion - remote version: " + remoteVersion);

            var localVersion = Vars.mods.getMod("implosion").meta.version;
            Log.info("Implosion - local version: " + localVersion);

            if (!localVersion.equals(remoteVersion)) {
                Log.warn("Implosion - not up to date");
                Vars.ui.showMenu(
                    Core.bundle.get("scripts.update.title"),
                    Core.bundle.get("scripts.update.content"),
                    [["[red]ingore"], ["[green]Reinstall"]],
                    (option) => {
                        if (option == 1) {
                            var mod = Vars.mods.locateMod("implosion");
                            Vars.ui.mods.githubImportMod(mod.getRepo(), mod.isJava());

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
                Log.info("Implosion - up to date");
            }
        } catch (err) {
            Log.err("Implosion - Error parsing response: " + err.toString());
        }
    }, (err) => {
        Vars.ui.showOkText("[sky]Implosion[white]", "[red]ERROR:[white] Cannot check for updates!", () => {});
        Log.err("Implosion - update check failed: " + err.toString());
    });
});
