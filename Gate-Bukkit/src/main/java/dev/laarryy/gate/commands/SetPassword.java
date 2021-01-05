package dev.laarryy.gate.commands;

import cloud.commandframework.arguments.CommandArgument;
import cloud.commandframework.arguments.standard.StringArgument;
import cloud.commandframework.paper.PaperCommandManager;
import dev.laarryy.gate.config.PasswordSettings;
import dev.laarryy.gate.permissions.GatePermissions;
import org.bukkit.command.CommandSender;

public final class SetPassword extends UniversalCommand {

    PasswordSettings passwordSettings;
    private static final CommandArgument<CommandSender, String> password = StringArgument.of("password");

    @Override
    public void register(final PaperCommandManager<CommandSender> commandManager) {
        commandManager.command(commandManager.commandBuilder("setpassword")
                .permission(GatePermissions.SET_PASSWORD)
                .argument(password)
                .handler(action ->
                        passwordSettings.setPassword(action.get(password))
                ));
    }
}
