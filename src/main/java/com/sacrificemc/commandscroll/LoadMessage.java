package com.sacrificemc.commandscroll;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.google.common.io.ByteStreams;
import com.google.common.io.Files;

public class LoadMessage {
	static Plugin plugin = CommandScrollPlugin.getPlugin();

	public static YamlConfiguration loadLanguages() {
		File languagesFile = getLanguageConfig();
		YamlConfiguration languages = YamlConfiguration.loadConfiguration(languagesFile);
		languagesFile = null;
		return languages;
	}

	public static HashMap<String, String> loadLanguaue() {
		HashMap<String, String> languages = new HashMap<>();
		YamlConfiguration yml = loadLanguages();
		try {
			languages.put("NotEnoughPermission", yml.getString("NotEnoughPermission"));
			return languages;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static File getLanguageConfig() {
		File languages = new File(plugin.getDataFolder(), "lanuage.yml");
		if (!languages.exists()) {
			OutputStream out = null;
			InputStream in = null;
			try {
				languages.createNewFile();
				in = plugin.getResource("lanuage.yml");
				out = new FileOutputStream(languages);
				ByteStreams.copy(in, out);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return languages;
	}

}
