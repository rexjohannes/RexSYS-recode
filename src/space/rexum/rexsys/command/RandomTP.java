package space.rexum.rexsys.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RandomTP implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Du musst ein Spieler sein.");
            return false;
        }

        final Player player = ((Player) sender);

        if(player.hasPermission("rexsys.rtp")){

            if(args.length == 0){

                if(player.getWorld().getName().equals("world")){

                	space.rexum.rexsys.manager.RTP.rtp(player);

                }else{
                    player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDu musst in der Farmwelt sein.");
                }

            }else{
                player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Usage: /rtp");
            }

        }else{
            player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDazu hast du keinen Zugriff.");
        }

        return false;
    }
}