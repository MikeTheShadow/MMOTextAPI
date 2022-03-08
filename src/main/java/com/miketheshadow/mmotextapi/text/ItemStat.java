package com.miketheshadow.mmotextapi.text;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;

public enum ItemStat {
    INTELLIGENCE("Intelligence"),
    STAMINA("Stamina"),
    STRENGTH("Strength"),
    AGILITY("Agility"),
    DAMAGE("Damage"),
    ATTACK_SPEED("Attack Speed"),
    CRITICAL_RATE("Critical Rate"),
    CRITICAL_DAMAGE("Critical Damage"),
    DAMAGE_REDUCTION("Damage Reduction"),
    DEFENSE("Defense"),
    BLOCK_RATE("Block Rate"),
    PARRY_RATE("Parry Rate"),
    SHIELD_DEFENSE_PEN_RATE("Shield Defense Penetration Rate"),
    SHIELD_DEFENSE_PEN("Shield Defense Penetration");

    public static float convertStrengthToDamage(float strength) {
        return (float) (strength * .2);
    }

    public static float convertStaminaToHealth(float stamina) {
        return stamina * 12;
    }

    final String readableName;

    ItemStat(String readableName) {
        this.readableName = readableName;
    }

    public String getReadableName() {
        return readableName;
    }

    public NamespacedKey getNameSpacedKey(Plugin plugin) {
        return new NamespacedKey(plugin,this.name());
    }
}
