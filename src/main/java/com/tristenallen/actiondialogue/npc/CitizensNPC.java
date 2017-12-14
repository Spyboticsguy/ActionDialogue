package com.tristenallen.actiondialogue.npc;

import com.tristenallen.actiondialogue.api.event.NPCClickedEvent;
import com.tristenallen.actiondialogue.api.event.NPCLeftClickedEvent;
import com.tristenallen.actiondialogue.api.event.NPCRightClickedEvent;
import net.citizensnpcs.api.event.NPCClickEvent;
import net.citizensnpcs.api.event.NPCLeftClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class CitizensNPC implements NPC {
    private String name;
    private int id;

    protected CitizensNPC(net.citizensnpcs.api.npc.NPC npc) {
        this.name = npc.getName();
        this.id = npc.getId();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CitizensNPC) {
            if (this.id == ((CitizensNPC) o).id) {
                return true;
            }
        }
        return false;
    }

    @EventHandler
    public void onCitizensClick(NPCClickEvent event) {
        if (event.getNPC().getId() == id) {
            NPCClickedEvent clickEvent;
            if (event instanceof NPCLeftClickEvent) {
                clickEvent = new NPCLeftClickedEvent(this, event.getClicker());
            } else {
                clickEvent = new NPCRightClickedEvent(this, event.getClicker());
            }
            Bukkit.getPluginManager().callEvent(clickEvent);
        }
    }
}
