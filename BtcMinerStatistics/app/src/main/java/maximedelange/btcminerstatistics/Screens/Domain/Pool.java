package maximedelange.btcminerstatistics.Screens.Domain;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by M on 11/17/2017.
 */

public class Pool {
    // Fields
    private HashMap<Integer, BlockNumber> blockNumbers = null;

    // Constructor
    public Pool(){
        this.blockNumbers = new HashMap<>();
    }

    // Methods
    public void setBlockNumber(HashMap<Integer, BlockNumber> blockNumbers){this.blockNumbers = blockNumbers;}

    public HashMap<Integer, BlockNumber> getBlockNumbers(){return this.blockNumbers;}
}
