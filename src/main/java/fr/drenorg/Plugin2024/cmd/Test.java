package fr.drenorg.Plugin2024.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Test implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if (sender instanceof Player){
            sender.sendMessage("§aTest réussi");
        }
        return false;
    }
}
