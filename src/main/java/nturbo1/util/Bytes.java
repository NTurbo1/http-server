package nturbo1.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Bytes
{
    /**
     * Reads byte by byte from a given input stream until it detects "\r\n" or '\n' or the end of the input stream.
     *
     * @param iStream the input stream that the bytes are read from.
     * @return an array of bytes read excluding the newline symbols.
     * @throws IOException any IO error happened during a reading process.
     */
    public static byte[] readLine(InputStream iStream) throws IOException
    {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        int nextByte;

        while ((nextByte = iStream.read()) != -1)
        {
            if (nextByte == '\n') { break; }

            if (nextByte == '\r')
            {
                int n = iStream.read();
                if (n == '\n') { break; }
            }

            buf.write(nextByte);
        }

        return buf.toByteArray();
    }

    public static void read(InputStream iStream, byte[] buf) throws IOException
    {
        for (int i = 0; i < buf.length; i++)
        {
            buf[i] = (byte) iStream.read();
        }
    }
}