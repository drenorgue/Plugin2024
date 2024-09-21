package fr.drenorg.Plugin2024.events;

import fr.drenorg.Plugin2024.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnLeft implements Listener {

    @EventHandler
    public void OnLeftEvent(PlayerQuitEvent e){
        Main main = Main.getInstance();
        main.Lobby.removeplayer(e.getPlayer());
    }
}
