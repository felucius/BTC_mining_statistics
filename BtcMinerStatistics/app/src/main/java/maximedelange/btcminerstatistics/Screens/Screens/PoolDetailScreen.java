package maximedelange.btcminerstatistics.Screens.Screens;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import maximedelange.btcminerstatistics.R;
import maximedelange.btcminerstatistics.Screens.Domain.BlockNumber;

public class PoolDetailScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pool_detail_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        changeNavigationBar();
        getPoolInformation();
    }

    public void changeNavigationBar(){
        setTitle("Pool information");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#071e22")));
    }

    public void getPoolInformation(){
        Intent intent = getIntent();
        intent.getExtras();

        BlockNumber blockInformation = (BlockNumber) intent.getSerializableExtra("poolInformation");
        displayDetailedPoolInformation(blockInformation);
    }

    public void displayDetailedPoolInformation(BlockNumber blockInformation){
        TextView blockID = (TextView) findViewById(R.id.txtBlockID);
        TextView dateStarted = (TextView) findViewById(R.id.txtDateStarted);
        TextView confirmation = (TextView) findViewById(R.id.txtConfirmation);
        TextView totalScore = (TextView) findViewById(R.id.txtTotalScores);
        TextView dateFound = (TextView) findViewById(R.id.txtDateFound);
        TextView reward = (TextView) findViewById(R.id.txtReward);
        TextView miningDuration = (TextView) findViewById(R.id.txtMiningDuration);
        TextView hashrate = (TextView) findViewById(R.id.txtHashRate);
        TextView totalShare = (TextView) findViewById(R.id.txtTotalShares);
        TextView mature = (TextView) findViewById(R.id.txtIsMature);

        blockID.setText("BLOCK ID: " + blockInformation.getID());
        dateStarted.setText("DATE STARTED: " + blockInformation.getDateStarted());
        confirmation.setText(String.valueOf("CONFIRMATION: " + blockInformation.getConfirmation()));
        totalScore.setText(String.valueOf("Total score: " + blockInformation.getTotalScore()));
        dateFound.setText("DATE FOUND: " + blockInformation.getDateFound());
        reward.setText(String.valueOf("REWARD: " + blockInformation.getReward()));
        miningDuration.setText(String.valueOf("MINING DURATION: " + blockInformation.getMiningDuration()));
        hashrate.setText(String.valueOf("HASHRATE: " + blockInformation.getHash()));
        totalShare.setText(String.valueOf("TOTAL SHARE: " + blockInformation.getTotalShare()));
        mature.setText(String.valueOf("MATURE: " + blockInformation.getMature()));
    }

}
