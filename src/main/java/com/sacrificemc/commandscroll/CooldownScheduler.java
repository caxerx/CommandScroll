package com.sacrificemc.commandscroll;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CooldownScheduler extends BukkitRunnable {
	Scroll scroll;
	Player player;

	public CooldownScheduler(Scroll scroll, Player player) {
		this.scroll = scroll;
		this.player = player;
	}

	@Override
	public void run() {
		try {
			CommandScrollPlugin.getCooldownList().get(scroll).remove(player);
		} catch (NullPointerException e) {

		}
	}
}
