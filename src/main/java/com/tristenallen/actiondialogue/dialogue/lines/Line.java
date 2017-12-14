package com.tristenallen.actiondialogue.dialogue.lines;

import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.Map;

public class Line {
    private String message;
    private Map<String,ConfigurationSection> links;
    private ConfigurationSection effects;

    public Line(ConfigurationSection line) {
        message = line.getString("message");
        links = new HashMap<>();
        for (String link : line.getConfigurationSection("links").getKeys(false)) {
            links.put(link, line.getConfigurationSection("links." + link + ".conditions"));
        }
        effects = line.getConfigurationSection("effects");
    }

    public String getMessage() {
        return message;
    }

    public ConfigurationSection getEffects() {
        return effects;
    }

    public Map<String, ConfigurationSection> getLinks() {
        return new HashMap<>(links);
    }
}
