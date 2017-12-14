package com.tristenallen.actiondialogue.dialogue;

import com.tristenallen.actiondialogue.dialogue.lines.ChoiceLine;
import com.tristenallen.actiondialogue.dialogue.lines.Line;
import org.bukkit.configuration.Configuration;

import java.util.HashMap;
import java.util.Map;

public class Script {
    private Map<String,Line> lines;
    private Map<String,ChoiceLine> choices;
    public Script(Configuration script) {
        lines = new HashMap<>();
        for (String line : script.getConfigurationSection("lines").getKeys(false)) {
            lines.put(line, new Line(script.getConfigurationSection("lines." + line)));
        }
        choices = new HashMap<>();
        for (String choice : script.getConfigurationSection("choices").getKeys(false)) {
            choices.put(choice, new ChoiceLine(script.getConfigurationSection("choices." + choice)));
        }
    }

    public Line getLine(String id) {
        return lines.get(id);
    }

    public ChoiceLine getChoiceLine(String id) {
        return choices.get(id);
    }
}
