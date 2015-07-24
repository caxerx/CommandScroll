package com.sacrificemc.commandscroll.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.sacrificemc.commandscroll.ActionType;
import com.sacrificemc.commandscroll.CommandScrollPlugin;
import com.sacrificemc.commandscroll.LoadScroll;
import com.sacrificemc.commandscroll.Scroll;
import com.sacrificemc.commandscroll.ScrollUtilities;

public class CommandBase {
	CommandSender sender;
	String Subcommand;
	List<String> args;

	public CommandBase(CommandSender sender, String[] args) {
		this.sender = sender;
		this.Subcommand = args[0];
		this.args = new ArrayList<String>();
		for (int i = 1; i <= args.length - 1; i++) {
			this.args.add(args[i]);
		}
	}

	public boolean execute() {
		switch (Subcommand) {
		case "help":
			if (sender.hasPermission("commandscroll.help")) {
				try {
					help(Integer.parseInt(args.get(0)));
				} catch (Exception e) {
					help(1);
				}
			} else {
				ScrollUtilities.sendError(sender, "你沒有足夠的權限");
			}
			break;
		case "list":
			if (sender.hasPermission("commandscroll.list")) {
				try {

					list(Integer.parseInt(args.get(0)));
				} catch (Exception ex) {
					list(1);
				}
			} else {
				ScrollUtilities.sendError(sender, "你沒有足夠的權限");
			}
			break;
		case "types":
			if (sender.hasPermission("commandscroll.types")) {
				types();
			} else {
				ScrollUtilities.sendError(sender, "你沒有足夠的權限");
			}
			break;
		case "placeholders":
			if (sender.hasPermission("commandscroll.placeholders")) {
				placeholders();
			} else {
				ScrollUtilities.sendError(sender, "你沒有足夠的權限");
			}
			break;
		case "create":
			if (sender.hasPermission("commandscroll.createscroll")) {
				create(args.get(0));
			} else {
				ScrollUtilities.sendError(sender, "你沒有足夠的權限");
			}
			break;
		case "remove":
			if (sender.hasPermission("commandscroll.removescroll")) {
				try {
					if (!LoadScroll.loadScrollList().containsKey(args.get(0))) {
						throw (new NullPointerException("Scroll not here"));
					}
				} catch (Exception ex) {
					ScrollUtilities.sendError(sender, "請輸入正確的卷軸名稱");
					break;
				}
				remove(args.get(0));
			} else {
				ScrollUtilities.sendError(sender, "你沒有足夠的權限");
			}
			break;
		case "get":
			if (sender.hasPermission("commandscroll.getscroll")) {
				try {
					if (!LoadScroll.loadScrollList().containsKey(args.get(0))) {
						throw (new NullPointerException("Scroll not here"));
					}
				} catch (Exception ex) {
					ScrollUtilities.sendError(sender, "請輸入正確的卷軸名稱");
					break;
				}
				get(args.get(0));
			} else {
				ScrollUtilities.sendError(sender, "你沒有足夠的權限");
			}
			break;
		case "reload":
			if (sender.hasPermission("commandscroll.reload")) {
				reload();
			} else {
				ScrollUtilities.sendError(sender, "你沒有足夠的權限");
			}
			break;
		case "setcd":
			if (sender.hasPermission("commandscroll.setcd")) {
				try {
					if (!LoadScroll.loadScrollList().containsKey(args.get(0))) {
						throw (new NullPointerException("Scroll not here"));
					}
				} catch (Exception ex) {
					ScrollUtilities.sendError(sender, "請輸入正確的卷軸名稱");
					break;
				}
				setcd(args.get(0), Double.parseDouble(args.get(1)));
			} else {
				ScrollUtilities.sendError(sender, "你沒有足夠的權限");
			}
			break;
		case "addcommand":
			ActionType actiontype = null;
			String Command = "";
			try {
				if (!LoadScroll.loadScrollList().containsKey(args.get(0))) {
					throw (new NullPointerException("Scroll not here"));
				}
			} catch (Exception ex) {
				ScrollUtilities.sendError(sender, "請輸入正確的卷軸名稱");
				break;
			}
			try {
				actiontype = ActionType.fromString(args.get(1));
				if (actiontype == null) {
					throw (new NullPointerException("actiontype is Null"));
				}
			} catch (Exception ex) {
				ScrollUtilities.sendError(sender, "請輸入正確的執行類型");
				break;
			}
			try {
				Command = args.get(2);
				for (int i = 3; i < args.size(); i++) {
					Command += " ";
					Command += args.get(i);
				}
			} catch (Exception ex) {
				ScrollUtilities.sendError(sender, "請輸入指令");
				break;
			}
			addcommand(args.get(0), args.get(1), Command);
			break;
		case "removecommand":
			if (sender.hasPermission("commandscroll.removecommand")) {
				try {
					if (!LoadScroll.loadScrollList().containsKey(args.get(0))) {
						throw (new NullPointerException("Scroll not here"));
					}
				} catch (Exception ex) {
					ScrollUtilities.sendError(sender, "請輸入正確的卷軸名稱");
					break;
				}
				removecommand(args.get(0), Integer.parseInt(args.get(1)));
			} else {
				ScrollUtilities.sendError(sender, "你沒有足夠的權限");
			}
			break;
		case "resuable":
			if (sender.hasPermission("commandscroll.resuable")) {
				try {
					if (!LoadScroll.loadScrollList().containsKey(args.get(0))) {
						throw (new NullPointerException("Scroll not here"));
					}
				} catch (Exception ex) {
					ScrollUtilities.sendError(sender, "請輸入正確的卷軸名稱");
					break;
				}
				resuable(args.get(0), Boolean.parseBoolean(args.get(1)));
			} else {
				ScrollUtilities.sendError(sender, "你沒有足夠的權限");
			}
			break;
		case "info":
			if (sender.hasPermission("commandscroll.scrollinfo")) {
				try {
					if (!LoadScroll.loadScrollList().containsKey(args.get(0))) {
						throw (new NullPointerException("Scroll not here"));
					}
				} catch (Exception ex) {
					ScrollUtilities.sendError(sender, "請輸入正確的卷軸名稱");
					break;
				}
				scrollinfo(args.get(0));
			} else {
				ScrollUtilities.sendError(sender, "你沒有足夠的權限");
			}
			break;
		default:
			CommandMessage.info(sender);
		}
		return true;
	}

	public boolean help(int i) {
		switch (i) {
		case 1:
			CommandMessage.helpMessage1(sender);
			break;
		case 2:
			CommandMessage.helpMessage2(sender);
			break;
		case 3:
			CommandMessage.helpMessage3(sender);
			break;
		default:
			CommandMessage.helpMessage1(sender);
		}
		return true;
	}

	public boolean types() {
		CommandMessage.actionType(sender);
		return true;
	}

	public boolean list(int page) {
		HashMap<String, Scroll> scrolls = LoadScroll.loadScrollList();
		int pages = (scrolls.size() % 5 == 0) ? (int) (scrolls.size() / 5) : scrolls.size() / 5 + 1;
		if (page > 0 && page <= pages) {
			List<String> scrlist = new ArrayList<String>();
			for (int i = 0; i < 5; i++) {
				int items = ((page - 1) * 5) + i;
				String[] scrollsname = scrolls.keySet().toArray((new String[0]));
				if (items >= 0 && items < scrollsname.length) {
					scrlist.add(scrollsname[items]);
				}
			}
			CommandMessage.scrollList(scrlist, page, pages, sender);
		} else {
			ScrollUtilities.sendError(sender, "頁數不存在");
		}
		return true;
	}

	public boolean placeholders() {
		CommandMessage.placeholder(sender);
		return true;
	}

	public boolean create(String name) {
		try {
			YamlConfiguration ScrollYML = LoadScroll.reloadScroll();
			ScrollYML.set(name + ".Cooldown", 0);
			ScrollYML.set(name + ".Reusable", false);
			ScrollYML.set(name + ".Commands", new ArrayList<String>());
			LoadScroll.saveScrollAndReload(ScrollYML);
			ScrollUtilities.sendSuccess(sender, "成功建立卷軸");
		} catch (Exception e) {
			ScrollUtilities.sendError(sender, "建立卷軸時出現問題");
			e.printStackTrace();
		}
		return true;
	}

	public boolean remove(String name) {
		try {
			YamlConfiguration ScrollYML = LoadScroll.reloadScroll();
			ScrollYML.set(name, null);
			LoadScroll.saveScrollAndReload(ScrollYML);
			ScrollUtilities.sendSuccess(sender, "成功移除卷軸");
		} catch (Exception e) {
			ScrollUtilities.sendError(sender, "建立卷軸時出現問題");
			e.printStackTrace();
		}
		return true;
	}

	public boolean reload() {
		try {
			CommandScrollPlugin.getPlugin().reloadConfig();
			CommandScrollPlugin.setPrefix(CommandScrollPlugin.getPlugin().getConfig().getString("ScrollPrefix"));
			ScrollUtilities.sendSuccess(sender, "已經重新載入設定");
			CommandScrollPlugin.reScrolls();
		} catch (Exception e) {
			ScrollUtilities.sendError(sender, "重新載入設定時發生問題");
			e.printStackTrace();
		}
		return true;
	}

	public boolean get(String name) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			ItemStack Item = new ItemStack(Material.PAPER, 1);
			ItemMeta Meta = Item.getItemMeta();
			List<String> Lores = new ArrayList<String>();
			Lores.add(CommandScrollPlugin.getScrollPrefix() + name);
			Meta.setLore(Lores);
			Item.setItemMeta(Meta);
			player.getInventory().addItem(Item);
			ScrollUtilities.sendSuccess(sender, "已經將卷軸加入你的背包");
		} else {
			ScrollUtilities.sendError(sender, "只有玩家可以取得卷軸");
		}
		return true;
	}

	public boolean setcd(String name, double cooldowntime) {
		try {
			YamlConfiguration ScrollYML = LoadScroll.reloadScroll();
			ScrollYML.set(name + ".Cooldown", cooldowntime);
			LoadScroll.saveScrollAndReload(ScrollYML);
			ScrollUtilities.sendSuccess(sender, "成功設定");
		} catch (Exception e) {
			ScrollUtilities.sendError(sender, "設定時出現問題");
			e.printStackTrace();
		}
		return true;
	}

	public boolean addcommand(String scroll, String type, String command) {
		switch (type) {
		case "player":
			if (!sender.hasPermission("commandscroll.addcommand.player")) {
				ScrollUtilities.sendError(sender, "你沒有足夠的權限");
				return true;
			}
			break;
		case "op":
			if (!sender.hasPermission("commandscroll.addcommand.op")) {
				ScrollUtilities.sendError(sender, "你沒有足夠的權限");
				return true;
			}
			break;
		case "console":
			if (!sender.hasPermission("commandscroll.addcommand.console")) {
				ScrollUtilities.sendError(sender, "你沒有足夠的權限");
				return true;
			}
			break;
		case "msg":
			if (!sender.hasPermission("commandscroll.addcommand.msg")) {
				ScrollUtilities.sendError(sender, "你沒有足夠的權限");
				return true;
			}
			break;
		case "broadcast":
			if (!sender.hasPermission("commandscroll.addcommand.broadcast")) {
				ScrollUtilities.sendError(sender, "你沒有足夠的權限");
				return true;
			}
			break;
		default:
			ScrollUtilities.sendError(sender, "請輸入正確的執行類型");
			break;
		}
		try {
			List<String> commands = LoadScroll.getScrollCommands(scroll);
			commands.add(type + ":" + command);
			LoadScroll.setScrollCommands(scroll, commands);
			CommandScrollPlugin.reScrolls();
			ScrollUtilities.sendSuccess(sender, "成功增加指令");
		} catch (Exception e) {
			ScrollUtilities.sendError(sender, "請輸入正確的卷軸名稱");
		}
		return true;
	}

	public boolean removecommand(String scroll, int line) {
		try {
			List<String> commands = LoadScroll.getScrollCommands(scroll);
			commands.remove(line - 1);
			LoadScroll.setScrollCommands(scroll, commands);
			CommandScrollPlugin.reScrolls();
			ScrollUtilities.sendSuccess(sender, "成功移除指令");
		} catch (Exception e) {
			ScrollUtilities.sendError(sender, "請輸入正確的卷軸名稱或行數");
		}
		return true;
	}

	public boolean resuable(String name, boolean reusable) {
		try {
			YamlConfiguration ScrollYML = LoadScroll.reloadScroll();
			ScrollYML.set(name + ".Reusable", reusable);
			LoadScroll.saveScrollAndReload(ScrollYML);
			ScrollUtilities.sendSuccess(sender, "成功設定");
		} catch (Exception e) {
			ScrollUtilities.sendError(sender, "設定時出現問題");
			e.printStackTrace();
		}
		return true;
	}

	public boolean scrollinfo(String name) {
		try {
			CommandMessage.scrollInfo(LoadScroll.loadScrollList().get(name), sender);
			// ScrollYML.set(name + ".Reusable", reusable);
		} catch (Exception e) {
			ScrollUtilities.sendError(sender, "請輸入正確的卷軸名稱");
		}
		return true;
	}

}
