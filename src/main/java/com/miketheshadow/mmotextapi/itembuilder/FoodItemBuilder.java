package com.miketheshadow.mmotextapi.itembuilder;

import com.miketheshadow.mmotextapi.text.ItemStat;
import com.miketheshadow.mmotextapi.utils.ColorConstants;
import com.miketheshadow.mmotextapi.utils.Pair;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import static java.util.Collections.sort;

public class FoodItemBuilder extends ItemBuilder {

    private final int rank;
    private final double castTime;
    private final double coolDown;
    private final int duration;
    private String itemType = "Food";

    public FoodItemBuilder(Plugin plugin, Material material, String name, int rank, double castTime, double coolDown, int duration) {
        super(plugin,material, name);
        this.rank = rank;
        this.castTime = castTime;
        this.coolDown = coolDown;
        this.duration = duration;

        PersistentDataContainer container = this.getPersistentDataContainer();
        container.set(new NamespacedKey(plugin, "rank"), PersistentDataType.INTEGER, this.rank);
    }

    public String getCastTime() {
        return ColorConstants.NUMBER_CONSTANT + "" + castTime + " seconds";
    }

    public String getCoolDown() {
        return ColorConstants.NUMBER_CONSTANT + "" + coolDown + " seconds";
    }

    public String getRank() {
        return ColorConstants.NUMBER_CONSTANT + "" + rank;
    }

    public String getDuration() {
        return ColorConstants.NUMBER_CONSTANT + "" + duration + " minutes";
    }

    @Override
    public String getItemType() {
        return itemType;
    }

    public FoodItemBuilder setItemType(String itemType) {
        this.itemType = itemType;
        return this;
    }

}
