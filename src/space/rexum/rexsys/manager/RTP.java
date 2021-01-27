package space.rexum.rexsys.manager;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Random;

public class RTP {

    public static void rtp(final Player player){
        Random random = new Random();
        int randomX = random.nextInt(20000)-10000;
        int randomZ = random.nextInt(20000)-10000;

        World world = player.getWorld();
        int higestblock = world.getHighestBlockYAt(randomX, randomZ);
        Location toTeleport = new Location(world, randomX, higestblock, randomZ);
        player.teleport(toTeleport);
        player.sendMessage(space.rexum.rexsys.RexSYS.prefix + "Du wurdest zu §ex=" + randomX + " z=" + randomZ + " §7teleportiert.");
    }

}