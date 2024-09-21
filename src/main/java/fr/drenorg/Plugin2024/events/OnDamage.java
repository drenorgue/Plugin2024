package fr.drenorg.Plugin2024.events;

import fr.drenorg.Plugin2024.Main;
import fr.drenorg.Plugin2024.game.GameManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class OnDamage implements Listener {
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        Main main = Main.getInstance();
        GameManager game = main.Lobby.activeGame;
        if (game != null){
            if (e.getDamager() instanceof Player damager && e.getEntity() instanceof Player victime){
                if ((game.getTeam1().contains(damager) && game.getTeam1().contains(victime)) ||
                        (game.getTeam2().contains(damager) && game.getTeam2().contains(victime))) {
                    e.setDamage(0);
                    damager.sendMessage("&eLe tir allié n'est pas autorisé");
                } else if (victime.getHealth() < e.getDamage()){
                    e.setDamage(0);
                    game.interactionsManager.kill(victime);
                }
            }
        }
        else{
            e.setDamage(0);
        }

    }
}
