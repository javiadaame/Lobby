package com.nickblade.menu;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Menu extends JavaPlugin {
	public static void openGUI(Player p) {
		Inventory i =  Bukkit.createInventory(null, 54, ChatColor.GREEN + "Menu");
		
		ItemStack Skywars = new ItemStack(Material.BOW);
		ItemMeta SkywarsMeta = Skywars.getItemMeta();
		ItemStack Practice = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta PracticeMeta = Practice.getItemMeta();
		ItemStack Prision = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta PrisionMeta = Prision.getItemMeta();

		List<String> prisionLore = new ArrayList<String>();
		List<String> practiceLore = new ArrayList<String>();
		List<String> skywarsLore = new ArrayList<String>();

		prisionLore.add("§aClick para unirte a la modalidad!");
		practiceLore.add("§aClick para unirte a la modalidad!");
		skywarsLore.add("§aClick para unirte a la modalidad!");


		SkywarsMeta.setDisplayName("§b§lSkywars");
		SkywarsMeta.setLore(skywarsLore);
		Skywars.setItemMeta(SkywarsMeta);

		PracticeMeta.setDisplayName("§c§lPractice");
		PracticeMeta.setLore(practiceLore);
		Practice.setItemMeta(PracticeMeta);

		PrisionMeta.setDisplayName("§7§lPrision");
		PrisionMeta.setLore(prisionLore);
		Prision.setItemMeta(PrisionMeta);


		
		i.setItem(22, Skywars);
		i.setItem(21, Practice);
		i.setItem(23, Prision);
		
		p.openInventory(i);
		
	}
}
