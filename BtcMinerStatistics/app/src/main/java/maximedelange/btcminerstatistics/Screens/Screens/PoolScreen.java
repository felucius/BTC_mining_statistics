package maximedelange.btcminerstatistics.Screens.Screens;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import maximedelange.btcminerstatistics.R;

public class PoolScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pool_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        changeNavigationBar();
    }

    public void changeNavigationBar(){
        setTitle("Pool information");
        //getActionBar().setIcon(R.mipmap.ic_launcher);
    }

}
