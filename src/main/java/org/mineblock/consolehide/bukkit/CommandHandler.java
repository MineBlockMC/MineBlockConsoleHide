package org.mineblock.consolehide.bukkit;

import org.bukkit.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;


public class CommandHandler implements CommandExecutor {
    private final BukkitPlugin plugin;

    public CommandHandler(BukkitPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command,
                             String cmdlabel, String[] args) {
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                if (sender instanceof Player) {
                    if (!sender.hasPermission("csf.admin")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes(
                                '&',
                                plugin.getConfig().getString("messages.nopermission")));

                        return true;
                    }

                    sender.sendMessage(ChatColor.translateAlternateColorCodes(
                            '&',
                            plugin.getConfig().getString("messages.reload")));
                }

                plugin.getConfigHandler().loadConfig();
            }
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    plugin.getConfig().getString("messages.help")));
        }

        return true;
    }
}
