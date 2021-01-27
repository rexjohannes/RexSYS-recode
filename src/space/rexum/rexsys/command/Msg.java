package space.rexum.rexsys.command;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.google.common.collect.Maps;

public class Msg implements CommandExecutor {

    private static HashMap<UUID, UUID> replay = Maps.newHashMap();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Du musst ein Spieler sein.");
            return false;
        }

        final Player player = ((Player) sender);

        if(args.length >= 2){

            final Player target = Bukkit.getPlayer(args[0]);

            if(target != null){

                StringBuilder stringBuilder = new StringBuilder();

                for(int i = 1;i<args.length;i++){
                    stringBuilder.append(args[i]).append(" ");
                }

                player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§8[§7ich §a-> §e" + target.getName() + "§8] §f" + stringBuilder.toString());
                target.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§8[§e" + player.getName() + " §a-> §7mir§8] §f" + stringBuilder.toString());
                replay.put(player.getUniqueId(), target.getUniqueId());
                replay.put(target.getUniqueId(), player.getUniqueId());

            }else{
                player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDieser Spieler ist nicht online.");
            }
        }else{
            player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Usage: /msg <Player> <Message>");
        }

        return false;
    }


}