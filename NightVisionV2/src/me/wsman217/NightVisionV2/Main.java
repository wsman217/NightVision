package me.wsman217.NightVisionV2;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
private static Main plugin;
	
	public static Main getPlugin() {
		
		return plugin;
	}
 
    @Override
    public void onEnable() {
    	plugin = this;
		System.out.println("NightVision has been ENABLED");
		System.out.println("Author: wsman217");
		
		getCommand("nightvision").setExecutor(new me.wsman217.NightVisionV2.commands.NVCommands());
		getCommand("nv").setExecutor(new me.wsman217.NightVisionV2.commands.NVCommands());
		
    }
   
    @Override
    public void onDisable() {
    	plugin = null;
		System.out.println("NightVision has been DISABLED");
		System.out.println("Author: wsman217");
    }
}
