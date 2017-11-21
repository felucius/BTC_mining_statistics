package maximedelange.btcminerstatistics.Screens.Screens;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import maximedelange.btcminerstatistics.R;
import maximedelange.btcminerstatistics.Screens.Domain.JSONParser;
import maximedelange.btcminerstatistics.Screens.Domain.User;

public class UserScreen extends AppCompatActivity {

    // Fields
    private User user = null;
    private JSONParser jsonParser = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        changeNavigationBar();
        user = new User();
        jsonParser = new JSONParser();
        apiCall();
        displayUserInformation();
    }

    public void changeNavigationBar(){
        setTitle("Account information");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#071e22")));
    }

    public void displayUserInformation(){
        if(user != null){
            TextView username = (TextView) findViewById(R.id.txtUserName);
            TextView unconfirmedReward = (TextView) findViewById(R.id.txtUnconfirmedReward);
            TextView mineRating = (TextView) findViewById(R.id.txtMineRating);
            TextView estimatedReward = (TextView) findViewById(R.id.txtEstimatedReward);
            TextView hashrate = (TextView) findViewById(R.id.txtHashrate);
            TextView threshold = (TextView) findViewById(R.id.txtSendThreshold);
            TextView confirmedReward = (TextView) findViewById(R.id.txtConfirmedReward);
            TextView lastShare = (TextView) findViewById(R.id.txtLastShare);
            TextView lastScore = (TextView) findViewById(R.id.txtScore);
            TextView alive = (TextView) findViewById(R.id.txtAlive);
            TextView wallet = (TextView) findViewById(R.id.txtWallet);
            ImageView profilePicture = (ImageView) findViewById(R.id.imgProfile);

            username.setText("Username: " + user.getUsername());
            unconfirmedReward.setText(String.valueOf("Unconfirmed reward:" + user.getUnconfirmedReward()));
            mineRating.setText(String.valueOf("Mining rating: " + user.getRating()));
            estimatedReward.setText(String.valueOf("Estimated reward: " + user.getEstimatedReward()));
            hashrate.setText(String.valueOf("Hashrate: " + user.getHashRate()));
            threshold.setText(String.valueOf("Threshold: " + user.getSendThreshold()));
            confirmedReward.setText(String.valueOf("Conformed reward: " + user.getConfirmedReward()));
            lastShare.setText(String.valueOf("Last share: " + user.getLastShare()));
            lastScore.setText(String.valueOf("Last score: " + user.getLastShare()));
            alive.setText(String.valueOf("Worder alive: " + user.getAlive()));
            wallet.setText("Wallet: " + user.getWallet());
            profilePicture.setImageResource(R.mipmap.maxime);
        }else{
            System.out.println("No user available.");
        }
    }

    public void apiCall(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        user = jsonParser.parseUserInformation();
    }
}
