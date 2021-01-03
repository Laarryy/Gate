package dev.laarryy.gate.api.models.player;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.UUID;

public abstract class AbstractPlayer {
    private final UUID uuid;
    private final String name;
    private boolean passwordCheck;

    protected AbstractPlayer(@NonNull UUID uuid, String name, boolean passwordCheck) {
        this.uuid = uuid;
        this.name = name == null ? fetchName(uuid) :name;
        this.passwordCheck = passwordCheck;
    }

    public @NonNull String getName() { return name; }

    public boolean passwordCheck() { return passwordCheck; }

    public @NonNull UUID getUuid() { return uuid; }

    protected abstract @Nullable String fetchName(@NonNull UUID uuid);

    public String toString() {
        return "AbstractPlayer{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", passwordCheck=" + passwordCheck +
                '}';
    }
}
