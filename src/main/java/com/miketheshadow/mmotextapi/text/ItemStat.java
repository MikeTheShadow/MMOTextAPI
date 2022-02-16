package com.miketheshadow.mmotextapi.text;

public enum ItemStat {
    INTELLIGENCE("Intelligence"),
    STAMINA("Stamina"),
    STRENGTH("Strength"),
    AGILITY("Agility");

    final String readableName;

    ItemStat(String readableName) {
        this.readableName = readableName;
    }

    public String getReadableName() {
        return readableName;
    }
}
