package com.miketheshadow.mmotextapi.utils;

import com.miketheshadow.mmotextapi.text.ItemStat;
import org.bukkit.entity.Item;

import java.util.ArrayList;
import java.util.List;

public class StatUtils {

    public static final List<ItemStat> BASE_STATS = new ArrayList<>() {
        {
            add(ItemStat.STAMINA);
            add(ItemStat.INTELLIGENCE);
            add(ItemStat.STRENGTH);
            add(ItemStat.AGILITY);
        }
    };

}
