package com.tristenallen.actiondialogue.dialogue.lines;

public enum ChoiceType {
    L ("L"),
    R ("R"),
    SL ("SL"),
    SR ("SR");

    private String name;
    ChoiceType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
