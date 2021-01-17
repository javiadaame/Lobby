package com.nickblade.ranksystem;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.nametagedit.plugin.NametagEdit;
import com.nickblade.Main;

public class RankVars extends JavaPlugin {
	private String prefixrank;

	private void NameTagRank(String prefixrank) {
		this.prefixrank = prefixrank;
	}
	public static void ranksNT(Player p) {
		Rank rank = Main.getFileManager().getRank(p);
		
		NametagEdit.getApi().setPrefix(p, rank.getNTPrefix());
		
	}
}
