package nturbo1.exceptions.cmd;

public class UnknownArgException extends Exception
{
    public UnknownArgException(String argName)
    {
        super("Unknown argument name: " + argName);
    }
}