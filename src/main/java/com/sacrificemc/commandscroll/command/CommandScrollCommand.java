package com.sacrificemc.commandscroll.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandScrollCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if (arg3.length == 0) {
			CommandMessage.info(arg0);
			return true;
		} else {
			return new CommandBase(arg0, arg3).execute();
		}
	}
}
