package fr.drenorg.Plugin2024.game;

import fr.drenorg.Plugin2024.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class BombManager  {

    GameManager game;

    public BombManager(GameManager game) {
        this.game = game;
    }

    Location bombLoc;

    final int[] soundDelay = new int[]{25, 35, 40, 45};

    public void plant(Player p) {

        new BukkitRunnable() {

            int timer = 0;

            @Override
            public void run() {
                if (timer >= 40) {
                    bombLoc = p.getLocation();
                    p.getWorld().getBlockAt(bombLoc).setType(Material.BREWING_STAND);
                    timerSound();
                    this.cancel();
                } else if (!p.isSneaking()) {
                    this.cancel();
                } else {
                    timer += 1;
                }
            }
        }.runTaskTimer(Main.getInstance(), 0, 2);
    }

    void timerSound() {
        new BukkitRunnable() {

            int timer = 0;

            @Override
            public void run() {
                if (bombLoc != null) {
                    if (timer * 20 <= soundDelay[0] && timer * 20 % 20 == 0) {
                        bombLoc.getWorld().playSound(bombLoc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 3.0F, 0.5F);
                    } else if (timer * 20 <= soundDelay[1] && timer % 10 == 0) {
                        bombLoc.getWorld().playSound(bombLoc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 3.0F, 0.5F);
                    } else if (timer * 20 <= soundDelay[2] && timer % 5 == 0) {
                        bombLoc.getWorld().playSound(bombLoc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 3.0F, 0.5F);
                    } else if (timer * 20 <= soundDelay[3] && timer % 2 == 0) {
                        bombLoc.getWorld().playSound(bombLoc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 3.0F, 0.5F);
                    }
                    timer += 1;
                } else {
                    this.cancel();
                }
            }
        }.runTaskTimer(Main.getInstance(), 0, 1);
    }
}
