package org.mineblock.consolehide.bukkit;

import org.mineblock.consolehide.bukkit.engine.EngineInterface;
import org.mineblock.consolehide.bukkit.engine.NewEngine;
import org.mineblock.consolehide.bukkit.engine.OldEngine;

import org.bukkit.Bukkit;

import org.bukkit.event.HandlerList;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public class BukkitPlugin extends JavaPlugin {
    public static Logger log;
    public static String pluginName;
    private static ConfigHandler cH;
    private static EngineInterface eng;
    public boolean oldEngine = false;

    public void onEnable() {
        pluginName = getDescription().getName();
        log = getLogger();
        getMcVersion();

        cH = new ConfigHandler(this);

        if (this.oldEngine) {
            eng = new OldEngine(this);
        } else {
            eng = new NewEngine(this);
        }

        CommandHandler cmd = new CommandHandler(this);
        getCommand("csf").setExecutor(cmd);

        getEngine().hideConsoleMessages();
    }

    public void onDisable() {
        Bukkit.getScheduler().cancelTasks(this);
        HandlerList.unregisterAll(this);
    }

    private void getMcVersion() {
        String[] serverVersion = Bukkit.getBukkitVersion().split("-");
        String version = serverVersion[0];
        log.info("Server version detected: " + version);

        if (getConfig().getBoolean("general.use-old-engine", false) ||
                version.matches("1.7.10") || version.matches("1.7.9") ||
                version.matches("1.7.5") || version.matches("1.7.2") ||
                version.matches("1.8.8") || version.matches("1.8.3") ||
                version.matches("1.8.4") || version.matches("1.8") ||
                version.matches("1.9") || version.matches("1.9.1") ||
                version.matches("1.9.2") || version.matches("1.9.3") ||
                version.matches("1.9.4") || version.matches("1.10") ||
                version.matches("1.10.1") || version.matches("1.10.2") ||
                version.matches("1.11") || version.matches("1.11.1") ||
                version.matches("1.11.2")) {
            this.oldEngine = true;
        } else if (version.matches("1.13") || version.matches("1.13.1") ||
                version.matches("1.13.2") || version.matches("1.14") ||
                version.matches("1.14.1") || version.matches("1.14.2") ||
                version.matches("1.14.3") || version.matches("1.14.4") ||
                version.matches("1.15") || version.matches("1.15.1") ||
                version.matches("1.15.2") || version.matches("1.16") ||
                version.matches("1.16.1") || version.matches("1.16.2") ||
                version.matches("1.16.3") || version.matches("1.16.4") ||
                version.matches("1.16.5") || version.matches("1.17") ||
                version.matches("1.17.1") || version.matches("1.18") ||
                version.matches("1.18.1")) {
            this.oldEngine = false;
        } else {
            this.oldEngine = false;
        }
    }

    public ConfigHandler getConfigHandler() {
        return cH;
    }

    public EngineInterface getEngine() {
        return eng;
    }
}
