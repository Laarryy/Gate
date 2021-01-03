package dev.laarryy.gate.api.models.player;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface PlayerManager {

    @NonNull CompletableFuture<Player> getPlayer(@NonNull UUID uuid);

    @NonNull CompletableFuture<Player> getPlayer(@NonNull String username);

    @NonNull CompletableFuture<Void> savePlayer(@NonNull Player player);

    default @NonNull CompletableFuture<Void> deletePlayer(@NonNull Player player) { return deletePlayer(player.getUuid()); }

    @NonNull CompletableFuture<Void> deletePlayer(@NonNull UUID uuid);

    @NonNull default CompletableFuture<Boolean> checkPassword(@NonNull Player player, boolean useStorage) { return checkPassword(player.getUuid(), useStorage); }

    @NonNull CompletableFuture<Boolean> checkPassword(@NonNull UUID uuid, boolean useStorage);
}
