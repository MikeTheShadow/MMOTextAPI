package com.miketheshadow.mmotextapi.text;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;

public enum ItemStat {
    AGILITY("Agility"),
    ATTACK_DAMAGE("Damage"),
    ATTACK_SPEED("Attack Speed"),
    BLOCK_RATE("Block Rate"),
    BONUS_HEALTH("Bonus Health"),
    CRITICAL_DAMAGE("Critical Damage"),
    CRITICAL_RATE("Critical Rate"),
    DAMAGE_REDUCTION("Damage Reduction"),
    DEFENSE("Defense"),
    DURABILITY("Durability"),
    FLAT_BONUS_AD("Flat Damage Bonus"),
    GRADE("Grade"),
    HANDLING("Handling"),
    INTELLIGENCE("Intelligence"),
    PARRY_RATE("Parry Rate"),
    PERCENT_BONUS_AD("% Bonus Damage"),
    PERCENT_DAMAGE_REDUCTION("% Damage reduction"),
    SHIELD_DEFENSE_PEN("Shield Defense Penetration"),
    SHIELD_DEFENSE_PEN_RATE("Shield Defense Penetration Rate"),
    STAMINA("Stamina"),
    STRENGTH("Strength");

    final String readableName;

    ItemStat(String readableName) {
        this.readableName = readableName;
    }

    public String getReadableName() {
        return readableName;
    }

    public NamespacedKey getNameSpacedKey(Plugin plugin) {
        return new NamespacedKey(plugin, this.name());
    }
}
