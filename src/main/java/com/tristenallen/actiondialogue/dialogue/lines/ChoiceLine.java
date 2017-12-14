package com.tristenallen.actiondialogue.dialogue.lines;

import org.bukkit.configuration.ConfigurationSection;

import java.util.Map;

public class ChoiceLine {
    private Map<ChoiceType,Choice> choices;

    public ChoiceLine(ConfigurationSection choice) {
        for (String type : choice.getKeys(false)) {
            choices.put(ChoiceType.valueOf(type), new Choice(choice.getConfigurationSection(type)));
        }
    }
}
