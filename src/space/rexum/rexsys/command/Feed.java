package space.rexum.rexsys.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            if(args.length == 1){
                final Player target = Bukkit.getPlayer(args[0]);
                if(target != null){
                    target.setFoodLevel(20);
                    target.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§aDein Hunger wurde gestillt.");
                    sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§aDu hast den Hunger von §e" + target.getName() + " §agestillt.");
                }else{
                    sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDer angegebene Spieler ist nicht online.");
                }
                return false;
            }
            sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Usage: /feed <Player>");
            return false;
        }

        final Player player = ((Player) sender);

        if(player.hasPermission("rexsys.feed")){

            if(args.length == 0){

                player.setFoodLevel(20);
                player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§aDein Hunger wurde gestillt.");

            }else if(args.length == 1){

                if(player.hasPermission("rexsys.feed.other")){

                    final Player target = Bukkit.getPlayer(args[0]);

                    if(target != null){
                        target.setFoodLevel(20);
                        target.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§aDein Hunger wurde gestillt.");
                        player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§aDu hast den Hunger von §e" + target.getName() + " §agestillt.");
                    }else{
                        player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDer angegebene Spieler ist nicht online.");
                    }
                }else{
                    player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDazu hast du keinen Zugiff.");
                }

            } else{
                player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Usage: /feed [Player]");
            }

        }else{
            player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDazu hast du keinen Zugiff.");
        }


        return false;
    }

}