package com.nickblade;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.nickblade.ranksystem.Rank;

public class FileManager {
	
	// UUID: rank
	
	private File file;
	private YamlConfiguration config;

	public FileManager(Main main) {
		
		file = new File(main.getDataFolder(), "data.yml");
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		config = YamlConfiguration.loadConfiguration(file);	

	}
	public void setRank(Player p, Rank rank) {
		config.set(p.getUniqueId().toString(), rank.name());
		save();
	}
	
	public void setRank(UUID uuid, Rank rank) {
		config.set(uuid.toString(), rank.name());
		save();

	}
	
	public Rank getRank(Player p) {
		return Rank.valueOf(config.getString(p.getUniqueId().toString()));
	}
	
	private void save() {
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
