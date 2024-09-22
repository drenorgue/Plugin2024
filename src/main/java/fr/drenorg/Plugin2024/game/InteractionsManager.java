package fr.drenorg.Plugin2024.game;

import fr.drenorg.Plugin2024.Main;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class InteractionsManager {

    Main main = Main.getInstance();
    GameManager game;

    public InteractionsManager(GameManager game) {
        this.game = game;
    }

    public void kill (Player dead){
        RoundManager round = main.Lobby.activeGame.currentRound;

        dead.setGameMode(GameMode.SPECTATOR);
        if (round.aliveteam2.contains(dead)){
            round.aliveteam2.remove(dead);
        } else {
            round.aliveteam1.remove(dead);
        }
        if (round.aliveteam1.isEmpty()){
            round.roundEnd(main.Lobby.activeGame.getTeam2());
        } else if (round.aliveteam2.isEmpty()){
            round.roundEnd(main.Lobby.activeGame.getTeam1());
        }
    }
}
