package com.example.jokes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;


public class RandomJokesTest {

    @Test
    public void testRandomJokeAPI() throws IOException{
        
        JsonNode randomJokeJson = RandomJokes.getRandomJoke("https://officialjokeapi.onrender.com/jokes/programming/random");

        assertNotNull("The response is not null", randomJokeJson);

        assertNotNull("Response has 1 joke in it", randomJokeJson.get(0));

        assertTrue("Response has only 1 output as expected.",randomJokeJson.size() == 1);
        
        assertEquals("programming", randomJokeJson.get(0).get("type").asText());
    }

    @Test
    public void testTenRandomJokesAPI() throws IOException{

        JsonNode randomTenJokesJson = RandomJokes.getRandomJoke("https://officialjokeapi.onrender.com/jokes/programming/ten");
        assertNotNull("The response is not null", randomTenJokesJson);
        assertTrue("Response has exactly 10 output as expected.",randomTenJokesJson.size() == 10);

        for(int i = 0; i<randomTenJokesJson.size(); i++){
            assertEquals("programming", randomTenJokesJson.get(i).get("type").asText());
        }

    }
}

