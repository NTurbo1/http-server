package nturbo1;

import nturbo1.log.ErrorLevel;
import nturbo1.log.FixMeLevel;
import nturbo1.log.LogConfig;
import nturbo1.server.HttpServer;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * The HTTP Server application.
 *
 */
public class HttpServerApplication
{
    static
    {
        LogConfig.setup();
    }

    private static final Logger logger = Logger.getLogger(HttpServerApplication.class.getName());

    public static void main( String[] args )
    {
        logger.log(FixMeLevel.FIXME, "IMPLEMENT COMMAND LINE PARSER!!!");

        HttpServer httpServer = init();
        if (httpServer == null)
        {
            logger.severe("Failed to initialize an http server! Exiting...");
            System.exit(1);
        }

        httpServer.start();
    }

    private static HttpServer init()
    {
        logger.info("Initializing an http server...");
        HttpServer httpServer = null;
        try
        {
            httpServer = new HttpServer(8080); // TODO: get the port from a command line parameter
        }
        catch(IOException ex)
        {
            logger.log(ErrorLevel.ERROR, ex.getMessage());
        }

        return httpServer;
    }
}