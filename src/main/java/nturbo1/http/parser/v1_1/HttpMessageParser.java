package nturbo1.http.parser.v1_1;

import nturbo1.exceptions.parser.HttpMessageParseException;
import nturbo1.http.HttpMethod;
import nturbo1.log.CustomLogger;

public class HttpMessageParser
{
    public static final char CARRIAGE_RETURN_CHAR = 13;
    public static final char LINE_FEED_CHAR = 10;
    public static final float HTTP_VERSION_1_1 = 1.1f;

    private static final CustomLogger log = CustomLogger.getLogger(HttpMessageParser.class.getName());

    public static HttpMethod parseHttpMethod(String method) throws HttpMessageParseException
    {
        try {
            return HttpMethod.valueOf(method);
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage());
            throw new HttpMessageParseException("Unknown HTTP Method: " + method);
        }
    }

    public static float parseHttpVersion(String version) throws HttpMessageParseException
    {
        if (version.length() < 8)
        {
            throw new HttpMessageParseException("HTTP Version string is too short: " + version);
        }

        char[] versionChars = version.toCharArray();
        if (
                versionChars[0] != 'H' ||
                versionChars[1] != 'T' ||
                versionChars[2] != 'T' ||
                versionChars[3] != 'P' ||
                versionChars[4] != '/'
        ) {
            throw new HttpMessageParseException("Invalid HTTP version string format: " + version);
        }

        String versionNum = version.substring(5);
        try {
            return Float.parseFloat(versionNum);
        } catch(NumberFormatException e) {
            log.error(e.getMessage());
            throw new HttpMessageParseException("Invalid HTTP version number: " + versionNum);
        }
    }
}