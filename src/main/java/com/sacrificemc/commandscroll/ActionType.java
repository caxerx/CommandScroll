package com.sacrificemc.commandscroll;

public enum ActionType {
	PLAYER, OP, CONSOLE, MSG, BROADCAST;
	public static ActionType fromString(String actionstring) {
		if (actionstring.startsWith("player:") || actionstring.equalsIgnoreCase("player")) {
			return ActionType.PLAYER;
		} else if (actionstring.startsWith("op:") || actionstring.equalsIgnoreCase("op")) {
			return ActionType.OP;
		} else if (actionstring.startsWith("console:") || actionstring.equalsIgnoreCase("console")) {
			return ActionType.CONSOLE;
		} else if (actionstring.startsWith("broadcast:") || actionstring.equalsIgnoreCase("broadcast")) {
			return ActionType.BROADCAST;
		} else if (actionstring.startsWith("msg:") || actionstring.equalsIgnoreCase("msg")) {
			return ActionType.MSG;
		}
		return null;
	}
}
