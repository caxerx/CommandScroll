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

public class LoadScroll {
	static Plugin plugin = CommandScrollPlugin.getPlugin();

	public static YamlConfiguration reloadScroll() {
		File scrollsFile = getScrollConfig();
		YamlConfiguration scrolls = YamlConfiguration.loadConfiguration(scrollsFile);
		try {
			scrolls.save(scrollsFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		scrollsFile = null;
		return scrolls;
	}

	public static List<String> getScrollCommands(String scroll) {
		return reloadScroll().getStringList(scroll + ".Commands");
	}

	public static void setScrollCommands(String scroll, List<String> commands) {
		YamlConfiguration setScroll = reloadScroll();
		setScroll.set(scroll + ".Commands", commands);
		saveScrollAndReload(setScroll);
	}

	public static HashMap<String, Scroll> loadScrollList() {
		HashMap<String, Scroll> Scrolls = new HashMap<>();
		YamlConfiguration yml = reloadScroll();
		try {
			Set<String> keys = yml.getKeys(false);
			for (String key : keys) {
				List<Action> actionlist = new ArrayList<>();
				for (String cmd : yml.getStringList(key + ".Commands")) {
					Action action = ScrollUtilities.toAction(cmd);
					if (action != null) {
						actionlist.add(action);
					}
				}
				Scroll scr = new Scroll(key, actionlist, yml.getBoolean(key + ".Reusable"),
						yml.getDouble(key + ".Cooldown"));
				Scrolls.put(key, scr);
				CommandScrollPlugin.getCooldownList().put(scr, new ArrayList<Player>());
			}
			return Scrolls;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static File getScrollConfig() {
		File scrolls = new File(plugin.getDataFolder(), "scrolls.yml");
		if (!scrolls.exists()) {
			OutputStream out = null;
			InputStream in = null;
			try {
				scrolls.createNewFile();
				in = plugin.getResource("scrolls.yml");
				out = new FileOutputStream(scrolls);
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
		return scrolls;
	}

	public static boolean saveScrollAndReload(YamlConfiguration ScrollsConfig) {
		try {
			ScrollsConfig.save(LoadScroll.getScrollConfig());
			CommandScrollPlugin.reScrolls();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}
}
