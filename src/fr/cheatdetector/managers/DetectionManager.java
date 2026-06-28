package fr.cheatdetector.managers;

import fr.cheatdetector.CheatDetectorPlugin;

public class DetectionManager {
    private final CheatDetectorPlugin plugin;

    public DetectionManager(CheatDetectorPlugin plugin) {
        this.plugin = plugin;
    }

    public enum ClientType {
        VANILLA, MODDED, CHEAT
    }

    public static class DetectionData {
        // Données internes de détection
    }
}
