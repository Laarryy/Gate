package dev.laarryy.gate.listeners;

import dev.laarryy.gate.lang.GateMessages;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.checkerframework.checker.nullness.qual.NonNull;

public class BukkitPasswordCheckListener implements Listener {

    GateMessages messages;

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlayerJoin(final @NonNull PlayerJoinEvent event) {
        event.getPlayer().setWalkSpeed(0);
        event.getPlayer().setFlySpeed(0);
        if (requestPassword(event.getPlayer())) {
            event.getPlayer().setWalkSpeed(1);
            event.getPlayer().setFlySpeed(1);
        } else {
            event.getPlayer().kickPlayer(messages.getWrongPasswordKickMessage());
        }
    }

    private boolean requestPassword(Player player) {
        player.sendMessage(messages.getEnterPassword());
        return correctPasswordEntered;
    }

    private boolean correctPasswordEntered() {

    }

}
