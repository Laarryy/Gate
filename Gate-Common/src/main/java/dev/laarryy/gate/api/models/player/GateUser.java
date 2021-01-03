package dev.laarryy.gate.api.models.player;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;

public final class GateUser {

    //Console UUID if Stored
    private static final @NonNull UUID CONSOLE_UUID = new UUID(0, 0);

    //Console User

    public static final @NonNull GateUser CONSOLE = new GateUser(CONSOLE_UUID, "CONSOLE");

    private final @NonNull UUID uuid;
    private final @NonNull String username;

    public GateUser(final @NonNull UUID uuid,
                   final @NonNull String username) {
        this.uuid = uuid;
        this.username = username;
    }

    public @NonNull UUID getUuid() {
        return this.uuid;
    }

    public @NonNull String getUsername() {
        return this.username;
    }


}
