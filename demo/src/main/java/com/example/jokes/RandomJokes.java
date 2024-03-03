package com.example.jokes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RandomJokes {
    public static void main(String[] args) throws IOException  {
        System.out.println("Random joke is : "+ getRandomJoke("https://officialjokeapi.onrender.com/jokes/programming/random"));
        System.out.println("Random 10 jokes are : "+getRandomJoke("https://officialjokeapi.onrender.com/jokes/programming/ten"));
    }

    public static JsonNode getRandomJoke(String jokeAPI)throws IOException {
        URL url = new URL(jokeAPI);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder joke = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            joke.append(line);
        }
        reader.close();
        connection.disconnect();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(joke.toString());
        return jsonNode;
    }
}
