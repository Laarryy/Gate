package dev.laarryy.gate.commands;

import cloud.commandframework.CommandManager;
import cloud.commandframework.context.CommandContext;
import dev.laarryy.gate.api.models.player.GateUser;
import dev.laarryy.gate.api.models.player.GateUserInterface;
import dev.laarryy.gate.commands.cloud.PasswordArgument;
import dev.laarryy.gate.permissions.GatePermissions;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class SetPassword extends UniversalCommand {


    @Override
    public void register(final @NonNull CommandManager<GateUser> commandManager) {
        commandManager.command(commandManager.commandBuilder("setpassword")
                .permission(GatePermissions.SET_PASSWORD)
                .argument(PasswordArgument, true)
                .handler(this::execute));
    }

    private void execute(final @NonNull CommandContext<GateUserInterface> commandContext) {
        final GateUser user = commandContext.get("user");

        this.
    }
}
