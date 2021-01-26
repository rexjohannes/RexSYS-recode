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
    }
    
    
    private void loadListener(final PluginManager pluginManager){
        pluginManager.registerEvents(new space.rexum.rexsys.listener.Join(), this);

    }
	
    private void log(final String message){
    	Bukkit.getConsoleSender().sendMessage(prefix + message);
    }

}
