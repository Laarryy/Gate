package dev.laarryy.gate.api.models.player;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.io.Serializable;
import java.util.UUID;

public interface Player extends Serializable {

    @NonNull UUID getUuid();

    @Nullable String getName();

    boolean hasPassword();

}
