package fr.drenorg.Plugin2024.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class onFoodChange implements Listener {

    @EventHandler
    public void onFoodChangeEvent(FoodLevelChangeEvent event)
    {
        if (event.getEntity() instanceof Player)
        {
            event.setCancelled(true);
        }
    }

}
