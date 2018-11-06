package me.wsman217.NightVisionV2.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class NVCommands implements CommandExecutor {
	
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			System.out.println("This command is to be used by a player only!");
			return true;
		} else if (sender instanceof Player) {
			
			Player player = (Player)sender;
			
			if (label.equalsIgnoreCase("nightvision") || label.equalsIgnoreCase("nv")) {
				
				
				
				if (!(args.length == 0)) {
					player.sendMessage(ChatColor.GOLD + "[NightVision] " + ChatColor.YELLOW
							+ "Usage: /nightvision");
					player.sendMessage(ChatColor.GOLD + "[NightVision] " + ChatColor.YELLOW
							+ "Turns night vision on or off.");
					player.sendMessage(ChatColor.GOLD + "[NightVision] " + ChatColor.YELLOW
							+ "Usage: /nv");
					player.sendMessage(ChatColor.GOLD + "[NightVision] " + ChatColor.YELLOW
							+ "Turns night vision on or off.");
					return true;
				} else if (args.length == 0) {
					if (player.hasPermission("NV.command.use")) {
						if (player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
							player.removePotionEffect(PotionEffectType.NIGHT_VISION);
							player.sendMessage(ChatColor.GRAY + "NightVision:" + ChatColor.RED + " Disabled!");
							return true;
						} else if (!(player.hasPotionEffect(PotionEffectType.NIGHT_VISION))) {
							player.sendMessage(ChatColor.GRAY + "NightVision:" + ChatColor.RED + " Enabled!");
							player.addPotionEffect(new org.bukkit.potion.PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 1));
							return true;
						}	
					} else if (!(player.hasPermission("NV.command.use"))) {
						player.sendMessage(ChatColor.DARK_RED + "You do not have permission");
						return true;
					}
				}
			}
		}
		return false;
	}
}
