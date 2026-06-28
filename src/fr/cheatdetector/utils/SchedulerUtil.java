package fr.cheatdetector.utils;

import fr.cheatdetector.CheatDetectorPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SchedulerUtil {
    private static final boolean IS_FOLIA = checkForFolia();

    private static boolean checkForFolia() {
        try {
            Class.forName("io.papermc.paper.threadedregionscontroller.ThreadedRegionizer");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static void runForPlayer(CheatDetectorPlugin plugin, Player player, Runnable runnable) {
        if (IS_FOLIA) {
            player.getScheduler().run(plugin, task -> runnable.run(), null);
        } else {
            Bukkit.getScheduler().runTask(plugin, runnable);
        }
    }
}
