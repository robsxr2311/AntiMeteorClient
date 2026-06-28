package fr.cheatdetector.listeners;

import fr.cheatdetector.CheatDetectorPlugin;
import org.bukkit.event.Listener;

public class BehaviorListener implements Listener {
    private final CheatDetectorPlugin plugin;

    public BehaviorListener(CheatDetectorPlugin plugin) {
        this.plugin = plugin;
    }
}
