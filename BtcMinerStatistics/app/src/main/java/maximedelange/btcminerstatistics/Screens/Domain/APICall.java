package maximedelange.btcminerstatistics.Screens.Domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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
    public String getUserInformation(String url){
        try {
            this.url = new URL(url);
            urlConnection = (HttpURLConnection) this.url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            reader = new BufferedReader(new InputStreamReader(this.url.openStream()));
            builder = new StringBuilder();

            String line = null;
            while((line = reader.readLine()) != null){
                builder.append(line + "\n");
            }

            reader.close();

            String JSONString = builder.toString();
            System.out.println(JSONString);
            return JSONString;
        } catch(IOException ioEx){
            ioEx.getLocalizedMessage();
        }

        return null;
    }

    public String getPoolInformation(String url){
        try {
            this.url = new URL(url);
            urlConnection = (HttpURLConnection) this.url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            reader = new BufferedReader(new InputStreamReader(this.url.openStream()));
            builder = new StringBuilder();

            String line = null;
            while((line = reader.readLine()) != null){
                builder.append(line + "\n");
            }

            reader.close();
            String JSONString = builder.toString();
            System.out.println(JSONString);
            return JSONString;
        }catch (IOException ioEx){
            ioEx.getLocalizedMessage();
        }

        return null;
    }
}
