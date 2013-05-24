package it.dbcSample;

import com.google.java.contract.Ensures;

/**
 * Created with IntelliJ IDEA.
 * User: Tonyx
 * Date: 20/05/2013
 * Time: 16:09
 * To change this template use File | Settings | File Templates.
 */
public interface Incrementer {
    @Ensures("result==i+1")
    public int inc(int i);
}
