package dev.laarryy.gate.commands;

import cloud.commandframework.CommandManager;
import cloud.commandframework.arguments.CommandArgument;
import cloud.commandframework.arguments.standard.StringArgument;
import cloud.commandframework.context.CommandContext;
import dev.laarryy.gate.api.models.player.GateUser;
import dev.laarryy.gate.api.models.player.GateUserInterface;
import dev.laarryy.gate.config.PasswordNode;
import dev.laarryy.gate.permissions.GatePermissions;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class SetPassword extends UniversalCommand {

    PasswordNode passwordNode;
    private static final CommandArgument<GateUser, String> password = StringArgument.of("password");

    @Override
    public void register(final @NonNull CommandManager<GateUser> commandManager) {
        commandManager.command(commandManager.commandBuilder("setpassword")
                .permission(GatePermissions.SET_PASSWORD)
                .argument(password)
                .handler(setPassword -> passwordNode.setPassword(setPassword.get(password))));
    }

    private void execute(final @NonNull CommandContext<GateUserInterface> commandContext) {
        final GateUser user = commandContext.get("user");
    }
}
