package fr.cheatdetector.managers;

import fr.cheatdetector.CheatDetectorPlugin;
import fr.cheatdetector.utils.SchedulerUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class AlertManager {
    private final CheatDetectorPlugin plugin;

    public AlertManager(CheatDetectorPlugin plugin) {
        this.plugin = plugin;
    }

    public void handleViolation(Player player, String cheatType) {
        String perm = plugin.getConfig().getString("alert-permission", "cheatdetector.alerts");
        for (Player staff : Bukkit.getOnlinePlayers()) {
            if (staff.hasPermission(perm)) {
                staff.sendMessage("§c[CheatDetector] " + player.getName() + " suspecté de : " + cheatType);
            }
        }

        if (plugin.getConfig().getBoolean("kick-on-detect", true)) {
            // Utilise le Scheduler sécurisé pour Folia et Paper afin d'éviter les crashs au kick
            SchedulerUtil.runForPlayer(plugin, player, () -> {
                player.kickPlayer("§c[CheatDetector]\n\nUtilisation de client/mod interdit détectée.");
            });
        }
    }
}
