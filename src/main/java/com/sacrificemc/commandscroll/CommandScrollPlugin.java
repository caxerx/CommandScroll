package com.sacrificemc.commandscroll;

import java.util.HashMap;
import java.util.List;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.sacrificemc.commandscroll.command.CommandScrollCommand;
import com.sacrificemc.commandscroll.event.InteractEvent;

public class CommandScrollPlugin extends JavaPlugin {
	public static Permission permission = null;
	public static Plugin pl;
	public static String prefix;
	public static HashMap<Scroll, List<Player>> Cooldown = new HashMap<>();
	private static HashMap<String, Scroll> scrolls;

	private boolean setupPermissions() {
		RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
		if (permissionProvider != null) {
			permission = permissionProvider.getProvider();
		}
		return (permission != null);
	}

	public static Permission getPermissions() {
		return permission;
	}

	@Override
	public void onEnable() {
		if (!setupPermissions()) {
			getLogger().severe("Vault or Permissions Error");
			getServer().getPluginManager().disablePlugin(this);
		}
		pl = this;
		getConfig().options().copyDefaults(true);
		saveConfig();
		prefix = getConfig().getString("ScrollPrefix");
		scrolls = LoadScroll.loadScrollList();
		getServer().getPluginManager().registerEvents(new InteractEvent(), this);
		getCommand("commandscroll").setExecutor(new CommandScrollCommand());
	}

	@Override
	public void onDisable() {

	}

	public static Plugin getPlugin() {
		return pl;
	}

	public static String getScrollPrefix() {
		return prefix;
	}

	public static void setPrefix(String pref) {
		prefix = pref;
	}

	public static HashMap<String, Scroll> getScrolls() {
		return scrolls;
	}

	public static void reScrolls() {
		scrolls = LoadScroll.loadScrollList();
	}

	public static HashMap<Scroll, List<Player>> getCooldownList() {
		return Cooldown;
	}
}
