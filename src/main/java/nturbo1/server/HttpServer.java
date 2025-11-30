package nturbo1.server;

import nturbo1.log.FixMeLevel;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class HttpServer
{
    private final int port;
    private ServerSocket serverSocket;

    private static final Logger logger = Logger.getLogger(HttpServer.class.getName());

    public HttpServer(int port) throws IOException
    {
        this.port = port;
        this.serverSocket = new ServerSocket(port);
    }

    public void start()
    {
        logger.log(FixMeLevel.FIXME, "Handle requests asynchronously!");

        try
        {
            Socket socket = this.serverSocket.accept();
            InputStream iStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            iStream.read(bytes);
            System.out.printf("Received: %s\n", new String(bytes));
        }
        catch (IOException ex)
        {
            logger.severe("Failed to accept socket connection because: " + ex.getMessage());
        }
    }

    public int getPort() { return this.port; }
}