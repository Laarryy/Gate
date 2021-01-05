package dev.laarryy.gate.api.models.player;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;

import java.util.UUID;

@ConfigSerializable
public abstract class AbstractPlayer implements Player {
    final UUID uuid;
    final String name;

    AbstractPlayer() {
        this.uuid = null;
        this.name = null;
    }

    protected AbstractPlayer(@NonNull UUID uuid, String name, boolean passwordCheck) {
        this.uuid = uuid;
        this.name = name == null ? fetchName(uuid) : name;
    }

    protected AbstractPlayer(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public @NonNull String getName() { return name; }

    public @NonNull UUID getUuid() { return uuid; }

    protected abstract @Nullable String fetchName(@NonNull UUID uuid);

    public String toString() {
        return "AbstractPlayer{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                '}';
    }
}
