package com.sacrificemc.commandscroll.event;

import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.sacrificemc.commandscroll.CommandScrollPlugin;

public class InteractEvent implements Listener {
	@EventHandler
	public void onPlayerRightClick(PlayerInteractEvent e) {
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().hasItemMeta() && e.getPlayer().getItemInHand().getItemMeta().hasLore()) {
			List<String> Lores = e.getPlayer().getItemInHand().getItemMeta().getLore();
			boolean isScroll = false;
			String ScrollName = "";
			for (String Lore : Lores) {
				if (Lore.startsWith(CommandScrollPlugin.getScrollPrefix())) {
					isScroll = true;
					ScrollName = Lore.replaceFirst(CommandScrollPlugin.getScrollPrefix(), "");
					break;
				}
			}
			if (isScroll) {
				try {
					CommandScrollPlugin.getScrolls().get(ScrollName).use(e.getPlayer());
				} catch (NullPointerException ex) {

				}
			}
		}
	}
}
