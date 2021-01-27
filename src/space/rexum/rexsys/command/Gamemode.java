package space.rexum.rexsys.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Du musst ein Spieler sein.");
            return false;
        }

        final Player player = ((Player) sender);

        if(player.hasPermission("rexsys.gamemode.use")){

            if(args.length == 1){

            	space.rexum.rexsys.manager.Gamemode.changeGamemode(player, args[0]);

            }else if(args.length == 2){

                final Player target = Bukkit.getPlayer(args[1]);

                if(target != null){

                	space.rexum.rexsys.manager.Gamemode.changeGamemode(target, args[0], player);

                }else{
                    player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDer angegebene Spieler ist nicht online.");
                }

            }else{
                player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Usage: /gm <0,1,2,3> [Player]");
            }

        }else{
            player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDazu hast du keinen Zugriff.");
        }


        return false;
    }
}