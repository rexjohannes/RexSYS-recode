package space.rexum.rexsys.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RexSys implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§aby rexjohannes98.");

        return false;
    }
}