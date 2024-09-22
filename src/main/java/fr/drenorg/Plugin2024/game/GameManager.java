package fr.drenorg.Plugin2024.game;

import fr.drenorg.Plugin2024.LobbyManager;
import fr.drenorg.Plugin2024.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import java.util.Collections;

import java.util.ArrayList;

public class GameManager {
    Main main = Main.getInstance();

    public static final int winScore = 7;

    public ArrayList<Player> players = new ArrayList<Player>();

    private ArrayList<Player> team1 = new ArrayList<Player>();
    private ArrayList<Player> team2 = new ArrayList<Player>();

    public ArrayList<Player> getTeam1() {
        return team1;
    }
    public ArrayList<Player> getTeam2(){
        return team2;
    }

    public int score1;
    public int score2;

    public Location spawn1;
    public Location spawn2;

    public RoundManager currentRound;
    public InteractionsManager interactionsManager;
    public BombManager bombManager;

    public void startGame(ArrayList<Player> newPlayers) {
        currentRound = new RoundManager(this);
        interactionsManager = new InteractionsManager(this);
        bombManager = new BombManager(this);

        players = newPlayers;
        Collections.shuffle(players);
        team1 = new ArrayList<>(players.subList(0, players.size()/2));
        team1 = new ArrayList<>(players.subList(players.size()/2, players.size()));

        spawn1 = new Location(LobbyManager.world, 249,133,-78); // co spanw team 1
        spawn2 = new Location(LobbyManager.world,249,133,-34); // co spawn team 2

        Bukkit.getConsoleSender().sendMessage("Jeu lancé");

        for (Player player : players){
            player.setHealth(20);
            player.setFoodLevel(20);
            player.getInventory().clear();
            player.setGameMode(GameMode.ADVENTURE);
            player.getInventory().addItem(new ItemStack(Material.WOODEN_SWORD));
            player.getInventory().setItemInOffHand(new ItemStack(Material.SHIELD));
        }
    }

    public void tpSpawn() {
        for (Player player : team1) {
            player.teleport(spawn1);
        }
        for (Player player : team2) {
            player.teleport(spawn2);
        }
    }

    public void endGame(ArrayList<Player> winner) {
        Bukkit.broadcastMessage(winner.toString());
    }
}
