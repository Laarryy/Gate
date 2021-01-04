package dev.laarryy.gate.config;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.ScopedConfigurationNode;
import org.spongepowered.configurate.hocon.HoconConfigurationLoader;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.ObjectMapper;
import org.spongepowered.configurate.objectmapping.meta.Comment;
import org.spongepowered.configurate.objectmapping.meta.Setting;
import org.spongepowered.configurate.serialize.SerializationException;
import org.spongepowered.configurate.serialize.TypeSerializer;
import org.spongepowered.configurate.serialize.TypeSerializerCollection;

import java.nio.file.Path;
import java.nio.file.Paths;

@ConfigSerializable
public final class GateConfiguration {

    public static GateConfiguration loadFrom(final CommentedConfigurationNode node) throws SerializationException {
        return node.get(GateConfiguration.class);
    }

    public void saveTo(final CommentedConfigurationNode node) throws SerializationException {
        node.set(GateConfiguration.class, this);
    }

    public void loadConfig(String path) throws ConfigurateException {
        final Path file = Paths.get(path);
        final HoconConfigurationLoader loader = HoconConfigurationLoader.builder()
                .defaultOptions(configurationOptions -> configurationOptions.shouldCopyDefaults(true))
                .path(file)
                .build();

        final CommentedConfigurationNode node = loader.load();
        final GateConfiguration config = GateConfiguration.loadFrom(node);

        config.saveTo(node);
        loader.save(node);

    }

    @Setting
    @Comment("This setting determines the password")
    PasswordNode password = new PasswordNode();

    @Setting
    @Comment("Set this to true if Gate should no longer require password on login after the first time") // TODO: Ensure to check that it's the same password as the current one when true
    boolean shouldSavePassword;

}



