package com.sacrificemc.commandscroll.command;

import java.util.List;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.TextComponent;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sacrificemc.commandscroll.Scroll;
import com.sacrificemc.commandscroll.ScrollUtilities;

public class CommandMessage {
	public static void helpMessage1(CommandSender sender) {
		TextComponent Allmessage = new TextComponent("\n");
		Allmessage.setColor(ChatColor.GOLD);
		Allmessage.addExtra("=========Command Scroll指令說明===========");

		Allmessage.addExtra("\n");

		TextComponent message = new TextComponent("查看說明 ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("/csc help <頁數>");
		message.setColor(ChatColor.GREEN);
		message.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/csc help <頁數>"));
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");

		message = new TextComponent("查看所有卷軸的列表 ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("/csc list <頁數>");
		message.setColor(ChatColor.GREEN);
		message.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/csc list <頁數>"));
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");

		message = new TextComponent("查看卷軸的詳細資訊 ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("/csc scrollinfo <卷軸名稱>");
		message.setColor(ChatColor.GREEN);
		message.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/csc info <卷軸名稱>"));
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");

		message = new TextComponent("查看卷軸的執行類型 ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("/csc types");
		message.setColor(ChatColor.GREEN);
		message.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/csc types"));
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");

		message = new TextComponent("查看卷軸的變數 ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("/csc placeholders");
		message.setColor(ChatColor.GREEN);
		message.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/csc placeholders"));
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");

		Allmessage.addExtra("============== ");

		message = new TextComponent("<|");
		message.setColor(ChatColor.WHITE);
		Allmessage.addExtra(message);

		message = new TextComponent(" 第1/3頁 ");
		message.setColor(ChatColor.RED);
		Allmessage.addExtra(message);

		message = new TextComponent("|>");
		message.setColor(ChatColor.YELLOW);
		message.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/csc help 2"));
		Allmessage.addExtra(message);

		Allmessage.addExtra(" ===============");
		if (sender instanceof Player) {
			((Player) sender).spigot().sendMessage(Allmessage);
		} else {
			sender.sendMessage(Allmessage.toLegacyText());
		}
	}

	public static void helpMessage2(CommandSender sender) {
		TextComponent Allmessage = new TextComponent("\n");
		Allmessage.setColor(ChatColor.GOLD);
		Allmessage.addExtra("=========Command Scroll指令說明===========");

		Allmessage.addExtra("\n");

		TextComponent message = new TextComponent("建立一個卷軸 ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("/csc create <卷軸名稱>");
		message.setColor(ChatColor.GREEN);
		message.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/csc create <卷軸名稱>"));
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");

		message = new TextComponent("移除一個卷軸 ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("/csc remove <卷軸名稱>");
		message.setColor(ChatColor.GREEN);
		message.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/csc remove <卷軸名稱>"));
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");

		message = new TextComponent("取得一個卷軸 ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("/csc get <卷軸名稱>");
		message.setColor(ChatColor.GREEN);
		message.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/csc get <卷軸名稱>"));
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");

		message = new TextComponent("設定卷軸的冷卻時間 ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("/csc setcd <卷軸名稱> <冷卻時間>");
		message.setColor(ChatColor.GREEN);
		message.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/csc setcd <卷軸名稱> <冷卻時間>"));
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");

		message = new TextComponent("設定卷軸是否消耗 ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("/csc resuable <卷軸名稱> <true/false>");
		message.setColor(ChatColor.GREEN);
		message.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/csc resuable <卷軸名稱> <true/false>"));
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");

		Allmessage.addExtra("============== ");

		message = new TextComponent("<|");
		message.setColor(ChatColor.YELLOW);
		message.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/csc help 1"));
		Allmessage.addExtra(message);

		message = new TextComponent(" 第2/3頁 ");
		message.setColor(ChatColor.RED);
		Allmessage.addExtra(message);

		message = new TextComponent("|>");
		message.setColor(ChatColor.YELLOW);
		message.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/csc help 3"));
		Allmessage.addExtra(message);

		Allmessage.addExtra(" ===============");
		if (sender instanceof Player) {
			((Player) sender).spigot().sendMessage(Allmessage);
		} else {
			sender.sendMessage(Allmessage.toLegacyText());
		}
	}

	public static void helpMessage3(CommandSender sender) {
		TextComponent Allmessage = new TextComponent("\n");
		Allmessage.setColor(ChatColor.GOLD);
		Allmessage.addExtra("=========Command Scroll指令說明===========");

		Allmessage.addExtra("\n");

		TextComponent message = new TextComponent("為卷軸增加一行指令 ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("/csc addcommand <卷軸名稱> <執行類型> <指令>");
		message.setColor(ChatColor.GREEN);
		message.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/csc addcommand <卷軸名稱> <執行類型> <指令>"));
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");

		message = new TextComponent("移除卷軸的一行指令 ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("/csc removecommand <卷軸名稱> <行數>");
		message.setColor(ChatColor.GREEN);
		message.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/csc removecommand <卷軸名稱> <行數>"));
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");

		message = new TextComponent("重新載入設定 ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("/csc reload");
		message.setColor(ChatColor.GREEN);
		message.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/csc reload"));
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");

		Allmessage.addExtra("============== ");

		message = new TextComponent("<|");
		message.setColor(ChatColor.YELLOW);
		message.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/csc help 2"));
		Allmessage.addExtra(message);

		message = new TextComponent(" 第3/3頁 ");
		message.setColor(ChatColor.RED);
		Allmessage.addExtra(message);

		message = new TextComponent("|>");
		message.setColor(ChatColor.WHITE);
		Allmessage.addExtra(message);

		Allmessage.addExtra(" ===============");
		if (sender instanceof Player) {
			((Player) sender).spigot().sendMessage(Allmessage);
		} else {
			sender.sendMessage(Allmessage.toLegacyText());
		}
	}

	public static void actionType(CommandSender sender) {
		TextComponent Allmessage = new TextComponent("\n");
		Allmessage.setColor(ChatColor.GOLD);
		Allmessage.addExtra("==========CommandScroll執行類型===========");

		Allmessage.addExtra("\n");
		TextComponent message = new TextComponent("player ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("以該玩家的身份執行");
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");
		message = new TextComponent("op ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("以該管理員的身份執行");
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");
		message = new TextComponent("console ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("在控制台執行");
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");
		message = new TextComponent("broadcast ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("廣播信息");
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");
		message = new TextComponent("msg ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("向使用者發出一個信息");
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");
		Allmessage.addExtra("=======================================");

		if (sender instanceof Player) {
			((Player) sender).spigot().sendMessage(Allmessage);
		} else {
			sender.sendMessage(Allmessage.toLegacyText());
		}
	}

	public static void placeholder(CommandSender sender) {
		TextComponent Allmessage = new TextComponent("\n");
		Allmessage.setColor(ChatColor.GOLD);
		Allmessage.addExtra("=========CommandScroll指令變數===========");

		Allmessage.addExtra("\n");
		TextComponent message = new TextComponent("<x> ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("使用者所在位置的X座標");
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");
		message = new TextComponent("<y> ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("使用者所在位置的Y座標");
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");
		message = new TextComponent("<z> ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("使用者所在位置的Z座標");
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");
		message = new TextComponent("<world> ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("使用者所在的世界名稱");
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");
		message = new TextComponent("<player> ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("使用者的名稱");
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");
		message = new TextComponent("<uuid> ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("使用者的UUID");
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");
		Allmessage.addExtra("=======================================");

		if (sender instanceof Player) {
			((Player) sender).spigot().sendMessage(Allmessage);
		} else {
			sender.sendMessage(Allmessage.toLegacyText());
		}
	}

	public static void scrollList(List<String> scrolls, int page, int maxpage, CommandSender sender) {
		TextComponent Allmessage = new TextComponent("\n");
		Allmessage.setColor(ChatColor.GOLD);
		Allmessage.addExtra("=========Command Scroll卷軸列表===========");

		TextComponent message = new TextComponent("");
		int i = 1;
		for (String scroll : scrolls) {
			Allmessage.addExtra("\n");
			message = new TextComponent(String.valueOf((page - 1) * 5 + i) + ". ");
			message.setColor(ChatColor.AQUA);
			Allmessage.addExtra(message);
			message = new TextComponent(scroll);
			message.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/csc info " + scroll));
			message.setColor(ChatColor.GREEN);
			Allmessage.addExtra(message);
			i++;
		}

		Allmessage.addExtra("\n");

		Allmessage.addExtra("============== ");

		if (page != 1) {
			message = new TextComponent("<|");
			message.setColor(ChatColor.YELLOW);
			message.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/csc list " + (page - 1)));
			Allmessage.addExtra(message);
		} else {
			message = new TextComponent("<|");
			message.setColor(ChatColor.WHITE);
			Allmessage.addExtra(message);
		}

		message = new TextComponent(" 第" + page + "/" + maxpage + "頁 ");
		message.setColor(ChatColor.RED);
		Allmessage.addExtra(message);

		if (page >= maxpage) {
			message = new TextComponent("|>");
			message.setColor(ChatColor.WHITE);
			Allmessage.addExtra(message);
		} else {
			message = new TextComponent("|>");
			message.setColor(ChatColor.YELLOW);
			message.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/csc list " + (page + 1)));
			Allmessage.addExtra(message);
		}
		Allmessage.addExtra(" ===============");

		if (sender instanceof Player) {
			((Player) sender).spigot().sendMessage(Allmessage);
		} else {
			sender.sendMessage(Allmessage.toLegacyText());
		}
	}

	public static void scrollInfo(Scroll scroll, CommandSender sender) {
		TextComponent Allmessage = new TextComponent("\n");
		Allmessage.setColor(ChatColor.GOLD);
		Allmessage.addExtra("=========CommandScroll卷軸資訊===========");

		TextComponent message = new TextComponent("");

		Allmessage.addExtra("\n");
		message = new TextComponent("卷軸名稱: ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent(scroll.getName());
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");
		message = new TextComponent("消耗: ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		if (scroll.getResuable()) {
			message = new TextComponent("否");
		} else {
			message = new TextComponent("是");
		}
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");
		message = new TextComponent("冷卻時間: ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent(scroll.getCooldown() + " 秒");
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");
		message = new TextComponent("指令: ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		Allmessage.addExtra("\n");

		for (com.sacrificemc.commandscroll.Action act : scroll.getCommandsList()) {
			message = new TextComponent(" - " + ScrollUtilities.actionTranslator(act.getAction()) + ": ");
			message.setColor(ChatColor.AQUA);
			Allmessage.addExtra(message);
			message = new TextComponent(ChatColor.translateAlternateColorCodes('&', act.getCommand()));
			message.setColor(ChatColor.GREEN);
			Allmessage.addExtra(message);
			Allmessage.addExtra("\n");
		}

		if (sender instanceof Player) {
			Allmessage.addExtra("===============");
			message = new TextComponent("[取得卷軸]");
			message.setColor(ChatColor.YELLOW);
			message.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/csc get " + scroll.getName()));
			Allmessage.addExtra(message);
			Allmessage.addExtra("===============");

			((Player) sender).spigot().sendMessage(Allmessage);
		} else {
			Allmessage.addExtra("=======================================");
			sender.sendMessage(Allmessage.toLegacyText());
		}
	}

	public static void info(CommandSender sender) {
		TextComponent Allmessage = new TextComponent("\n");
		Allmessage.setColor(ChatColor.GOLD);
		Allmessage.addExtra("=====CommandScroll======");
		Allmessage.addExtra("\n");

		TextComponent message = new TextComponent("Version: ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("2.1.0");
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);
		Allmessage.addExtra("\n");

		message = new TextComponent("Author: ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("caxerx");
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);
		Allmessage.addExtra("\n");

		message = new TextComponent("[點擊查看指令說明]");
		message.setColor(ChatColor.YELLOW);
		message.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/csc help"));
		Allmessage.addExtra(message);
		Allmessage.addExtra("\n");

		Allmessage.addExtra("=======================");

		if (sender instanceof Player) {
			((Player) sender).spigot().sendMessage(Allmessage);
		} else {
			sender.sendMessage(Allmessage.toLegacyText());
		}
	}
}
