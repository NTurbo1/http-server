package nturbo1.log;

import java.util.logging.Level;

public class FixMeLevel extends Level
{
    public static final Level FIXME = new FixMeLevel("FIXME", Level.WARNING.intValue() + 25);

    protected FixMeLevel(String name, int value) { super(name, value); }
}