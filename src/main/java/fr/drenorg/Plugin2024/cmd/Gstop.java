package fr.drenorg.Plugin2024.cmd;

import fr.drenorg.Plugin2024.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Gstop implements CommandExecutor {
    Main main = Main.getInstance();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        main.Lobby.tpLobby();
        return false;
    }
}
