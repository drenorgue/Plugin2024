package fr.drenorg.Plugin2024;

import fr.drenorg.Plugin2024.game.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class LobbyManager {
    public static final World world = Bukkit.getWorld("world");
    public GameManager activeGame;

    ArrayList<Player> allplayer = new ArrayList<Player>();
    public ArrayList<Player> getAllplayer() {
        return allplayer;
    }

    public void addplayer(Player p){
        allplayer.add(p);
    }
    public void removeplayer(Player p){
        allplayer.remove(p);
    }

    public void tpLobby(){
        for (int i = 0; i < allplayer.size(); ++i){
            Player player = allplayer.get(i);
            player.getInventory().clear();
            player.removePotionEffect(PotionEffectType.SATURATION);
            player.setGameMode(GameMode.ADVENTURE);
            player.setHealth(20);
            player.setFoodLevel(20);
            player.teleport(new Location(world, 274,182,-75));
        }
    }

    public void createGame() {
        GameManager newGame = new GameManager();
        activeGame = newGame;
        newGame.startGame(allplayer);
    }
}
