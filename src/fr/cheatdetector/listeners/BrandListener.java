package fr.cheatdetector.listeners;

import fr.cheatdetector.CheatDetectorPlugin;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import java.nio.charset.StandardCharsets;

public class BrandListener implements PluginMessageListener {
    private final CheatDetectorPlugin plugin;

    public BrandListener(CheatDetectorPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equalsIgnoreCase("minecraft:brand")) return;
        
        String brand = new String(message, StandardCharsets.UTF_8).substring(1);
        if (brand.equalsIgnoreCase("Meteor") || brand.equalsIgnoreCase("LiquidBounce") || brand.equalsIgnoreCase("Wurst")) {
            plugin.getAlertManager().handleViolation(player, "Client de triche (" + brand + ")");
        }
    }
}
