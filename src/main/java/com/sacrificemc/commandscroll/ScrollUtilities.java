package com.sacrificemc.commandscroll;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ScrollUtilities {
	public static Action toAction(String actionstring) {
		if (actionstring.startsWith("player:")) {
			return new Action(ActionType.PLAYER, actionstring.replaceFirst("player:", ""));
		} else if (actionstring.startsWith("op:")) {
			return new Action(ActionType.OP, actionstring.replaceFirst("op:", ""));
		} else if (actionstring.startsWith("console:")) {
			return new Action(ActionType.CONSOLE, actionstring.replaceFirst("console:", ""));
		} else if (actionstring.startsWith("broadcast:")) {
			return new Action(ActionType.BROADCAST, actionstring.replaceFirst("broadcast:", ""));
		} else if (actionstring.startsWith("msg:")) {
			return new Action(ActionType.MSG, actionstring.replaceFirst("msg:", ""));
		}
		return null;
	}

	public static String replacePlaceholder(String text, Player player) {
		String replacedtext = text;
		if (text.contains("<x>")) {
			replacedtext = replacedtext.replaceAll("<x>", String.valueOf(player.getLocation().getX()));
		}
		if (text.contains("<y>")) {
			replacedtext = replacedtext.replaceAll("<y>", String.valueOf(player.getLocation().getY()));
		}
		if (text.contains("<z>")) {
			replacedtext = replacedtext.replaceAll("<z>", String.valueOf(player.getLocation().getZ()));
		}
		if (text.contains("<world>")) {
			replacedtext = replacedtext.replaceAll("<world>", String.valueOf(player.getWorld().getName()));
		}
		if (text.contains("<player>")) {
			replacedtext = replacedtext.replaceAll("<player>", String.valueOf(player.getName()));
		}
		if (text.contains("<uuid>")) {
			replacedtext = replacedtext.replaceAll("<uuid>", String.valueOf(player.getUniqueId()));
		}
		return replacedtext;
	}

	public static String replaceColor(String text) {
		return ChatColor.translateAlternateColorCodes('&', text);
	}

	public static String linking(char link, String... linking) {
		String linked = linking[0];
		for (int i = 1; i < linking.length - 1; i++) {
			linked += link;
			linked += linking[i];
		}
		return linked;
	}

	public static void sendError(CommandSender player, String msg) {
		player.sendMessage(ChatColor.GOLD + "[CommandScroll] " + ChatColor.RED + msg);
	}

	public static void sendSuccess(CommandSender player, String msg) {
		player.sendMessage(ChatColor.GOLD + "[CommandScroll] " + ChatColor.GREEN + msg);
	}

	public static String actionTranslator(ActionType act) {
		String ret = "";
		switch (act) {
		case PLAYER:
			ret = "玩家";
			break;
		case OP:
			ret = "管理員";
			break;
		case CONSOLE:
			ret = "控制台";
			break;
		case MSG:
			ret = "信息";
			break;
		case BROADCAST:
			ret = "廣播";
			break;
		default:
			ret = "未知";
		}
		return ret;
	}
}
