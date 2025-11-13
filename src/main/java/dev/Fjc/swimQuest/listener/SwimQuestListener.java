package dev.Fjc.swimQuest.listener;

import com.ordwen.odailyquests.quests.player.progression.PlayerProgressor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;
import java.util.Map;

public class SwimQuestListener extends PlayerProgressor implements Listener {

    private final Map<Player, Double> playerDistance = new HashMap<>();

    @EventHandler(ignoreCancelled = true)
    public void onPlayerSwim(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (event.getFrom().getBlockX() == event.getTo().getBlockX() && event.getFrom().getBlockY() == event.getTo().getBlockY() && event.getFrom().getBlockZ() == event.getTo().getBlockZ()) {
            return;
        }
        if (player.isClimbing() || player.isInsideVehicle() || player.isFlying() || player.isDead()) {
            return;
        }
        if (!player.isSwimming()) return;

        Location from = event.getFrom();
        Location to = event.getTo();

        double distance = Math.abs(from.getX() - to.getX()) + Math.abs(from.getY() - to.getY()) + Math.abs(from.getZ() - to.getZ());

        double threshold = 1.1;
        if (distance > threshold) return;

        double fullDistance = playerDistance.getOrDefault(player, 0.0);

        fullDistance += distance;

        playerDistance.put(player, fullDistance);

        setPlayerQuestProgression(event, player, 1, "SWIM");

    }
}
