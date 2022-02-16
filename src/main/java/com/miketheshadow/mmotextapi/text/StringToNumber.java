package com.miketheshadow.mmotextapi.text;

import com.miketheshadow.mmotextapi.utils.TextConstants;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StringToNumber {


    public static String encaseString(String message, ChatColor background, ChatColor textColor) {

        int length = message.length();

        if (length == 0) throw new RuntimeException("Text `" + message + "` is illegal!");


        StringBuilder result = new StringBuilder(ChatColor.RESET.toString());

        result.append(textColor.toString());
        result.append(message);

        result.append(background.toString());

        for (int i = 0; i < length; i++) {
            if (i != 0) {
                result.append(TextConstants.Spacing.NEGATIVE_SPACE_8)
                        .append(TextConstants.Spacing.NEGATIVE_SPACE_5);
            } else {
                result.append(TextConstants.Spacing.NEGATIVE_CUSTOM);
                result.append(TextConstants.Spacing.NEGATIVE_SPACE_7);
            }
            result.append(TextConstants.Wood.WOOD_MIDDLE_PIECE);
        }

        result.append(TextConstants.Spacing.POSITIVE_SPACE_0_5.repeat(length * 3));

        result.append(TextConstants.Spacing.NEGATIVE_SPACE_1.repeat(13 * (length - 1)));
        result.append(TextConstants.Wood.WOOD_START_PIECE);

        return result.toString();

    }


    public static ItemStack generateTestItem(String name) {

        ItemStack stack = new ItemStack(Material.WOODEN_SWORD);

        ItemMeta meta = stack.getItemMeta();
        if (meta == null) return null;

        meta.setDisplayName(encaseString(name, ChatColor.WHITE, ChatColor.WHITE));

        stack.setItemMeta(meta);

        return stack;
    }
}
