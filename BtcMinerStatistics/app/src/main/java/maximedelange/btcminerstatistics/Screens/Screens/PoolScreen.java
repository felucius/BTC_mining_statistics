package maximedelange.btcminerstatistics.Screens.Screens;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import maximedelange.btcminerstatistics.R;
import maximedelange.btcminerstatistics.Screens.Domain.BlockNumber;
import maximedelange.btcminerstatistics.Screens.Domain.JSONParser;
import maximedelange.btcminerstatistics.Screens.Domain.Pool;

public class PoolScreen extends AppCompatActivity {
    // Fields
    private HashMap<Integer, HashMap<Integer, BlockNumber>> pools = null;
    private Pool pool = null;
    private HashMap<Integer, BlockNumber> blockNumbers = null;
    private JSONParser jsonParser = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pool_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        changeNavigationBar();
        pool = new Pool();
        pools = new HashMap<>();
        jsonParser = new JSONParser();
        apiCall();
        //displayPoolInformation();
        showListOfBlocks();
    }

    public void changeNavigationBar(){
        setTitle("Pool information");
        //getActionBar().setIcon(R.mipmap.ic_launcher);
    }

    public void displayPoolInformation(){
        blockNumbers = new HashMap<>();
        Integer id = 1;
        /*
        if(pools != null){
            TextView blockNr = (TextView) findViewById(R.id.txtBlockNr);
            TextView dateStarted = (TextView) findViewById(R.id.txtDateStarted);
            TextView confirmation = (TextView) findViewById(R.id.txtConfirmation);
            TextView totalScore = (TextView) findViewById(R.id.txtTotalScores);
            TextView dateFound = (TextView) findViewById(R.id.txtDateFound);
            TextView reward = (TextView) findViewById(R.id.txtReward);
            TextView miningDuration = (TextView) findViewById(R.id.txtMiningDuration);
            TextView hashrate = (TextView) findViewById(R.id.txtHashRate);
            TextView totalShare = (TextView) findViewById(R.id.txtTotalShares);
            TextView mature = (TextView) findViewById(R.id.txtIsMature);

            for(Map.Entry<Integer, HashMap<Integer, BlockNumber>> pool : pools.entrySet()){
                blockNumbers = pool.getValue();
            }

            for(Map.Entry<Integer, BlockNumber> blockNumber : blockNumbers.entrySet()){
                blockNr.setText(String.valueOf("Block number: " + id));
                dateStarted.setText("Date started: " + blockNumber.getValue().getDateStarted());
                confirmation.setText(String.valueOf("Confirmation: " + blockNumber.getValue().getConfirmation()));
                totalScore.setText(String.valueOf("Total score: " + blockNumber.getValue().getTotalScore()));
                dateFound.setText("Date found: " + blockNumber.getValue().getDateFound());
                reward.setText(String.valueOf("Reward: " + blockNumber.getValue().getReward()));
                miningDuration.setText(String.valueOf("Mining duration: " + blockNumber.getValue().getMiningDuration()));
                hashrate.setText(String.valueOf("Hashrate: " + blockNumber.getValue().getHash()));
                totalShare.setText(String.valueOf("Total share: " + blockNumber.getValue().getTotalShare()));
                mature.setText(String.valueOf("Mature: " + blockNumber.getValue().getMature()));

                id ++;
            }
        }
        */
    }

    public void showListOfBlocks(){
        ArrayList<String> blockNumberList = new ArrayList<>();
        for(Map.Entry<Integer, HashMap<Integer, BlockNumber>> pool : pools.entrySet()){
            blockNumbers = pool.getValue();
        }

        for(Map.Entry<Integer, BlockNumber> blockNumber : blockNumbers.entrySet()){
            blockNumberList.add("# " + blockNumber.getKey() + " Block found: " +blockNumber.getValue().getDateFound());
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, blockNumberList);
        ListView listView = (ListView) findViewById(R.id.listviewPool);
        listView.setAdapter(adapter);
    }

    

    public void apiCall(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        pools = jsonParser.parsePoolInformation();
    }

}
