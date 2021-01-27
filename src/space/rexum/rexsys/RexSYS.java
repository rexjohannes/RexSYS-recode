package space.rexum.rexsys;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;


public class RexSYS extends JavaPlugin{
	public final static String prefix = "§8[§bSystem§8] §7";
	
	@Override
	public void onEnable() {
		log("§aPlugin geladen.");
		loadCommands();
		loadListener(Bukkit.getPluginManager());
	}
	
	@Override
	public void onDisable() {
		log("§cPlugin entladen.");
	}
	
    private void loadCommands(){
        getCommand("kick").setExecutor(new space.rexum.rexsys.command.Kick());
        getCommand("clearchat").setExecutor(new space.rexum.rexsys.command.ClearChat());
        getCommand("rex").setExecutor(new space.rexum.rexsys.command.RexSys());
        getCommand("fly").setExecutor(new space.rexum.rexsys.command.Fly());
        getCommand("top").setExecutor(new space.rexum.rexsys.command.Top());
        getCommand("tp").setExecutor(new space.rexum.rexsys.command.Tp());
        getCommand("heal").setExecutor(new space.rexum.rexsys.command.Heal());
        getCommand("feed").setExecutor(new space.rexum.rexsys.command.Feed());
        getCommand("gm").setExecutor(new space.rexum.rexsys.command.Gamemode());
        getCommand("msg").setExecutor(new space.rexum.rexsys.command.Msg());
        getCommand("rtp").setExecutor(new space.rexum.rexsys.command.RandomTP());
    }
    
    
    private void loadListener(final PluginManager pluginManager){
        pluginManager.registerEvents(new space.rexum.rexsys.listener.Join(), this);

    }
	
    private void log(final String message){
    	Bukkit.getConsoleSender().sendMessage(prefix + message);
    }

}
