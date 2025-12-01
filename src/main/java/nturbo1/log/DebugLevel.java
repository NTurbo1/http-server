package nturbo1.log;

import java.util.logging.Level;

public class DebugLevel extends Level
{
    public static final Level DEBUG = new DebugLevel("DEBUG", Level.INFO.intValue() + 25);

    protected DebugLevel(String name, int value) { super(name, value); }
}