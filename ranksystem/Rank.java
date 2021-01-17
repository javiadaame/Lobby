package com.nickblade.ranksystem;

import org.bukkit.ChatColor;

public enum Rank {

	OWNER("OWNER", ChatColor.DARK_RED, "§4§lOWNER §f", "§c"),
	ADMIN("ADMIN",  ChatColor.RED, "§c§lADMIN §f", "§c"),
	HEADMOD("H-MOD",  ChatColor.DARK_AQUA, "§3§lH-MOD §f", "§6"),
	MOD("MOD", ChatColor.BLUE, "§9§lMOD §f", "§6"),
	HELPER("HELPER",  ChatColor.YELLOW, "§e§lHELPER §f", "§6"),
	ULTRA("ULTRA", ChatColor.GOLD, "§6§lULTRA §f", "§b"),
	ELITE("ELITE",  ChatColor.AQUA, "§b§lELITE §f", "§f"),
	VIP("VIP",  ChatColor.YELLOW, "§e§lVIP §f", "§f"),
	USUARIO("USUARIO", ChatColor.GRAY, "§7", "§7");
	
	private String name;
	private ChatColor color;
	private String nametagprefix;
	private String chatcolor;
	
	private Rank(String name, ChatColor color, String nametagprefix, String chatcolor) {
		this.name = name;
		this.color = color;
		this.nametagprefix = nametagprefix;
		this.chatcolor = chatcolor;
		
	}
	
	public String getName() {return name;}
	public ChatColor getColor() {return color;}
	public String getNTPrefix() {return nametagprefix;}
	public String getChatColor() {return chatcolor;}
	
}
