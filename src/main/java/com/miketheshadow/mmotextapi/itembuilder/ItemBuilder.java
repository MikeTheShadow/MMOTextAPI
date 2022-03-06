package com.miketheshadow.mmotextapi.itembuilder;

import com.miketheshadow.mmotextapi.text.Grade;
import com.miketheshadow.mmotextapi.text.ItemStat;
import com.miketheshadow.mmotextapi.utils.ColorConstants;
import com.miketheshadow.mmotextapi.utils.Pair;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.sort;

public class ItemBuilder implements IItemType {

    private final ItemStack stack;
    private final List<String> lore = new ArrayList<>();
    @NotNull
    private final ItemMeta meta;
    private final String name;
    private Grade grade = Grade.BASIC;
    private String description;
    private final List<Pair<ItemStat>> statPairs = new ArrayList<>();
    private final PersistentDataContainer persistentDataContainer;
    private final Plugin plugin;

    public ItemBuilder(Plugin plugin, Material material, String name) {
        this.stack = new ItemStack(material, 1);
        this.meta = Objects.requireNonNull(stack.getItemMeta());
        this.name = name;
        this.plugin = plugin;
        if (meta == null) throw new RuntimeException("Unable to find meta for " + material);
        persistentDataContainer = meta.getPersistentDataContainer();
        setGrade(Grade.BASIC);
    }

    public ItemBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public ItemBuilder setDescription(ChatColor color, String description) {
        this.description = color + description;
        persistentDataContainer.set(new NamespacedKey(plugin, "description"), PersistentDataType.STRING, description);
        return this;
    }

    public ItemBuilder addStat(ItemStat itemStat, int value) {
        statPairs.add(new Pair<>(itemStat, value));
        persistentDataContainer.set(new NamespacedKey(plugin, itemStat.name()), PersistentDataType.INTEGER, value);
        return this;
    }

    public ItemBuilder addStatMap(HashMap<ItemStat, Integer> stats) {
        stats.forEach((stat, amount) -> {
            statPairs.add(new Pair<>(stat, amount));
            persistentDataContainer.set(new NamespacedKey(plugin, stat.name()), PersistentDataType.INTEGER, amount);
        });
        return this;
    }

    public ItemBuilder setGrade(Grade newGrade) {
        grade = newGrade;
        persistentDataContainer.set(new NamespacedKey(plugin, "grade"), PersistentDataType.STRING, newGrade.name());
        return this;
    }

    /*
    Converting the builder to an Item here.
     */
    public ItemStack build() {

        addTextToLore(getItemType());
        addTextToLore(grade.getColorCode() + grade.getReadableName());
        addTextToLore(""); // empty spacing

        // Add equipment points here

        // Add attack speed/dura/weapon type/dps/ etc here

        // add gems here

        // add upgradability status here

        if (this instanceof FoodItemBuilder foodItemBuilder) {
            addTextToLore("This is a rank ", foodItemBuilder.getRank(), " food item");
            addTextToLore("");
            addTextToLore("Cast Time: ", foodItemBuilder.getCastTime());
            addTextToLore("Cooldown: ", foodItemBuilder.getCoolDown());
            addTextToLore("");
            addTextToLore("A food item that lasts ", foodItemBuilder.getDuration());
            addTextToLore("and gives the effects below");
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

        // Add made by here

        meta.setLore(lore);
        meta.setDisplayName(grade.getColorCode() + name);
        stack.setItemMeta(meta);

        return stack;
    }

    private void addFormattedParagraph(String paragraph) {

        StringBuilder builder = new StringBuilder();

        String[] strings = paragraph.split(" ");

        for (String string : strings) {

            builder.append(string).append(" ");
            if (builder.length() > 30) {
                lore.add(ChatColor.RESET + "" + ChatColor.WHITE + builder);
                builder = new StringBuilder();
            }

        }
        if (builder.length() > 0) lore.add(ChatColor.RESET + "" + ChatColor.WHITE + builder);
    }

    private void addTextToLore(String... texts) {

        if (texts[0].equals("")) {
            lore.add("");
            return;
        }

        StringBuilder quickBuilder = new StringBuilder();

        for (String text : texts) {
            quickBuilder.append(ChatColor.RESET).append(ChatColor.WHITE).append(text);
        }
        lore.add(quickBuilder.toString());
    }

    @Override
    public String getItemType() {
        return "Item";
    }

    public PersistentDataContainer getPersistentDataContainer() {
        return this.persistentDataContainer;
    }
}
