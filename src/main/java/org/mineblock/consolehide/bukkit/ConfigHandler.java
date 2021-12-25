package org.mineblock.consolehide.bukkit;

import java.util.List;

public class ConfigHandler {
    private final BukkitPlugin plugin;

    public ConfigHandler(BukkitPlugin plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    public void loadConfig() {
        plugin.saveDefaultConfig();
    }

    public List<String> getStringList(String key) {
        if (!this.plugin.getConfig().contains(key)) {
            this.plugin.getLogger().severe("Could not locate '" + key + "' in the config.yml inside of the " + BukkitPlugin.pluginName + " folder! (Try generating a new one by deleting the current)");
            return null;
        }
        return this.plugin.getConfig().getStringList(key);
    }

    public String getStringWithColor(String key) {
        if (!this.plugin.getConfig().contains(key)) {
            this.plugin.getLogger().severe("Could not locate " + key + " in the config.yml inside of the " + BukkitPlugin.pluginName + " folder! (Try generating a new one by deleting the current)");
            return "errorCouldNotLocateInConfigYml:" + key;
        }
        return this.plugin.getConfig().getString(key).replaceAll("&", "§");
    }
}
