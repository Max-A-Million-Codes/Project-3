import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class Project3 {
    public static JSONObject retrieveData(String pokemonName) throws Exception{
        String urlString = "https://pokeapi.co/api/v2/pokemon/" + pokemonName;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(urlString)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return new JSONObject(response.body());
        } else {
            System.out.println("Data not received. Status code: " + response.statusCode());
            return null;
        }

    }

    public static void main(String[] args) throws Exception{

        JSONObject pokemonTest = retrieveData("Pichu");

        if (pokemonTest != null){
            System.out.println("Pichu data: " + pokemonTest);
        }
    }
}
