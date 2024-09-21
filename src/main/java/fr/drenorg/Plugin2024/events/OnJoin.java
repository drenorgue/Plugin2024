package fr.drenorg.Plugin2024.events;

import fr.drenorg.Plugin2024.LobbyManager;
import fr.drenorg.Plugin2024.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffectType;

public class OnJoin implements Listener {

    private Main main;

    @EventHandler
    public void OnJoinEvent(PlayerJoinEvent event){
        Player player = event.getPlayer();
        main.Lobby.addplayer(player);
        Bukkit.getConsoleSender().sendMessage("Un joueur s'est co");
        player.setGameMode(GameMode.ADVENTURE);
        player.teleport(new Location(LobbyManager.world, 274,182,-75));
        player.getInventory().clear();
        player.setHealth(20);
        player.setFoodLevel(20);
        player.addPotionEffect(PotionEffectType.SATURATION.createEffect(99999,99999));
    }
}
