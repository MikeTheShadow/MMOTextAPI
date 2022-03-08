package com.miketheshadow.mmotextapi.utils;

import com.miketheshadow.mmotextapi.text.ItemStat;

import java.util.HashMap;
import java.util.Map;

public class GearScoreFromStats {

    public static int gearScoreFromMap(HashMap<ItemStat, Integer> map) {

        int score = 0;

        for (Map.Entry<ItemStat, Integer> entry : map.entrySet()) {

            ItemStat stat = entry.getKey();
            int value = entry.getValue();

            if (StatUtils.BASE_STATS.contains(stat)) {
                score += value * 5;
            } else if (stat.equals(ItemStat.GRADE)) {
                score += value * 25; // TODO if a + system is added then multiply it here
            }
        }

        int handling = map.getOrDefault(ItemStat.HANDLING,0);

        if(handling == 2) {
            score *= 2;
        }

        return score;
    }


}
