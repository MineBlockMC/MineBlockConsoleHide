package org.mineblock.consolehide.bukkit.engine;

public interface EngineInterface {
    void hideConsoleMessages();

    int getHiddenMessagesCount();

    void addHiddenMsg();
}
