package fr.drenorg.Plugin2024.events;

import fr.drenorg.Plugin2024.Main;
import fr.drenorg.Plugin2024.game.BombManager;
import fr.drenorg.Plugin2024.game.Items;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class PlayerToggleSneak implements Listener {

    @EventHandler
    public void PlayerToggleSneakEvent(PlayerToggleSneakEvent e) {
        Player p = e.getPlayer();

        if (p.getInventory().getItemInMainHand().equals(Items.bomb())) {
            Main.getInstance().Lobby.activeGame.bombManager.plant(p);
        }
    }
}
