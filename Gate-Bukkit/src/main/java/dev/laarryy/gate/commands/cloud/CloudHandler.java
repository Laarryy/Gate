package dev.laarryy.gate.commands.cloud;

import cloud.commandframework.CommandManager;
import cloud.commandframework.execution.CommandExecutionCoordinator;
import cloud.commandframework.meta.CommandMeta;
import cloud.commandframework.paper.PaperCommandManager;
import dev.laarryy.gate.commands.UniversalCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import cloud.commandframework.annotations.AnnotationParser;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.function.Function;

public class CloudHandler {
    private PaperCommandManager<CommandSender> manager;
    private AnnotationParser<CommandSender> annotationParser;
    private final Logger logger = LoggerFactory.getLogger(CloudHandler.class);

    public void enable(Plugin plugin) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
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

        manager.registerAsynchronousCompletions();
        manager.registerBrigadier();
        runRegistration();
    }

    public void runRegistration() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Reflections commandsReflections = new Reflections(UniversalCommand.class);
        Set<Class<? extends UniversalCommand>> subTypes = commandsReflections.getSubTypesOf(UniversalCommand.class);
        for (Class<?> commandClass: subTypes) {
            logger.info(commandClass.getSimpleName());
            final UniversalCommand instance = (UniversalCommand) commandClass.getConstructor().newInstance();
            instance.register(manager);
        }
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
