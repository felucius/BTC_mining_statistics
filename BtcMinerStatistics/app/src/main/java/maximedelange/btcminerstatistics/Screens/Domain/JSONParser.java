package maximedelange.btcminerstatistics.Screens.Domain;

import java.util.HashMap;

/**
 * Created by M on 11/17/2017.
 */

public class JSONParser {
    // Fields
    private User user = null;
    private Pool pool = null;
    private HashMap<Integer, User> users = null;
    private HashMap<Integer, Pool> pools = null;

    // Constructor
    public JSONParser(){

    }

    // Methods
    public HashMap<Integer, User> parseUserInformation(String userInfo){
        return users;
    }

    public HashMap<Integer, Pool> parsePoolInformation(String poolInfo){
        return this.pools;
    }
}
