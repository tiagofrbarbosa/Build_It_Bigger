package infofun.tech.jokes;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by tfbarbosa on 08/08/17.
 */

public class chuckJokes {

    public static final String BASE_URL = "http://api.icndb.com/jokes";

    public String getJoke() {
            String joke = "teste";

        try {
            StringBuilder url = new StringBuilder(BASE_URL + "/random");
            URL api = new URL(url.toString());
            URLConnection conn = api.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) response.append(line);

            in.close();

            JSONObject jsonObject = new JSONObject(new JSONTokener(response.toString()));
            JSONObject jokeObject = jsonObject.getJSONObject("value");
            joke = jokeObject.getString("joke");

        }catch (Exception e){
            joke = e.getMessage();
        }

        return joke;
    }
}