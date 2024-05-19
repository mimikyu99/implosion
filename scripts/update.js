//this code belongs to: https://github.com/Twcash/Tantros-Test/blob/main/scripts/update.js

Events.on(ClientLoadEvent, (event) => {
    Log.info("Implosion - Sending version check");
    var req = new Http.get(
        "https://raw.githubusercontent.com/0rang30rang3/implosion/main/mod.hjson",
        (res) => {
            var resp = res.getResultAsString();
            Log.info("Implosion - response: \n" + resp);

            var json = Jval.read(resp);
            Log.info("Implosion - remote ver: " + json.get("version"));

            var vers = Vars.mods.getMod("implosion").meta.version;
            Log.info("Implosion - local version: " + vers);

            if (!vers.equals(json.get("version"))) {
                Log.warn("Implosion - not up to date");
                try {
                    Vars.ui.showMenu(
                        "[sky]Implosion[white]",
                        Core.bundle.get("scripts.update-implosion"),
                        [["[gray]Ok"], ["[green]Reinstall"]],
                        (option) => {
                            if (option == 1) {
                                Vars.ui.mods.githubImportMod(
                                    Vars.mods.locateMod("implosion").getRepo(),
                                    Vars.mods.locateMod("implosion").isJava()
                                );

                                var shown = false;

                                Timer.schedule(
                                    () => {
                                        if (
                                            Vars.mods.requiresReload() &&
                                            !shown
                                        ) {
                                            shown = true;
                                            Vars.ui.showInfoOnHidden(
                                                "@mods.reloadexit",
                                                () => {
                                                    Core.app.exit();
                                                }
                                            );
                                        }
                                    },
                                    2,
                                    1
                                );
                            }
                        }
                    );
                } catch (err) {
                    Log.info("Error: " + err.toString());
                }
            } else {
                Log.info("Implosion - up to date");
            }
        },
        (err) => {
            Vars.ui.showOkText(
                "[sky]Implosion[white]",
                "[red]ERROR:[white] Cannot check for updates!",
                () => {}
            );
            Log.err("Implosion - update check failed :(");
        }
    );
