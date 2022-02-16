package com.miketheshadow.mmotextapi.text;

import net.md_5.bungee.api.ChatColor;

public enum Grade {

    CRUDE("Crude", "#80817e"),
    BASIC("Basic", "#FFFFFF"),
    GRAND("Grand", "#7DB946"),
    RARE("Rare", "#5481AB"),
    ENIGMATIC("Enigmatic", "#EB00FF"),
    LEGENDARY("Legendary", "#D52A30"),
    MYTHICAL("Mythical", "#9A4BB4"),
    EMPYREAN("Empyrean", "#DFAF37");

    final String readableName;
    final ChatColor colorCode;

    Grade(String readableName, String colorCode) {
        this.readableName = readableName;
        this.colorCode = ChatColor.of(colorCode);
    }

    public ChatColor getColorCode() {
        return colorCode;
    }

    public String getReadableName() {
        return readableName;
    }
}
