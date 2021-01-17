package com.nickblade.scoreboard;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import com.nickblade.Main;

public class SidebarListener implements Listener {
	private Main main;
	private Scoreboard sb;
	
	public SidebarListener(Main main, Scoreboard sb) {
		this.main = main;
		this.sb = sb;
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		sb.buildSidebar(p);
	}
	


}
