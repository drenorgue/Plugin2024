package fr.drenorg.Plugin2024.game;

import org.bukkit.entity.Player;

import java.util.Dictionary;

public class PlayerManager {

    static Dictionary<Player, PlayerManager> players;
    Player player;
    int credits;
    boolean isAttacker = false;
    GameManager game;

    public PlayerManager(GameManager game, Player player, int credits) {
        this.player = player;
        this.credits = credits;
        this.game = game;
        players.put(player, this);
        if (game.getTeam1().contains(player)) {
            isAttacker = true;
        }
    }

    public static PlayerManager getPlayerManager(Player p) {
        return players.get(p);
    }
}
