package dev.laarryy.gate;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.plugin.Plugin;

@Plugin(
        id = "gate",
        name = "Gate Sponge",
        version = "1.0.0-SNAPSHOT",
        description = "Ore for Password Protecting A Minecraft Server",
        authors = {
                "Laarryy"
        }
)
public class Gate {

    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
    }
}
