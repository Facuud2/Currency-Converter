package github.facuud2.services;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PairConvertion {

    public ConvertionRateRec pairConvertion(String from, String to) {
        String API_KEY = "b5c48f0c79b05880414ae9d9";
        URI url = URI.create("https://v6.exchangerate-api.com/v6/"+API_KEY+"/pair/"+from+"/"+to);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        HttpResponse<String> response;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        String responseJson = response.body();

        return new Gson().fromJson(responseJson, ConvertionRateRec.class);
    }
}
