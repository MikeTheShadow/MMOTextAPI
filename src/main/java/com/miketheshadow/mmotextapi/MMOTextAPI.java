package com.miketheshadow.mmotextapi;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class MMOTextAPI extends JavaPlugin implements Listener {

    private static MMOTextAPI INSTANCE;
    public static Logger LOGGER;

    @Override
    public void onEnable() {

        LOGGER = this.getLogger();
        INSTANCE = this;

//        Bukkit.getPluginManager().registerEvents(this,this);
//
//        LOGGER.info(ChatColor.YELLOW + "Warning this is a debug build!");

        LOGGER.info("MMOTextAPI loaded!");
    }

    @Override
    public void onDisable() {

    }

//    @EventHandler
//    public void onPlayerJoinEvent(PlayerJoinEvent event) {
//
//        Player player = Bukkit.getPlayer("test");
//
//        if(player != null) player.sendMessage("test");
//
//
//        ItemStack stack =
//                new FoodItemBuilder(
//                        Material.COOKED_BEEF,
//                        "Common Steak",
//                        1, 3, 18,18)
//                        .setDescription("A steak so common you might actually be able to hold it down!")
//                        .addStat(ItemStat.AGILITY, 50)
//                        .addStat(ItemStat.STAMINA, 25).build();
//
//        ItemStack stack2 =
//                new FoodItemBuilder(
//                        Material.PORKCHOP,
//                        "PorkChop Of Legendary Porkness",
//                        7, 3, 30,45)
//                        .setDescription(
//                                "Eating this might turn your bones into liquid energy. Hopefully it's worth it.")
//                        .addStat(ItemStat.STRENGTH,250)
//                        .setGrade(Grade.EMPYREAN)
//                        .addStat(ItemStat.STAMINA, 50).build();
//
//        event.getPlayer().getInventory().addItem(stack);
//        event.getPlayer().getInventory().addItem(stack2);
//
//    }

    public static MMOTextAPI getINSTANCE() {
        return INSTANCE;
    }
}
