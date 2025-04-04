package com.pokedex.pokemon.service;

import com.pokedex.pokemon.PokemonAPI;
import com.pokedex.pokemon.model.Pokemon;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class PokemonService {

    private List<Pokemon> pokemonList;

    public List<Pokemon> findAll() throws IOException, InterruptedException {
        pokemonList = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest requestFindAll = HttpRequest.newBuilder()
                .uri(URI.create(PokemonAPI.FIND_ALL))
                .build();

        HttpResponse<String> responseFindAll = client.send(requestFindAll, HttpResponse.BodyHandlers.ofString());
        JSONObject pokemonJsonResponse = new JSONObject(responseFindAll.body());
        JSONArray resultsArray = pokemonJsonResponse.getJSONArray("results");

        List<CompletableFuture<Pokemon>> futures = new ArrayList<>();

        for (Object obj : resultsArray) {
            JSONObject pokemonJson = (JSONObject) obj;

            CompletableFuture<Pokemon> future = CompletableFuture.supplyAsync(() -> {
                try {
                    return pokemonMapper(pokemonJson);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                    return null;
                }
            });

            futures.add(future);
        }

        for (CompletableFuture<Pokemon> future : futures) {
            pokemonList.add(future.join()); // "join" espera a conclusão de cada requisição
        }

        return pokemonList;
    }

    public Pokemon findByName(String name) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest requestFindAll = HttpRequest.newBuilder()
                .uri(URI.create(PokemonAPI.FIND_BY_NAME + name))
                .build();

        HttpResponse<String> responseFindByName = client.send(requestFindAll, HttpResponse.BodyHandlers.ofString());
        JSONObject pokemonJsonResponse = new JSONObject(responseFindByName.body());

        int id = pokemonJsonResponse.getInt("id"); //"id"
        int generationId = 0;
        String imageUrl = "";
        String iconUrl = "";
        String type = "";
        String species = "";
        double height = 0; //"height"
        double weight = 0; //"weight"
        List<String> abilities = new ArrayList<>(); //abilities

        return new Pokemon(null, id,generationId, imageUrl, iconUrl, type, species, height, weight, abilities);
    }

    private Pokemon pokemonMapper(JSONObject jsonObject) throws IOException, InterruptedException {
        String name = jsonObject.getString("name"); //"name"
        Pokemon pokemon = findByName(name);
        pokemon.setName(name);
        return pokemon;
    }
}
