package dev.laarryy.gate.config;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.ScopedConfigurationNode;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.ObjectMapper;
import org.spongepowered.configurate.objectmapping.meta.Comment;
import org.spongepowered.configurate.serialize.SerializationException;
import org.spongepowered.configurate.yaml.YamlConfigurationLoader;

import java.nio.file.Path;
import java.nio.file.Paths;

public final class ConfigUtil {

    public void reloadConfig() throws ConfigurateException {
        final Path file = Paths.get("config.yml");
        final YamlConfigurationLoader loader = YamlConfigurationLoader.builder()
                .defaultOptions(configurationOptions -> configurationOptions.shouldCopyDefaults(true))
                .path(file)
                .build();

        final CommentedConfigurationNode node = loader.load();
        final GateConfiguration config = GateConfiguration.loadFrom(node);

        config.saveTo(node);
        loader.save(node);
    }

    @ConfigSerializable
    static class GateConfiguration {

        @Comment("This setting determines the password")
        private @Nullable PasswordNode password;

        private boolean shouldSavePassword;

        public @Nullable PasswordNode getPassword() {
            return this.password;
        }

        public void setPassword(final PasswordNode password) {
            this.password = password;
        }

        private static final ObjectMapper<GateConfiguration> MAPPER;

        static {
            try {
                MAPPER = ObjectMapper.factory().get(GateConfiguration.class);
            } catch (final SerializationException e) {
                throw new ExceptionInInitializerError(e);
            }
        }

        public static GateConfiguration loadFrom(final ConfigurationNode node) throws SerializationException {
            return MAPPER.load(node);
        }

        public <N extends ScopedConfigurationNode<N>> void saveTo(final N node) throws SerializationException {
            MAPPER.save(this, node);
        }
    }


}
