package com.nickblade.scoreboard;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import com.nickblade.Main;
import com.nickblade.ranksystem.Rank;

import net.md_5.bungee.api.ChatColor;

public class Scoreboard extends JavaPlugin {
	private Main main;
	static org.bukkit.scoreboard.Scoreboard board;
	
	public Scoreboard(Main main) {
		this.main = main;
	}
	
	public static void buildSidebar(Player p) {
		
		ScoreboardManager manager = Bukkit.getScoreboardManager();
        board = manager.getNewScoreboard();
		
		Objective obj = board.registerNewObjective("test", "dummy");
		obj.setDisplayName(ChatColor.AQUA.toString() + ChatColor.BOLD + "HUB");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		int onlinePlayers = Bukkit.getServer().getOnlinePlayers().size();
		
					
		Rank rank = Main.getFileManager().getRank(p);
		Score name2 = obj.getScore(ChatColor.WHITE + "Nombre: ");
		name2.setScore(11);
		
		Score name = obj.getScore(ChatColor.GREEN.toString() + p.getName());
		name.setScore(10);
		
		
		Score space3 = obj.getScore("   ");
		space3.setScore(9);
		
		Score players2 = obj.getScore(ChatColor.WHITE + "Jugadores: ");
		players2.setScore(8);
		
		Score players = obj.getScore(ChatColor.GREEN.toString() + Bukkit.getOnlinePlayers().size());
		players.setScore(7);
		
		Score space2 = obj.getScore("  ");
		space2.setScore(6);
		
		Score rangona = obj.getScore(ChatColor.WHITE + "Rango: ");
		rangona.setScore(5);
		
		Score rango = obj.getScore(ChatColor.GREEN + rank.getName());
		rango.setScore(4);
		
		Score space = obj.getScore(" ");
		space.setScore(3);
		
		Score website = obj.getScore(ChatColor.AQUA + "www.xxx.net");
		website.setScore(2);
		
		p.setScoreboard(board);
	
	}
}
