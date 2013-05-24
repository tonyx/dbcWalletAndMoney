package it.dbcSample;

import com.google.java.contract.Requires;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import static com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.*;

/**
 * Created with IntelliJ IDEA.
 * User: Tonyx
 * Date: 17/05/2013
 * Time: 16:14
 * To change this template use File | Settings | File Templates.
 */
public  class Utils {

    @Requires({"!userExists(userName)"})
    public void addUser(String userName) {

        String me = userName;

    }

    public boolean userExists(String user) {
        return true;
    }

    @Requires ({"userExists(userName)"})
    public User findUser(String userName) {


        String you = userName;

        return null;
    }



    public void blaBla() {
        addUser("ohi");
        findUser("ohy");
    }

}
