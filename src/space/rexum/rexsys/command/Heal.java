package space.rexum.rexsys.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            if(args.length == 1){
                final Player target = Bukkit.getPlayer(args[0]);
                if(target != null){
                    healOther(target);
                    sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§aDu hast den Spieler §e" + target.getName() + "§ageheilt.");
                }else{
                    sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDer angegebene Spieler ist nicht online.");
                }
                return false;
            }
            sender.sendMessage("Usage: /heal <Player>");
            return false;
        }

        final Player player = ((Player) sender);

        if(player.hasPermission("rexsys.heal")){

            if(args.length == 0){

                healOther(player);

            }else if(args.length == 1){

                if(player.hasPermission("rexsys.heal.other")){

                    final Player target = Bukkit.getPlayer(args[0]);

                    if(target != null){

                        healOther(target);
                        player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§aDu hast den Spieler §e" + target.getName() + "§ageheilt.");

                    }else{
                        player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDer angegebene Spieler ist nicht online.");
                    }

                }else{
                    player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDazu hast du keinen Zugiff.");
                }

            }else{
                player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Usage: /heal [Player]");
            }

        }else{
            player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDazu hast du keinen Zugiff.");
        }

        return false;
    }

    private void healOther(final Player player){

        player.setFoodLevel(20);
        player.setHealth(20);
        player.setFireTicks(0);
        player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§aDu wurdest geheilt.");

    }

}