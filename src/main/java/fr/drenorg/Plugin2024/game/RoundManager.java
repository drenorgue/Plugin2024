package fr.drenorg.Plugin2024.game;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class RoundManager {
    GameManager game;

    public ArrayList<Player> aliveteam1 = new ArrayList<Player>();
    public ArrayList<Player> aliveteam2 = new ArrayList<Player>();

    public RoundManager(GameManager game) {
        this.game = game;
        aliveteam1 = game.getTeam1();
        aliveteam2 = game.getTeam2();
    }

    public void roundEnd(ArrayList<Player> winner) {
        if (winner == game.getTeam1()) {
            game.score1++;
        } else {
            game.score2++;
        }
        if (game.score1 == GameManager.winScore || game.score2 == GameManager.winScore){
            game.endGame(winner);
        } else if (game.score1 + game.score2 == GameManager.winScore - 1) {
            game.switchSide();
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
        game.currentRound = new RoundManager(game);
    }
}
