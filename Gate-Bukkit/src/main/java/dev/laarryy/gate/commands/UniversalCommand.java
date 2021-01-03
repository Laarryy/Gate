package dev.laarryy.gate.commands;

import cloud.commandframework.CommandManager;
import dev.laarryy.gate.api.models.player.GateUser;
import org.checkerframework.checker.nullness.qual.NonNull;

public abstract class UniversalCommand {

    public abstract void register(final @NonNull CommandManager<@NonNull GateUser> commandManager);

}
