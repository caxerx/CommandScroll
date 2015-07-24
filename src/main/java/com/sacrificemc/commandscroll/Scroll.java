package com.sacrificemc.commandscroll;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Scroll {
	List<Action> CommandList = new ArrayList<>();
	String ScrollName;
	boolean Reusable;
	double Cooldown;

	public Scroll(String ScrollName, List<Action> CommandList, boolean Reusable, double Cooldown) {
		this.ScrollName = ScrollName;
		this.CommandList = CommandList;
		this.Reusable = Reusable;
		this.Cooldown = Cooldown;
	}

	public String getName() {
		return ScrollName;
	}

	public boolean getResuable() {
		return Reusable;
	}

	public double getCooldown() {
		return Cooldown;
	}

	public List<Action> getCommandsList() {
		return CommandList;
	}

	public void use(Player player) {
		if (!CommandScrollPlugin.getCooldownList().get(this).contains(player)) {
			if (!Reusable) {
				ItemStack HandItem = player.getItemInHand();
				HandItem.setAmount(HandItem.getAmount() - 1);
				player.setItemInHand(HandItem);
			}
			if (Cooldown > 0) {
				CommandScrollPlugin.getCooldownList().get(this).add(player);
				new CooldownScheduler(this, player).runTaskLater(CommandScrollPlugin.getPlugin(), (long) Cooldown * 20);
			}
			for (Action action : CommandList) {
				action.execute(player);
			}
		} else {
			player.sendMessage(ScrollUtilities.replaceColor(CommandScrollPlugin.getPlugin().getConfig().getString("CooldownMessage")));
		}
	}
}
