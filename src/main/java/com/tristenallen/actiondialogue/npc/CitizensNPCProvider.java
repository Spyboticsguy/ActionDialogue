package com.tristenallen.actiondialogue.npc;

import com.tristenallen.actiondialogue.ActionDialogue;
import com.tristenallen.actiondialogue.dialogue.Script;
import net.citizensnpcs.api.CitizensAPI;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class CitizensNPCProvider extends NPCProvider {
    public CitizensNPCProvider(ActionDialogue plugin) {
        super(plugin);
        File npcFile = new File(plugin.getDataFolder(), "npcs.yml");
        FileConfiguration NPCs = YamlConfiguration.loadConfiguration(npcFile);
        npcMappings = new HashMap<>();
        try {
            NPCs.save(npcFile);
        } catch (IOException e) {
            plugin.getLogger().warning("Error generating NPC file.");
        }
        for (String npc : NPCs.getKeys(false)) {
            net.citizensnpcs.api.npc.NPC citizensNPC = null;
            Script script = plugin.getDialogueManager().getScript(NPCs.getString(npc));

            try {
                int id = Integer.parseInt(npc);
                citizensNPC = CitizensAPI.getNPCRegistry().getById(id);
            } catch (NumberFormatException e) {
                for (net.citizensnpcs.api.npc.NPC namedNPC : CitizensAPI.getNPCRegistry().sorted()) {
                    if (namedNPC.getName().equals(npc)) {
                        citizensNPC = namedNPC;
                        break;
                    }
                }
            }

            if (null != citizensNPC && null != script) {
                CitizensNPC newNPC = new CitizensNPC(citizensNPC);
                npcMappings.put(newNPC, script);
                Bukkit.getPluginManager().registerEvents(newNPC, plugin);
            } else {
                plugin.getLogger().warning("Error reading NPC mapping for NPC: "
                + npc);
            }
        }
    }
}
