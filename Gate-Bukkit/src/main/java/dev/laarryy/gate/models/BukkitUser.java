package dev.laarryy.gate.models;

import dev.laarryy.gate.api.models.player.AbstractPlayer;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.UUID;

public class BukkitUser extends AbstractPlayer {
    public BukkitUser(@NonNull UUID uuid, String name, boolean hasPassword) {
        super(uuid, name, hasPassword);
    }

    protected BukkitUser(UUID uuid, String name) {
        super(uuid, name);
    }

    @Override
    protected @Nullable String fetchName(@NonNull UUID uuid) {
        return null;
    }

    @Override
    public boolean hasPassword() {
        return false;
    }
}
