package fr.cheatdetector;

import fr.cheatdetector.listeners.BehaviorListener;
import fr.cheatdetector.listeners.BrandListener;
import fr.cheatdetector.listeners.ChannelListener;
import fr.cheatdetector.managers.AlertManager;
import fr.cheatdetector.managers.DetectionManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CheatDetectorPlugin extends JavaPlugin {
    private DetectionManager detectionManager;
    private AlertManager alertManager;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.detectionManager = new DetectionManager(this);
        this.alertManager = new AlertManager(this);

        getServer().getMessenger().registerIncomingPluginChannel(this, "minecraft:brand", new BrandListener(this));
        getServer().getPluginManager().registerEvents(new BehaviorListener(this), this);
        getServer().getPluginManager().registerEvents(new ChannelListener(this), this);
    }

    @Override
    public void onDisable() {
        getServer().getMessenger().unregisterIncomingPluginChannel(this, "minecraft:brand");
    }

    public DetectionManager getDetectionManager() { return detectionManager; }
    public AlertManager getAlertManager() { return alertManager; }
}
