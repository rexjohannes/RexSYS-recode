package space.rexum.rexsys.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Join implements Listener {

    @EventHandler
    public void onJoin(final PlayerJoinEvent event){
        event.setJoinMessage("§a+ §8[§e" + event.getPlayer().getName() + "§8]");
    }

    @EventHandler
    public void onQuit(final PlayerQuitEvent event){
        event.setQuitMessage(null);
    }

}