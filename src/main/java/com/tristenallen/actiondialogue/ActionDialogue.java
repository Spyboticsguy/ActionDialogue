package com.tristenallen.actiondialogue;

import com.tristenallen.actiondialogue.dialogue.DialogueManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ActionDialogue extends JavaPlugin {
    private DialogueManager dialogueManager;

    @Override
    public void onEnable() {
        dialogueManager = new DialogueManager(this);
    }

    @Override
    public void onDisable() {

    }
}
