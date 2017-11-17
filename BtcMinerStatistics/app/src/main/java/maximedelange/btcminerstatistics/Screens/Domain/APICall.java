package maximedelange.btcminerstatistics.Screens.Domain;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by M on 11/17/2017.
 */

public class APICall {
    // Fields
    private HttpURLConnection urlConnection = null;
    private URL url = null;
    private BufferedReader reader = null;
    private StringBuilder builder = null;

    // Constructor
    public APICall(){

    }

    // Methods
    public void getUserInformation(String url){

    }

    public void getPoolInformation(String url){

    }
}
