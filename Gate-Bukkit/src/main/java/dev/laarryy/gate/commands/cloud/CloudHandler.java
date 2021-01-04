package dev.laarryy.gate.commands.cloud;

import cloud.commandframework.CommandManager;
import cloud.commandframework.arguments.parser.ParserParameters;
import cloud.commandframework.arguments.parser.StandardParameters;
import cloud.commandframework.bukkit.BukkitCommandManager;
import cloud.commandframework.execution.CommandExecutionCoordinator;
import cloud.commandframework.meta.CommandMeta;
import cloud.commandframework.paper.PaperCommandManager;
import dev.laarryy.gate.commands.UniversalCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import cloud.commandframework.annotations.AnnotationParser;

import java.util.function.Function;

public class CloudHandler {
    private PaperCommandManager<CommandSender> manager;
    private AnnotationParser<CommandSender> annotationParser;

    public void enable(Plugin plugin) {
        try {
            this.manager = new PaperCommandManager<>(
                    plugin,
                    CommandExecutionCoordinator.simpleCoordinator(),
                    Function.identity(),
                    Function.identity()
            );
        } catch (final Exception e) {
            throw new IllegalStateException("Failed to initialize the command manager", e);
        }
    }

    public void runRegistration() {
        final UniversalCommand instance;
        instance.register(manager);
    }

    public CommandMeta setCommandDescription(String description) {
        return CommandMeta.simple().with(CommandMeta.DESCRIPTION, description).build();
    }

    public AnnotationParser<CommandSender> getParser() {
        return this.annotationParser;
    }

    public CommandManager<CommandSender> getManager() {
        return this.manager;
    }
}
