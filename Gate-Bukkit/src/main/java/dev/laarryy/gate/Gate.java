package dev.laarryy.gate;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import dev.laarryy.gate.commands.cloud.CloudHandler;

public final class Gate extends JavaPlugin {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final Plugin plugin;

    public Gate(@NonNull Plugin plugin) {
        this.plugin = plugin;
    }
    CloudHandler cloudHandler;


    @Override
    public void onEnable() {
    cloudHandler.enable(plugin);
    logger.info("Starting up!");


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
