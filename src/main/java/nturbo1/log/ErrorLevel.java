package nturbo1.log;

import java.util.logging.Level;

public class ErrorLevel extends Level
{
    public static final int ERROR_LEVEL_VALUE = FixMeLevel.FIXME.intValue() + 25; // 950
    public static final Level ERROR = new ErrorLevel("ERROR", ERROR_LEVEL_VALUE);

    protected ErrorLevel(String name, int value) { super(name, value); }
}