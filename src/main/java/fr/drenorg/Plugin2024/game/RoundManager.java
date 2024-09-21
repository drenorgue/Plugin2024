package fr.drenorg.Plugin2024.game;

import fr.drenorg.Plugin2024.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class RoundManager {
    static final GameManager game = Main.getInstance().Lobby.activeGame;

    public ArrayList<Player> aliveteam1 = new ArrayList<Player>();
    public ArrayList<Player> aliveteam2 = new ArrayList<Player>();

    public RoundManager() {
        aliveteam1 = game.getTeam1();
        aliveteam2 = game.getTeam2();
    }

    public void roundEnd(ArrayList<Player> winner) {
        if (game.score1 == GameManager.winScore || game.score2 == GameManager.winScore){
            game.endGame(winner);
        }
        else {
            for (Player player : game.players){
                player.setHealth(20);
                player.setFoodLevel(20);
                player.getInventory().clear();
                player.setGameMode(GameMode.ADVENTURE);
                player.getInventory().addItem(new ItemStack(Material.WOODEN_SWORD));
                player.getInventory().setItemInOffHand(new ItemStack(Material.SHIELD));
            }
        }

        game.tpSpawn();
        game.currentRound = new RoundManager();
    }
}
