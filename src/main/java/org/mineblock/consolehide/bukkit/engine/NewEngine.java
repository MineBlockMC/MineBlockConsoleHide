package org.mineblock.consolehide.bukkit.engine;

import org.mineblock.consolehide.bukkit.BukkitPlugin;
import org.mineblock.consolehide.bukkit.LogFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class NewEngine implements EngineInterface {
    private final BukkitPlugin plugin;
    private int msgHidden = 0;

    public NewEngine(BukkitPlugin plugin) {
        this.plugin = plugin;
    }

    public int getHiddenMessagesCount() {
        return this.msgHidden;
    }

    public void addHiddenMsg() {
        this.msgHidden++;
    }

    public void hideConsoleMessages() {
        ((Logger) LogManager.getRootLogger()).addFilter(new LogFilter(this.plugin));
    }
}
