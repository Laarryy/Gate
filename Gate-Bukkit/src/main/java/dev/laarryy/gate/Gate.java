package dev.laarryy.gate;

import dev.laarryy.gate.config.ConfigLoader;
import dev.laarryy.gate.config.GateConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import dev.laarryy.gate.commands.cloud.CloudHandler;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.hocon.HoconConfigurationLoader;

import java.lang.reflect.InvocationTargetException;

public final class Gate extends JavaPlugin {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final Plugin plugin = this;

    CloudHandler cloudHandler = new CloudHandler();
    private GateConfiguration gateConfiguration;


    @Override
    public void onEnable() {
        try {
            cloudHandler.enable(plugin);
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        logger.info("Starting up!");
        GateConfiguration config = new GateConfiguration();
        try {
            config.loadConfig(this.getDataFolder() + "/config.conf");
        } catch (ConfigurateException e) {
            e.printStackTrace();
        }

        this.loadConfig();
    }

    @Override
    public void onDisable() {
        loadConfig();
    }

    private void loadConfig() {
        this.getDataFolder().mkdir();
        try {
            final ConfigLoader<HoconConfigurationLoader> loader = new ConfigLoader<>(HoconConfigurationLoader.class);
            this.gateConfiguration = GateConfiguration.loadFrom(loader.loadConfig(this.getDataFolder() + "/config.conf"));
        } catch (final ConfigurateException e) {
            e.printStackTrace();
        }
    }

}
