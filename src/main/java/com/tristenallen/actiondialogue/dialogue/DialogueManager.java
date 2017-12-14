package com.tristenallen.actiondialogue.dialogue;

import com.tristenallen.actiondialogue.ActionDialogue;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DialogueManager {
    private ActionDialogue plugin;
    private File scriptFolder;
    private Map<String,Script> scripts;

    public DialogueManager(ActionDialogue plugin) {
        scriptFolder = new File(plugin.getDataFolder(), "scripts");
        this.plugin = plugin;
        if (!scriptFolder.exists()) {
            plugin.getLogger().info("Scripts folder does not exist. Creating.");
            if (!scriptFolder.mkdir()) {
                plugin.getLogger().warning("Error: could not create scripts folder.");
            }
        }
        loadScripts();
    }

    public void loadScripts() {
        scripts = new HashMap<>();
        if (scriptFolder.exists()) {
            File[] scriptsFiles = scriptFolder.listFiles((File dir, String name)
                    -> name.matches(".*\\.yml"));
            if (scriptsFiles != null) {
                for (File scriptFile : scriptsFiles) {
                    String id = scriptFile.getName().substring(0, scriptFile.getName().indexOf('.'));
                    scripts.put(id, new Script(YamlConfiguration.loadConfiguration(scriptFile)));
                }
            } else {
                plugin.getLogger().warning("Error reading scripts folder.");
            }
            plugin.getLogger().info("Scripts loaded.");
        } else {
            plugin.getLogger().warning("Scripts folder did not exist!");
        }
    }

    public void reloadScripts() {
        for (String id : scripts.keySet()) {
            File scriptFile = new File(scriptFolder, id + ".yml");
            if (scriptFile.exists()) {
                scripts.put(id, new Script(YamlConfiguration.loadConfiguration(scriptFile)));
            } else {
                scripts.remove(id);
            }
        }
        plugin.getLogger().info("Scripts reloaded.");
    }

    public Script getScript(String id) {
        return scripts.get("id");
    }
}
