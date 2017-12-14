package com.tristenallen.actiondialogue.npc;

import com.tristenallen.actiondialogue.ActionDialogue;
import com.tristenallen.actiondialogue.dialogue.Script;

import java.util.Map;

public abstract class NPCProvider {
    ActionDialogue plugin;
    Map<NPC,Script> npcMappings;

    public NPCProvider(ActionDialogue plugin) {
        this.plugin = plugin;
    }

    public Script getScript(NPC npc) {
        if (null == npcMappings || npcMappings.isEmpty()) {
            plugin.getLogger().warning("No NPC mappings detected."
                    + "Check your NPC provider for errors.");
            return null;
        } else {
            return npcMappings.get(npc);
        }
    }
}
