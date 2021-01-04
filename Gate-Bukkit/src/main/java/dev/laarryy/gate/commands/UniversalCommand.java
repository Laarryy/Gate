package dev.laarryy.gate.commands;

import cloud.commandframework.paper.PaperCommandManager;
import org.bukkit.command.CommandSender;

public abstract class UniversalCommand {

    public abstract void register(final PaperCommandManager<CommandSender> commandManager);

}
