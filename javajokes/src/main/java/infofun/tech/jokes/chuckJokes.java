package infofun.tech.jokes;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by tfbarbosa on 08/08/17.
 */

public class chuckJokes {

    String url = "https://api.chucknorris.io/jokes/random";

    public String getJoke() {
        Joker norris = null;

        try {
            URL api = new URL(url);
            URLConnection connection = api.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();

            JSONArray jArray = new JSONArray(response.toString());
            JSONObject jObject = jArray.getJSONObject(0);
            norris = new Joker(jObject.getString("value"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return norris.getJoke();
    }
}