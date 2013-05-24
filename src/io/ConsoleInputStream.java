package io;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA.
 * User: Tonyx
 * Date: 14/05/2013
 * Time: 15:08
 * To change this template use File | Settings | File Templates.
 */
public class ConsoleInputStream implements InputStream {
    public String input() {
        byte[] toRead = new byte[256];
        try {
            System.in.read(toRead);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            return new String(toRead,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
