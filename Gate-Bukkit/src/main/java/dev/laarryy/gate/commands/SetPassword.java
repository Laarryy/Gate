package dev.laarryy.gate.commands;

import cloud.commandframework.arguments.CommandArgument;
import cloud.commandframework.arguments.standard.StringArgument;
import cloud.commandframework.context.CommandContext;
import cloud.commandframework.paper.PaperCommandManager;
import dev.laarryy.gate.api.models.player.GateUserInterface;
import dev.laarryy.gate.config.PasswordNode;
import dev.laarryy.gate.models.BukkitUser;
import dev.laarryy.gate.permissions.GatePermissions;
import org.bukkit.command.CommandSender;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class SetPassword extends UniversalCommand {

    PasswordNode passwordNode;
    private static final CommandArgument<CommandSender, String> password = StringArgument.of("password");

    @Override
    public void register(final PaperCommandManager<CommandSender> commandManager) {
        commandManager.command(commandManager.commandBuilder("setpassword")
                .permission(GatePermissions.SET_PASSWORD)
                .argument(password)
                .handler(action ->
                        passwordNode.setPassword(action.get(password))


                ));
    }

    private void execute(final @NonNull CommandContext<GateUserInterface> commandContext) {
        final BukkitUser user = commandContext.get("user");
    }
}
