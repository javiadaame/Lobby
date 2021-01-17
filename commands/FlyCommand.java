package com.nickblade.commands;

import org.bukkit.command.Command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nickblade.Main;
import com.nickblade.ranksystem.Rank;

import net.md_5.bungee.api.ChatColor;

public class FlyCommand implements CommandExecutor {

	private Main main;
	public FlyCommand(Main main) {
		this.main = main;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
		Rank rank = Main.getFileManager().getRank(p);

		if(rank.getName() != "USUARIO") {
			if(p.getAllowFlight()) {
				p.setAllowFlight(false);
				p.sendMessage("§cFly desactivado.");
			}else {
				p.setAllowFlight(true);
				p.sendMessage("§aFly activado.");
			}
		}else {
			p.sendMessage(main.NoPerms);
		}
		return false;
	}

}
