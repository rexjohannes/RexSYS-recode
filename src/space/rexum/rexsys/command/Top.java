package space.rexum.rexsys.command;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Top implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Du musst ein Spieler sein.");
            return false;
        }

        final Player player = ((Player) sender);

        if(player.hasPermission("rexsys.top")){

            if(args.length == 0){

                final Location loc = new Location(player.getWorld(), player.getLocation().getX(),
                        player.getWorld().getHighestBlockAt(player.getLocation()).getY(),
                        player.getLocation().getZ(),
                        player.getLocation().getYaw(), player.getLocation().getPitch());

                player.teleport(loc);
                player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§aDu wurdest zu Höchsten Block an deiner Position teleportiert.");

            }else{
                player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Usage: /top");
            }

        }else{
            player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDazu hast du keinen Zugiff.");
        }


        return false;
    }


}