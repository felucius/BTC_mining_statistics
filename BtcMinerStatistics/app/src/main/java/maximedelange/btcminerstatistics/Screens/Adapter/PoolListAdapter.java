package maximedelange.btcminerstatistics.Screens.Adapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import maximedelange.btcminerstatistics.Screens.Domain.BlockNumber;

/**
 * Created by M on 11/20/2017.
 */

public class PoolListAdapter {

    // Fields
    private static ArrayList<BlockNumber> blockNumberList = null;
    private HashMap<Integer, BlockNumber> blockNumbers = null;
    private HashMap<Integer, HashMap<Integer, BlockNumber>> pools = null;
    private static BlockNumber[] blocks = null;

    public List<BlockNumber> convertData(){
        blockNumberList = new ArrayList<>();
        for(Map.Entry<Integer, HashMap<Integer, BlockNumber>> pool : pools.entrySet()){
            blockNumbers = pool.getValue();
        }

        for(Map.Entry<Integer, BlockNumber> blockNumber : blockNumbers.entrySet()){
            blockNumberList.add(blockNumber.getValue());
        }

        //blocks = new BlockNumber[blockNumberList.size()];
        //blocks = blockNumberList.toArray(blocks);

        return blockNumberList;
    }

    public static HashMap<String, List<BlockNumber>> getData() {

        HashMap<String, List<BlockNumber>> expandableListDetail = new HashMap<String, List<BlockNumber>>();

        List<BlockNumber> cricket = new ArrayList<BlockNumber>();
        /*
        cricket.add("India");
        cricket.add("Pakistan");
        cricket.add("Australia");
        cricket.add("England");
        cricket.add("South Africa");
        */

        List<BlockNumber> football = new ArrayList<BlockNumber>();
        /*
        football.add("Brazil");
        football.add("Spain");
        football.add("Germany");
        football.add("Netherlands");
        football.add("Italy");
        */

        List<BlockNumber> basketball = new ArrayList<BlockNumber>();
        /*
        basketball.add("United States");
        basketball.add("Spain");
        basketball.add("Argentina");
        basketball.add("France");
        basketball.add("Russia");
        */

        for(int i = 0; i < blocks.length; i++){
            expandableListDetail.put(blocks[i].getDateFound(), blockNumberList);
        }

        expandableListDetail.put("CRICKET TEAMS", cricket);
        expandableListDetail.put("FOOTBALL TEAMS", football);
        expandableListDetail.put("BASKETBALL TEAMS", basketball);
        return expandableListDetail;
    }
}
