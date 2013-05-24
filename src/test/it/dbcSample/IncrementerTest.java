package test.it.dbcSample;

import it.dbcSample.Incrementer;
import it.dbcSample.IncrementerImpl;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tonyx
 * Date: 20/05/2013
 * Time: 16:11
 * To change this template use File | Settings | File Templates.
 */
public class IncrementerTest {
    @Ignore
    @Test
    public void respectPostConditionTest() {

        Incrementer incrementer = new IncrementerImpl();

        incrementer.inc(1);
    }
}
