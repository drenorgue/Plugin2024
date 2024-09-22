package fr.drenorg.Plugin2024;

import fr.drenorg.Plugin2024.cmd.Gstop;
import fr.drenorg.Plugin2024.cmd.Play;
import fr.drenorg.Plugin2024.cmd.Test;
import fr.drenorg.Plugin2024.events.*;
import fr.drenorg.Plugin2024.game.Duel;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class Main extends JavaPlugin {

    private static Main instance;

    public LobbyManager Lobby;

    @Override
    public void onEnable() {
        getLogger().info("Plugin activé");
        Lobby = new LobbyManager();
        instance = this;

        getCommand("test").setExecutor(new Test());
        getCommand("play").setExecutor(new Play());
        getCommand("gstop").setExecutor(new Gstop());

        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new OnJoin(),this);
        pm.registerEvents(new OnLeft(),this);
        pm.registerEvents(new OnDamage(),this);
        pm.registerEvents(new onFoodChange(),this);
        pm.registerEvents(new PlayerToggleSneak(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin desactivé");
    }

    public static Main getInstance(){
        return instance;
    }
}