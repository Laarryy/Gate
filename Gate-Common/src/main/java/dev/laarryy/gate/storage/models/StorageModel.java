package dev.laarryy.gate.storage.models;

import dev.laarryy.gate.api.models.player.AbstractPlayer;
import dev.laarryy.gate.config.GateConfiguration;
import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.hocon.HoconConfigurationLoader;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.Setting;
import org.spongepowered.configurate.serialize.SerializationException;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@ConfigSerializable
public class StorageModel implements Serializable {

    @Setting
    private List<AbstractPlayer> playerList;

    public StorageModel() {
        this.playerList = null;
    }

    public static StorageModel loadFrom(final CommentedConfigurationNode node) throws SerializationException {
        return node.get(StorageModel.class);
    }

    public void saveTo(final CommentedConfigurationNode node) throws SerializationException {
        node.set(StorageModel.class, this);
    }

    public void loadConfig(String path) throws ConfigurateException {
        final Path file = Paths.get(path);
        final HoconConfigurationLoader loader = HoconConfigurationLoader.builder()
                .defaultOptions(configurationOptions -> configurationOptions.shouldCopyDefaults(true))
                .path(file)
                .build();

        final CommentedConfigurationNode node = loader.load();
        final StorageModel storage = StorageModel.loadFrom(node);

        storage.saveTo(node);
        loader.save(node);
    }
}
