package nturbo1.server;

import nturbo1.log.CustomLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Connection
{
    private final Socket socket;

    private static final CustomLogger log = CustomLogger.getLogger(Connection.class.getName());

    public Connection(Socket socket) { this.socket = socket; }

    public void handle()
    {
        InputStream iStream = null;
        try {
            iStream = socket.getInputStream();
        } catch (IOException e) {
            log.error("Couldn't get the socket input stream due to: " + e.getMessage());
            close();

            return;
        }

        BufferedReader bufReader = new BufferedReader(new InputStreamReader(iStream));

        String line;
        try {
            line = bufReader.readLine();
        } catch (IOException e) {
            log.error("Failed to read a line from the socket input stream reader due to: " + e.getMessage());
            close();

            return;
        }

        log.fixme("IMPLEMENT HTTP REQUEST PARSER!!!");
        close();
    }

    private void close()
    {
        try {
            socket.close();
        } catch (IOException e) {
            log.error("Failed to close the socket connection due to: " + e.getMessage());
        }
    }
}