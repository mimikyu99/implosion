
var req, res, resp, json, vers, modName, modRepo, hjsonUrl, localVersion, repoVersion;


modName = "implosion";
modRepo = Vars.mods.locateMod(modName).getRepo();
hjsonUrl = "https://raw.githubusercontent.com/0rang30rang3/implosion/main/mod.hjson";

Events.on(ClientLoadEvent, (event) => {
    localVersion = json.get("version");
    Log.info("Local mod version: " + localVersion);
    req = new Http.get(
        hjsonUrl,
        (res) => {
            resp = res.getResultAsString();
            json = Jval.read(resp);
            repoVersion = Vars.mods.getMod(modName).meta.version;
            Log.info("Repository mod version: " + repoVersion);

            if (!localVersion.equals(repoVersion)) {
                try {
                    Vars.ui.showMenu(
                        "TEST",
                        "TEXT GOES HERE",
                        [
                            ["[red]Ok"],
                            ["[green]Update"]
                        ],
                        (option) => {
                            if (option == 1) {
                                Vars.ui.mods.githubImportMod(modRepo);

                                var shown = false;
                                Timer.schedule(
                                    () => {
                                        if (Vars.mods.requiresReload() && !shown) {
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
            }
        }
    );
});
