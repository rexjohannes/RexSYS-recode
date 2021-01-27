package space.rexum.rexsys.command;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

class method {

    public static void teleport(final Player sender, final String[] args){

        switch (args.length){
            case 1:
                if(!sender.hasPermission("rexsys.teleport")){
                    sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDazu hast du keinen Zugiff.");
                    return;
                }
                final Player target1 = Bukkit.getPlayer(args[0]);
                if(target1 != null){
                    sender.teleport(target1);
                    sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§aDu hast dich zu §e" + target1.getName() + " §ateleportiert.");
                }else{
                    sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDer angegebene Spieler ist nicht online.");
                }
                break;
            case 2:
                if(!sender.hasPermission("rexsys.teleport.others")){
                    sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDazu hast du keinen Zugiff.");
                    return;
                }
                final Player target2 = Bukkit.getPlayer(args[0]);
                final Player target3 = Bukkit.getPlayer(args[1]);
                if((target2 != null) && (target3 != null)){
                    target2.teleport(target3);
                    target2.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§aDu wurdest zu §e" + target3.getName() + " §ateleportiert.");
                    sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§aDu hast §e" + target2.getName() + " §azu §e" + target3.getName() + " §ateleportiert.");
                }else{
                    sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDer angegebene Spieler ist nicht online.");
                }
                break;
            case 3:
                if(!sender.hasPermission("rexsys.teleport.position")){
                    sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDazu hast du keinen Zugiff.");
                    return;
                }
                final Double x2;
                final Double y2;
                final Double z2;
                try {
                    x2 = args[0].startsWith("~") ? sender.getLocation().getX() + Integer.parseInt(args[0].substring(1)) : Integer.parseInt(args[0]);
                    y2 = args[1].startsWith("~") ? sender.getLocation().getY() + Integer.parseInt(args[1].substring(1)) : Integer.parseInt(args[1]);
                    z2 = args[2].startsWith("~") ? sender.getLocation().getZ() + Integer.parseInt(args[2].substring(1)) : Integer.parseInt(args[2]);
                }catch (NumberFormatException e1){
                    sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Usage: /tp <~0> <~0> <~0>");
                    return;
                }

                if (x2 > 30000000 || y2 > 30000000 || z2 > 30000000 || x2 < -30000000 || y2 < -30000000 || z2 < -30000000) {
                    sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDeine angegebenen Koordinaten sind zu groß oder zu klein.");
                    return;
                }
                final Location locpos = new Location(sender.getWorld(), x2, y2, z2, sender.getLocation().getYaw(), sender.getLocation().getPitch());
                sender.teleport(locpos);
                sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§aDu hast dich zu §e" + x2.intValue() + " " + y2.intValue() + " " + z2.intValue() + " §ateleportiert.");
                break;
            case 4:
                if(!sender.hasPermission("rexsys.teleport.others.position")){
                    sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDazu hast du keinen Zugiff.");
                    return;
                }
                final Player target4 = Bukkit.getPlayer(args[0]);
                if(target4 != null){
                    final Double x;
                    final Double y;
                    final Double z;
                    try {
                        x = args[1].startsWith("~") ? target4.getLocation().getX() + Integer.parseInt(args[1].substring(1)) : Integer.parseInt(args[1]);
                        y = args[2].startsWith("~") ? target4.getLocation().getY() + Integer.parseInt(args[2].substring(1)) : Integer.parseInt(args[2]);
                        z = args[3].startsWith("~") ? target4.getLocation().getZ() + Integer.parseInt(args[3].substring(1)) : Integer.parseInt(args[3]);
                    }catch (NumberFormatException e1){
                        sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Usage: /tp <Player> <~0> <~0> <~0>");
                        return;
                    }
                    if (x > 30000000 || y > 30000000 || z > 30000000 || x < -30000000 || y < -30000000 || z < -30000000) {
                        sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDeine angegebenen Koordinaten sind zu groß oder zu klein.");
                    }
                    final Location locposother = new Location(target4.getWorld(), x, y, z, target4.getLocation().getYaw(), target4.getLocation().getPitch());
                    target4.teleport(locposother);
                    target4.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§aDu wurdest zu §e" + x.intValue() + " " + y.intValue() + " " + z.intValue() + " §ateleportiert.");
                    sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§aDu hast §e" + target4.getName() + " §azu §e" + x.intValue() + " " + y.intValue() + " " + z.intValue() + " §ateleportiert.");
                }else{
                    sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDer angegebene Spieler ist nicht online.");
                }
                break;
            default:
                if(sender.hasPermission("rexsys.teleport")
                        || sender.hasPermission("rexsys.teleport.others")
                        || sender.hasPermission("rexsys.teleport.position")
                        || sender.hasPermission("rexsys.teleport.others.position")){
                    sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Usage: /teleport <Player>");
                    sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Usage: /teleport <Player> <Player>");
                    sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Usage: /teleport <x> <y> <z>");
                    sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Usage: /teleport <Player> <x> <y> <z>");
                    return;
                }
                sender.sendMessage(space.rexum.rexsys.RexSYS.prefix + "§cDazu hast du keinen Zugiff.");
                break;
        }
    }

}