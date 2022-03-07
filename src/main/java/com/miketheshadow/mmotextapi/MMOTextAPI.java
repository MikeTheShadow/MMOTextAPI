package com.miketheshadow.mmotextapi;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class MMOTextAPI extends JavaPlugin {

    public static Logger LOGGER;

    @Override
    public void onEnable() {

        LOGGER = this.getLogger();

        LOGGER.info("MMOTextAPI loaded!");
    }

    @Override
    public void onDisable() {
    }
}
