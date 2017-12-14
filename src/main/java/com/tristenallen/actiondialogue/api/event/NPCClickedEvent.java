package com.tristenallen.actiondialogue.api.event;

import com.tristenallen.actiondialogue.npc.NPC;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class NPCClickedEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private NPC npc;
    private Player player;

    public NPCClickedEvent(NPC npc, Player player) {
        this.npc = npc;
        this.player = player;
    }

    public NPC getNpc() {
        return npc;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
