package com.tristenallen.actiondialogue.npc;

import org.bukkit.event.Listener;

public interface NPC extends Listener {
    String getName();

    @Override
    int hashCode();

    @Override
    boolean equals(Object o);
}
