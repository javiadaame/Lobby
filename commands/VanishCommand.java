package com.nickblade.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nickblade.Main;
import com.nickblade.ranksystem.Rank;

public class VanishCommand implements CommandExecutor {

	List<Player> vanished = new ArrayList<>();
	
	private Main main;
	
	public VanishCommand(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		Rank rank = Main.getFileManager().getRank(p);
		
		if(rank.getName() == "OWNER" || rank.getName() == "ADMIN") {
			if(sender instanceof Player) {
				
				if(vanished.contains(p)) {
					vanished.remove(p);
					for(Player target : Bukkit.getOnlinePlayers()) {
						target.showPlayer(p);
					}
					
					p.sendMessage("§cVanish desactivado.");
				}else {
					vanished.add(p);
					for(Player target : Bukkit.getOnlinePlayers()) {
						target.hidePlayer(p);
					}
					
					p.sendMessage("§aVanish activado.");
				}
			}
		}else {
			p.sendMessage(main.NoPerms);
		}
		
		return false;
	}

}
