package com.nickblade.events;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import com.nametagedit.plugin.NametagEdit;
import com.nickblade.Main;
import com.nickblade.ranksystem.Rank;
import com.nickblade.menu.Menu;




public class LobbyListener implements Listener{

	
	Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
	Team team = null;
	private Main main;
	
	public LobbyListener(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		Rank rank = Main.getFileManager().getRank(p);
		
		List<String> lore = Arrays.asList("§7¡Prueba nuestras modalidades!");

		ItemStack t = new ItemStack(Material.COMPASS, 1);
		ItemMeta tm = t.getItemMeta();
		tm.setDisplayName("§aTeletransportador §7(Click derecho)");
		tm.setLore(lore);
		t.setItemMeta(tm);
	
		p.getInventory().clear();
		p.getInventory().setItem(4, t);
		p.updateInventory();
		p.setFoodLevel(20);
		p.setHealth(20.0);
		p.setCanPickupItems(false);
		if(rank.getName() != "USUARIO") {
		p.setAllowFlight(true);
		e.setJoinMessage("§7[" + rank.getColor() + rank.getName() + "§7] " + "§a" + p.getName() + " §7Ha entrado al servidor!");
		p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 10, 1);
		
		}else {
			e.setJoinMessage("");
		}
	}
	
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		Rank rank = Main.getFileManager().getRank(p);
		e.setQuitMessage("");
	}
	
	@EventHandler
	public void onPlayerDamage(EntityDamageEvent event) {
	     event.setCancelled(true);
	}
	
	
	@EventHandler
	 public void onFoodLevelChange(FoodLevelChangeEvent event)
	   {
	      event.setCancelled(true);
	   }
	
	@EventHandler
	public void onBlockBreakEvent(BlockBreakEvent e) {
		e.setCancelled(true);
	}
	@EventHandler
	public void onThrow(PlayerDropItemEvent e) {
		e.setCancelled(true);
	}
	private void connectToServer(Player player, String server) {
	    try {
	        ByteArrayOutputStream b = new ByteArrayOutputStream();
	        DataOutputStream out = new DataOutputStream(b);
	        try {
	            out.writeUTF("Connect");
	            out.writeUTF(server);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        player.sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", b.toByteArray());
	    } catch (org.bukkit.plugin.messaging.ChannelNotRegisteredException e) {
	        Bukkit.getLogger().warning(" ERROR - Usage of bungeecord connect effects is not possible. Your server is not having bungeecord support (Bungeecord channel is not registered in your minecraft server)!");
	    }
	}
	
	// MENU
	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {
		if(!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Menu"))
		return;
		Player p = (Player) e.getWhoClicked();
		e.setCancelled(true);
	
		if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR || !e.getCurrentItem().hasItemMeta()) {
			p.closeInventory();
			return;
		}
		switch (e.getCurrentItem().getType()) {
		case DIAMOND_SWORD:
			connectToServer(p, "prision");
			p.closeInventory();
			break;
		case DIAMOND:
			p.sendMessage("prueba2");
			p.closeInventory();
			break;
		case DIAMOND_PICKAXE:
			connectToServer(p, "prision");
			p.closeInventory();
		default:
			p.closeInventory();
			break;
		}
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action a = e.getAction();
		if(a == Action.PHYSICAL || e.getItem() == null || e.getItem().getType() == Material.AIR)
			return;
		
		if(e.getItem().getType() == Material.COMPASS) {
				p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 100, 1);
				Menu.openGUI(e.getPlayer());
			}
		}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		try {
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§aTeletransportador §7(Click derecho)")) {
				e.setCancelled(true);
			}			
		} catch (Exception e1) {
		
		}
	}
	
	@EventHandler
	public void onPut(BlockPlaceEvent e) {
		e.setCancelled(true);
	}
}
