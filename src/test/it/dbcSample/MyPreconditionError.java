package test.it.dbcSample;

import com.google.java.contract.PreconditionError;

/**
 * Created with IntelliJ IDEA.
 * User: Tonyx
 * Date: 11/04/2013
 * Time: 16:52
 * To change this template use File | Settings | File Templates.
 */
public class MyPreconditionError extends PreconditionError{
    public MyPreconditionError(String s, PreconditionError preconditionError) {
        //super(s, this);
        super(s, preconditionError);
    }
}
