package com.nickblade;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.nickblade.commands.FlyCommand;
import com.nickblade.commands.GamemodeCommand;
import com.nickblade.commands.RankCommand;
import com.nickblade.commands.VanishCommand;
import com.nickblade.events.LobbyListener;
import com.nickblade.events.RankListener;
import com.nickblade.ranksystem.Rank;
import com.nickblade.ranksystem.RankVars;
import com.nickblade.scoreboard.Scoreboard;
import com.nickblade.scoreboard.SidebarListener;


public class Main extends JavaPlugin  implements Listener {
	
	private static FileManager fileManager;
	private YamlConfiguration config;   
	
	public String NoPerms = "§cNo tienes permisos.";

	@Override
	public void onEnable() {
		
		System.out.println("Enabled");
		
		fileManager = new FileManager(this);
		
		Bukkit.getPluginManager().registerEvents(new RankListener(), this);
		this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

		// commands
		getCommand("setrank").setExecutor(new RankCommand(this));
		getCommand("fly").setExecutor(new FlyCommand(this));
		getCommand("vanish").setExecutor(new VanishCommand(this));
		getCommand("gamemode").setExecutor(new GamemodeCommand(this));

		// listeners
		Bukkit.getPluginManager().registerEvents(new SidebarListener(this, null), this);
		Bukkit.getPluginManager().registerEvents(new LobbyListener(this), this);
		Bukkit.getPluginManager().registerEvents(this, this);

		
		   new BukkitRunnable() {
		        public void run() {
		        	
		            for(Player p : Bukkit.getOnlinePlayers()){
		        		Rank rank = Main.getFileManager().getRank(p);

		        		Scoreboard.buildSidebar(p);
		                RankVars.ranksNT(p);

		            }
		        }
		        }.runTaskTimer(this, 20, 20);
		
	}


	
	public static FileManager getFileManager()  { return fileManager;}



	}

