package space.rexum.rexsys.manager;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gamemode {

    static List<String> gm0 = new ArrayList<String>(Arrays.asList("0", "survival", "überleben"));
    static List<String> gm1 = new ArrayList<String>(Arrays.asList("1", "creative", "kreative"));
    static List<String> gm2 = new ArrayList<String>(Arrays.asList("2", "adventure", "abenteuer"));
    static List<String> gm3 = new ArrayList<String>(Arrays.asList("3", "spectator", "zuschauer"));

    public static void changeGamemode(final Player player, final String gamemode){

        if(gm0.contains(gamemode)){
            if(player.hasPermission("rexsys.gamemode.use.0")){

                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Dein Gamemode wurde geändert. §8[§e" + player.getGameMode() + "§8]");

            }else{
                player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Dazu hast du keinen Zugriff.");
            }
        }else if(gm1.contains(gamemode)){
            if(player.hasPermission("rexsys.gamemode.use.1")){

                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Dein Gamemode wurde geändert. §8[§e" + player.getGameMode() + "§8]");

            }else{
                player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Dazu hast du keinen Zugriff.");
            }
        }else if(gm2.contains(gamemode)){
            if(player.hasPermission("rexsys.gamemode.use.2")){

                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Dein Gamemode wurde geändert. §8[§e" + player.getGameMode() + "§8]");

            }else{
                player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Dazu hast du keinen Zugriff.");
            }
        }else if(gm3.contains(gamemode)){
            if(player.hasPermission("rexsys.gamemode.use.3")){

                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Dein Gamemode wurde geändert. §8[§e" + player.getGameMode() + "§8]");

            }else{
                player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Dazu hast du keinen Zugriff.");
            }
        }else{
            player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDer angegebene Gamemode konnte nicht gefunden werden.");
        }

    }

    public static void changeGamemode(final Player player, final String gamemode, final Player sender){

        if(gm0.contains(gamemode)){
            if(sender.hasPermission("rexsys.gamemode.use.other.0")){

                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Dein Gamemode wurde geändert. §8[§e" + player.getGameMode() + "§8]");
                sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Du hast den Gamemode von §e" + player.getName() + " §7geändert. §8[§e" + player.getGameMode() + "§8]");

            }else{
                sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Dazu hast du keinen Zugriff.");
            }
        }else if(gm1.contains(gamemode)){
            if(sender.hasPermission("rexsys.gamemode.use.other.1")){

                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Dein Gamemode wurde geändert. §8[§e" + player.getGameMode() + "§8]");
                sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Du hast den Gamemode von §e" + player.getName() + " §7geändert. §8[§e" + player.getGameMode() + "§8]");

            }else{
                sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Dazu hast du keinen Zugriff.");
            }
        }else if(gm2.contains(gamemode)){
            if(sender.hasPermission("rexsys.gamemode.use.other.2")){

                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Dein Gamemode wurde geändert. §8[§e" + player.getGameMode() + "§8]");
                sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Du hast den Gamemode von §e" + player.getName() + " §7geändert. §8[§e" + player.getGameMode() + "§8]");

            }else{
                sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Dazu hast du keinen Zugriff.");
            }
        }else if(gm3.contains(gamemode)){
            if(sender.hasPermission("rexsys.gamemode.use.other.3")){

                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Dein Gamemode wurde geändert. §8[§e" + player.getGameMode() + "§8]");
                sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Du hast den Gamemode von §e" + player.getName() + " §7geändert. §8[§e" + player.getGameMode() + "§8]");

            }else{
                sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Dazu hast du keinen Zugriff.");
            }
        }else{
            sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDer angegebene Gamemode konnte nicht gefunden werden.");
        }

    }

}