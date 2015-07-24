package com.sacrificemc.commandscroll;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Action {
	ActionType type;
	String action;

	public Action(ActionType type, String action) {
		this.type = type;
		this.action = action;
	}

	public ActionType getAction() {
		return type;
	}

	public String getCommand() {
		return action;
	}

	public void execute(Player player) {
		String exe = action;
		exe = ScrollUtilities.replacePlaceholder(exe, player);
		switch (type) {
		case PLAYER:
			player.performCommand(exe);
			break;
		case CONSOLE:
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), exe);
			break;
		case OP:
			Permission perm = CommandScrollPlugin.getPermissions();
			if (perm.playerHas(player, "*")) {
				player.performCommand(exe);
			} else {
				perm.playerAdd(player, "*");
				player.performCommand(exe);
				perm.playerRemove(player, "*");
			}
			break;
		case MSG:
			exe = ScrollUtilities.replaceColor(exe);
			player.sendMessage(exe);
			break;
		case BROADCAST:
			exe = ScrollUtilities.replaceColor(exe);
			Bukkit.broadcastMessage(exe);
			break;
		}
	}
}
