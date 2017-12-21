package fr.ofuro.mydogtracker.tools;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import fr.ofuro.mydogtracker.models.Dog;

/**
 * Created by ofuro on 21/12/2017.
 */


//TODO: webservice à adapter
public class WebService {
    private final String URL = "http://testwebapi.lalimace.fr/api/Point";

    Gson gson;

    public WebService() {
        gson = new Gson();
    }

    private InputStream sendRequest(java.net.URL url) throws Exception {
        try {

            // Ouverture de la connexion
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            // Connexion à l’URL
            urlConnection.connect();

            // Si le serveur nous répond avec un code OK
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return urlConnection.getInputStream();
            }
        } catch (Exception e) {
            throw new Exception("");
        }
        return null;
    }

    public List<Dog> getDogs() {
        try {

            // Envoi de la requête
            InputStream inputStream = sendRequest(new URL(URL));

            // Vérification de l’inputStream
            if (inputStream != null) {

                // Lecture de l’inputStream dans un reader
                InputStreamReader reader = new InputStreamReader(inputStream);

                // Retourne la liste désérialisée par le moteur GSON
                return gson.fromJson(reader, new TypeToken<List<Dog>>() {
                }.getType());
            }
        } catch (Exception e) {

            Log.e("WebService", "Impossible de rapatrier les données :");
        }
        return null;
    }
}
