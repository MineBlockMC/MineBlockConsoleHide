package org.mineblock.consolehide.bukkit.engine;

import org.mineblock.consolehide.bukkit.BukkitPlugin;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.message.Message;

public class OldEngine implements EngineInterface {
    private int msgHidden = 0;
    private final BukkitPlugin plugin;

    public OldEngine(BukkitPlugin plugin) {
        this.plugin = plugin;
    }

    public int getHiddenMessagesCount() {
        return this.msgHidden;
    }

    public void addHiddenMsg() {
        this.msgHidden++;
    }

    public void hideConsoleMessages() {
        ((Logger) LogManager.getRootLogger()).addFilter(new Filter() {
            public Result filter(LogEvent event) {
                if (!OldEngine.this.plugin.getConfigHandler().getStringList("filter").isEmpty()) {
                    for (String s : OldEngine.this.plugin.getConfigHandler().getStringList("filter")) {
                        if (event.getMessage().toString().contains(s)) {
                            OldEngine.this.msgHidden = OldEngine.this.msgHidden + 1;
                            return Filter.Result.DENY;
                        }
                    }
                }
                return null;
            }

            public Result filter(Logger arg0, Level arg1, Marker arg2, String arg3, Object... arg4) {
                return null;
            }

            @Override
            public Result filter(Logger logger, Level level, Marker marker, String message, Object p0) {
                return null;
            }

            @Override
            public Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1) {
                return null;
            }

            @Override
            public Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1, Object p2) {
                return null;
            }

            @Override
            public Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {
                return null;
            }

            @Override
            public Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
                return null;
            }

            @Override
            public Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
                return null;
            }

            @Override
            public Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
                return null;
            }

            @Override
            public Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
                return null;
            }

            @Override
            public Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
                return null;
            }

            @Override
            public Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
                return null;
            }

            @Override
            public State getState() {
                return null;
            }

            @Override
            public void initialize() {

            }

            @Override
            public void start() {

            }

            @Override
            public void stop() {

            }

            @Override
            public boolean isStarted() {
                return false;
            }

            @Override
            public boolean isStopped() {
                return false;
            }

            public Result filter(Logger arg0, Level arg1, Marker arg2, Object arg3, Throwable arg4) {
                return null;
            }

            public Result filter(Logger arg0, Level arg1, Marker arg2, Message arg3, Throwable arg4) {
                return null;
            }

            public Result getOnMatch() {
                return null;
            }

            public Result getOnMismatch() {
                return null;
            }
        });
    }
}
