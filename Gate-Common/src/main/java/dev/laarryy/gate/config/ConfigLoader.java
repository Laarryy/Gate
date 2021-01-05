package dev.laarryy.gate.config;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.hocon.HoconConfigurationLoader;
import org.spongepowered.configurate.loader.AbstractConfigurationLoader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class ConfigLoader<L extends AbstractConfigurationLoader<CommentedConfigurationNode>> {
    private final @NonNull Class<L> format;

    public ConfigLoader(final @NonNull Class<L> format) {
        this.format = format;
    }

    public <B extends AbstractConfigurationLoader.Builder<?, L>> CommentedConfigurationNode loadConfig(final @NonNull String file) throws ConfigurateException {
        final B builder;

            builder = (B) HoconConfigurationLoader.builder().prettyPrinting(true);


        final File config = getFile(new File("config.conf"));
        final L loader = this.loadConfigFile(builder, config);
        final CommentedConfigurationNode node = loader.load();

        if (!config.exists()) {
            loader.save(node);
        }

        return node;
    }



    private <B extends AbstractConfigurationLoader.Builder<?, L>> L loadConfigFile(final B builder, final @NonNull File config) {
        return builder
                .defaultOptions(configurationOptions -> configurationOptions.shouldCopyDefaults(true))
                .file(config)
                .build();
    }

    private @NonNull File getFile(final @NonNull File file) {
        if (file.exists()) {
            return file;
        }

        final String resource = "/" + file.getName();
        final InputStream inputStream = this.getClass().getResourceAsStream(resource);

        if (inputStream == null) {
            return file;
        }

        return this.copyFileToDir(inputStream, file);
    }

    public @NonNull File copyFileToDir(final @NonNull InputStream source, final @NonNull File file) {
        try {
            Files.copy(source, file.toPath());
        } catch (final IOException ex) {
            ex.printStackTrace();
        }

        return file;
    }
}
