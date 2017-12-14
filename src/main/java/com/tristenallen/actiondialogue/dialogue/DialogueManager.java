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
            scriptFolder.mkdir();
        }
        loadScripts();
    }

    public void loadScripts() {
        scripts = new HashMap<>();
        for (File scriptFile : scriptFolder.listFiles((File dir, String name)
                -> name.matches(".*\\.yml"))) {
            String id = scriptFile.getName().substring(0, scriptFile.getName().indexOf('.'));
            scripts.put(id, new Script(YamlConfiguration.loadConfiguration(scriptFile)));
        }
        plugin.getLogger().info("Scripts loaded.");
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
        plugin.getLogger().info("Scripts reloaded");
    }

    public Script getScript(String id) {
        return scripts.get("id");
    }
}
