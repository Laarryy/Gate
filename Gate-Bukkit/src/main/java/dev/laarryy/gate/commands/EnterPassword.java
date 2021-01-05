package dev.laarryy.gate.commands;

import cloud.commandframework.arguments.CommandArgument;
import cloud.commandframework.arguments.standard.StringArgument;
import cloud.commandframework.paper.PaperCommandManager;
import dev.laarryy.gate.api.models.player.AbstractPlayer;
import dev.laarryy.gate.config.PasswordSettings;
import dev.laarryy.gate.listeners.BukkitPasswordCheckListener;
import dev.laarryy.gate.models.BukkitUser;
import dev.laarryy.gate.utils.PasswordCheckUtil;
import dev.laarryy.gate.utils.SetCorrectPassword;
import org.bukkit.command.CommandSender;

public class EnterPassword extends UniversalCommand {

    PasswordSettings passwordSettings;
    PasswordCheckUtil passwordCheck;
    SetCorrectPassword setCorrectPassword;
    private static final CommandArgument<CommandSender, String> password = StringArgument.of("password");

    @Override
    public void register(final PaperCommandManager<CommandSender> commandManager) {
        commandManager.command(commandManager.commandBuilder("password")
                .argument(password)
                .handler(action -> checkIfRightPassword(action.get(password))
                ));
    }

    private void checkIfRightPassword(String attempt) {
        if (passwordCheck.checkPassword(attempt)) {
            setCorrectPassword.setCorrectPassword();
        }
    }
}