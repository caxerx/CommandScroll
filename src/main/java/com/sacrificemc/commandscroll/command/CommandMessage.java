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
		Allmessage.addExtra("=========Command Scroll���O����===========");

		Allmessage.addExtra("\n");

		TextComponent message = new TextComponent("�d�ݻ��� ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("/csc help <����>");
		message.setColor(ChatColor.GREEN);
		message.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/csc help <����>"));
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");

		message = new TextComponent("�d�ݩҦ����b���C�� ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("/csc list <����>");
		message.setColor(ChatColor.GREEN);
		message.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/csc list <����>"));
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");

		message = new TextComponent("�d�ݨ��b���ԲӸ�T ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("/csc scrollinfo <���b�W��>");
		message.setColor(ChatColor.GREEN);
		message.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/csc info <���b�W��>"));
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");

		message = new TextComponent("�d�ݨ��b���������� ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("/csc types");
		message.setColor(ChatColor.GREEN);
		message.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/csc types"));
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");

		message = new TextComponent("�d�ݨ��b���ܼ� ");
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

		message = new TextComponent(" ��1/3�� ");
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
		Allmessage.addExtra("=========Command Scroll���O����===========");

		Allmessage.addExtra("\n");

		TextComponent message = new TextComponent("�إߤ@�Ө��b ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("/csc create <���b�W��>");
		message.setColor(ChatColor.GREEN);
		message.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/csc create <���b�W��>"));
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");

		message = new TextComponent("�����@�Ө��b ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("/csc remove <���b�W��>");
		message.setColor(ChatColor.GREEN);
		message.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/csc remove <���b�W��>"));
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");

		message = new TextComponent("���o�@�Ө��b ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("/csc get <���b�W��>");
		message.setColor(ChatColor.GREEN);
		message.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/csc get <���b�W��>"));
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");

		message = new TextComponent("�]�w���b���N�o�ɶ� ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("/csc setcd <���b�W��> <�N�o�ɶ�>");
		message.setColor(ChatColor.GREEN);
		message.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/csc setcd <���b�W��> <�N�o�ɶ�>"));
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");

		message = new TextComponent("�]�w���b�O�_���� ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("/csc resuable <���b�W��> <true/false>");
		message.setColor(ChatColor.GREEN);
		message.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/csc resuable <���b�W��> <true/false>"));
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");

		Allmessage.addExtra("============== ");

		message = new TextComponent("<|");
		message.setColor(ChatColor.YELLOW);
		message.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/csc help 1"));
		Allmessage.addExtra(message);

		message = new TextComponent(" ��2/3�� ");
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
		Allmessage.addExtra("=========Command Scroll���O����===========");

		Allmessage.addExtra("\n");

		TextComponent message = new TextComponent("�����b�W�[�@����O ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("/csc addcommand <���b�W��> <��������> <���O>");
		message.setColor(ChatColor.GREEN);
		message.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/csc addcommand <���b�W��> <��������> <���O>"));
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");

		message = new TextComponent("�������b���@����O ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("/csc removecommand <���b�W��> <���>");
		message.setColor(ChatColor.GREEN);
		message.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/csc removecommand <���b�W��> <���>"));
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");

		message = new TextComponent("���s���J�]�w ");
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

		message = new TextComponent(" ��3/3�� ");
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
		Allmessage.addExtra("==========CommandScroll��������===========");

		Allmessage.addExtra("\n");
		TextComponent message = new TextComponent("player ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("�H�Ӫ��a����������");
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");
		message = new TextComponent("op ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("�H�Ӻ޲z������������");
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");
		message = new TextComponent("console ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("�b����x����");
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");
		message = new TextComponent("broadcast ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("�s���H��");
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");
		message = new TextComponent("msg ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("�V�ϥΪ̵o�X�@�ӫH��");
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
		Allmessage.addExtra("=========CommandScroll���O�ܼ�===========");

		Allmessage.addExtra("\n");
		TextComponent message = new TextComponent("<x> ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("�ϥΪ̩Ҧb��m��X�y��");
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");
		message = new TextComponent("<y> ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("�ϥΪ̩Ҧb��m��Y�y��");
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");
		message = new TextComponent("<z> ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("�ϥΪ̩Ҧb��m��Z�y��");
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");
		message = new TextComponent("<world> ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("�ϥΪ̩Ҧb���@�ɦW��");
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");
		message = new TextComponent("<player> ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("�ϥΪ̪��W��");
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");
		message = new TextComponent("<uuid> ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent("�ϥΪ̪�UUID");
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
		Allmessage.addExtra("=========Command Scroll���b�C��===========");

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

		message = new TextComponent(" ��" + page + "/" + maxpage + "�� ");
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
		Allmessage.addExtra("=========CommandScroll���b��T===========");

		TextComponent message = new TextComponent("");

		Allmessage.addExtra("\n");
		message = new TextComponent("���b�W��: ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent(scroll.getName());
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");
		message = new TextComponent("����: ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		if (scroll.getResuable()) {
			message = new TextComponent("�_");
		} else {
			message = new TextComponent("�O");
		}
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");
		message = new TextComponent("�N�o�ɶ�: ");
		message.setColor(ChatColor.AQUA);
		Allmessage.addExtra(message);
		message = new TextComponent(scroll.getCooldown() + " ��");
		message.setColor(ChatColor.GREEN);
		Allmessage.addExtra(message);

		Allmessage.addExtra("\n");
		message = new TextComponent("���O: ");
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
			message = new TextComponent("[���o���b]");
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

		message = new TextComponent("[�I���d�ݫ��O����]");
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
