package com.tristenallen.actiondialogue.dialogue.lines;

import org.bukkit.configuration.ConfigurationSection;

public class Choice {
    private String message;
    private ConfigurationSection conditions;

    public Choice(ConfigurationSection choice) {
        message = choice.getString("message");
        conditions = choice.getConfigurationSection("conditions");
    }

    public String getMessage() {
        return message;
    }

    public ConfigurationSection getConditions() {
        return conditions;
    }
}
