package com.miketheshadow.mmotextapi.itembuilder;

import com.miketheshadow.mmotextapi.text.Grade;
import com.miketheshadow.mmotextapi.text.ItemStat;
import com.miketheshadow.mmotextapi.utils.ColorConstants;
import com.miketheshadow.mmotextapi.utils.GearScoreFromStats;
import com.miketheshadow.mmotextapi.utils.Pair;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

import static java.util.Collections.sort;

public class ToolItemBuilder extends ItemBuilder {

    HashMap<ItemStat, Integer> playerStats;
    @Nullable
    Player crafter;

    public ToolItemBuilder(Plugin plugin, Material material, String name, @Nullable Player creator, HashMap<ItemStat, Integer> playerStats) {
        super(plugin, material, name);
        this.playerStats = playerStats;
        this.crafter = creator;
    }

    public HashMap<ItemStat, Integer> getPlayerStats() {
        return playerStats;
    }

    public void setPlayerStats(HashMap<ItemStat, Integer> playerStats) {
        this.playerStats = playerStats;
    }

    @Override
    public ItemStack build() {

        addTextToLore(getItemType());
        addTextToLore(grade.getColorCode() + grade.getReadableName());
        addTextToLore("");

        // Make sure the PDC contains all the right values for all the item stats
        for (ItemStat stat : ItemStat.values()) {

            int result = playerStats.getOrDefault(stat, 0);
            if (result > 0) {
                persistentDataContainer.set(stat.getNameSpacedKey(plugin),
                        PersistentDataType.INTEGER,
                        result);
            }

        }

        // Equipment point stuff
        for (Pair<ItemStat> stat : statPairs) {
            playerStats.put(stat.getKey(), stat.getValue());
        }
        int score = GearScoreFromStats.gearScoreFromMap(playerStats);
        String scoreText = ColorConstants.NUMBER_CONSTANT + "" + score;

        // Add attack speed
        int attackDamage = playerStats.getOrDefault(ItemStat.HANDLING, 0);
        if (attackDamage > 0) {
            addTextToLore("DPS ", ColorConstants.NUMBER_CONSTANT + "" + attackDamage);
            addTextToLore("");
        }

        // Durability dura/weapon type/dps/ etc here
        int durability = playerStats.getOrDefault(ItemStat.DURABILITY,0);

        if(durability > 0) {
            addTextToLore("[",
                    ColorConstants.NUMBER_CONSTANT + "" + durability,
                    "/",
                    ColorConstants.NUMBER_CONSTANT + "" + durability,
                    "]");
            addTextToLore("");
        }

        if(score > 0) {
            addTextToLore("GS: ", scoreText);
            addTextToLore("");
        }

        // add gems here

        // add upgradability status here
        Grade finalGrade = Grade.values()[Grade.values().length - 1];
        if(grade != finalGrade) {
            addTextToLore(ColorConstants.NUMBER_CONSTANT + "Upgradable");
            addTextToLore("");
        }

        if (!statPairs.isEmpty()) {
            sort(statPairs);
            for (Pair<ItemStat> stat : statPairs) {
                addTextToLore(
                        ColorConstants.BONUS_STAT_GREEN +
                                stat.getKey().getReadableName() +
                                ": " + stat.getValue());

            }
            addTextToLore("");
        }

        if (description != null) {
            addFormattedParagraph(description);
        }

        // Crafter name
        if(crafter != null) {
            String name = crafter.getName();
            addTextToLore("Crafter: ",ColorConstants.NUMBER_CONSTANT + name);
        }

        meta.setLore(lore);
        meta.setDisplayName(grade.getColorCode() + name);
        stack.setItemMeta(meta);

        return stack;
    }
}
