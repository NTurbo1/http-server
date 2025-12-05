package nturbo1.log;

import nturbo1.cmd.Argument;

import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LogConfig
{
    public static void setup(Map<String, String> args)
    {

        LogManager.getLogManager().reset(); // wipe existing config
        Logger root = Logger.getLogger("");

        Level logLevel = isDebugMode(args) ? DebugLevel.DEBUG : Level.INFO;

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(logLevel);
        consoleHandler.setFormatter(new LogMessageFormatter());

        // TODO: ADD A FILE HANDLER !!!

        root.addHandler(consoleHandler);
        root.setLevel(logLevel);
    }

    private static boolean isDebugMode(Map<String, String> args) { return args.get(Argument.DEBUG) != null; }
}