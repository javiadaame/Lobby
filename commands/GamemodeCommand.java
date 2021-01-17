package com.nickblade.commands;

import org.bukkit.ChatColor;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nickblade.Main;
import com.nickblade.ranksystem.Rank;

public class GamemodeCommand implements CommandExecutor {

	private Main main;
	public GamemodeCommand(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


		Player p = (Player) sender;
		Rank rank = Main.getFileManager().getRank(p);
	            if (rank.getName() == "OWNER"){
	                if (args.length > 0){
	                    if (args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("creative")){
	                        p.setGameMode(GameMode.CREATIVE);
	                        p.sendMessage(ChatColor.GREEN + "Your gamemode has been changed to creative!");           
	 
	                    }
	 
	                    else if (args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("survival")){
	                        p.setGameMode(GameMode.SURVIVAL);
	                        p.sendMessage(ChatColor.GREEN + "Your gamemode has been changed to survival!");
	                    }
	 
	                    else if (args[0].equalsIgnoreCase("sp") || args[0].equalsIgnoreCase("spectator")){
	                        p.setGameMode(GameMode.SPECTATOR);
	                        p.sendMessage(ChatColor.GREEN + "Your gamemode has been changed to spectator!");
	                }
	            }
	        }
	        if(rank.getName() != "OWNER") {
	        	p.sendMessage(main.NoPerms);
	        }
		
		return false;
	}

}
