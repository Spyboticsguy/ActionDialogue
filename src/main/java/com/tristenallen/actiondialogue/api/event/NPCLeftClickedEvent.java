package com.tristenallen.actiondialogue.api.event;

import com.tristenallen.actiondialogue.npc.NPC;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public class NPCLeftClickedEvent extends NPCClickedEvent {
    private static final HandlerList handlers = new HandlerList();
    public NPCLeftClickedEvent(NPC npc, Player player) {
        super(npc, player);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
