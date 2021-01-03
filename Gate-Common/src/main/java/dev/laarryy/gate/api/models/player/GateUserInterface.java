package dev.laarryy.gate.api.models.player;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.identity.Identified;
import net.kyori.adventure.identity.Identity;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;

public interface GateUserInterface extends Identified, Identity, Audience {

    @NonNull UUID uuid();

    @NonNull String username();

    boolean hasPermission(@NonNull final String permission);

    void disconnect(final @NonNull Component reason);

    default void disconnect(final @NonNull ComponentLike reason) {
        this.disconnect(reason.asComponent());
    }

    default @NonNull Identity identity() {
        return this;
    }
}

