package io;

/**
 * Created with IntelliJ IDEA.
 * User: Tony
 * Date: 11/02/13
 * Time: 15.27
 * To change this template use File | Settings | File Templates.
 */
public class ConsoleOutputStream implements OutputStream {
    public void print(String hello) {
        System.out.println(hello);
    }
}
