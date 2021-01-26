package space.rexum.rexsys.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChat
        implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;

            if (player.hasPermission("rexsys.clearchat")) {
                if (args.length == 0) {
                    for (int i = 0; i <= 125; i++) {
                        Bukkit.broadcastMessage("");
                    }

                    Bukkit.broadcastMessage(space.rexum.rexsys.RexSYS.prefix + "§cder chat wurde gefressen.");
                }
                else if (args.length > 0) {
                    player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Usage: /clearchat [Zeilen]");
                }
            } else {
                sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDazu hast du keinen Zugiff.");
            }
        } else {
            sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Du musst ein Spieler sein.");
        }

        return false;
    }
}