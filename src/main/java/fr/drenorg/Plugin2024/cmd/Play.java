package fr.drenorg.Plugin2024.cmd;

import fr.drenorg.Plugin2024.LobbyManager;
import fr.drenorg.Plugin2024.Main;
import fr.drenorg.Plugin2024.game.GameManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Play implements CommandExecutor {
    Main main = Main.getInstance();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (main.Lobby.activeGame != null){
            commandSender.sendMessage("&cTu dois d'abord relancer le jeu");
        }
        else{
            main.Lobby.createGame();
        }

        return false;
    }
}
