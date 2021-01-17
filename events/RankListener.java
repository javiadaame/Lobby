package com.nickblade.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import com.nickblade.Main;
import com.nickblade.ranksystem.Rank;

import net.md_5.bungee.api.ChatColor;

public class RankListener implements Listener{

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		if(!e.getPlayer().hasPlayedBefore()) {
			Main.getFileManager().setRank(e.getPlayer(), Rank.USUARIO);
		}
		
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		ChatColor BOLD = ChatColor.BOLD;
		Player p = e.getPlayer();
		Rank rank = Main.getFileManager().getRank(p);
				
		for (Player onlinePlayers : e.getRecipients()) {
			onlinePlayers.sendMessage("§8[" + rank.getColor() + ChatColor.BOLD + rank.getName() + "§8] " + "§f" + p.getName() + ChatColor.GRAY + 
					": " + rank.getChatColor() + e.getMessage());
		}
		
		e.setCancelled(true);
		
	}
}
