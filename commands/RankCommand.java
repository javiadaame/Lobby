package com.nickblade.commands;

import org.apache.commons.lang3.EnumUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nickblade.Main;
import com.nickblade.ranksystem.Rank;

import net.md_5.bungee.api.ChatColor;

public class RankCommand implements CommandExecutor {

	// setrank <player> <rank>
	
	private Main main;
	public RankCommand(Main main) {
		this.main = main;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		if(p.isOp()) {
			if(args.length == 2) {
				if(Bukkit.getOfflinePlayer(args[0]).hasPlayedBefore()) {
					if (EnumUtils.isValidEnum(Rank.class, args[1].toUpperCase())) {
						Main.getFileManager().setRank(Bukkit.getOfflinePlayer(args[0]).getUniqueId(), Rank.valueOf(args[1].toUpperCase()));
					
						// ENVÍA EL MSG A LA PERSONA QUE LO HA CAMBIADO
						p.sendMessage(ChatColor.GREEN + "Has cambiado el rango.");
						
						// ENVÍA EL MSG A LA PERSONA QUE LE HA CAMBIADO
						if(Bukkit.getOfflinePlayer(args[0]).isOnline()) {
							Bukkit.getOfflinePlayer(args[0]).getPlayer().sendMessage(p.getName() + " te ha cambiado el rango a " + args[1] + ".");
						}
					}else {
						p.sendMessage(ChatColor.RED + "Este rango no existe.");
					}
				}else {
					p.sendMessage(ChatColor.RED + "Nunca ha jugado en el servidor.");
				}
				
				
			}else {
				p.sendMessage(ChatColor.RED + "Invalid usage!");
			}
			
		}else {
			p.sendMessage(main.NoPerms);
		}
		
		return false;
	}
}
