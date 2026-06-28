package fr.cheatdetector.listeners;

import fr.cheatdetector.CheatDetectorPlugin;
import org.bukkit.event.Listener;

public class ChannelListener implements Listener {
    private final CheatDetectorPlugin plugin;

    public ChannelListener(CheatDetectorPlugin plugin) {
        this.plugin = plugin;
    }
}
