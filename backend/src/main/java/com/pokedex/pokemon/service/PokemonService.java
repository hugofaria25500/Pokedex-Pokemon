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

    public List<Pokemon> findFirstDefault(int offset, int limit) throws IOException, InterruptedException {
        List<Pokemon> pokemonList = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest requestFindAll = HttpRequest.newBuilder()
                .uri(URI.create(PokemonAPI.findPokemonWithinRange(offset, limit)))
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

    private Pokemon pokemonMapper(JSONObject jsonObject) throws IOException, InterruptedException {
        String name = jsonObject.getString("name"); //"name"
        Pokemon pokemon = findByPokemonByName(name);
        pokemon.setName(name);
        return pokemon;
    }

    public Pokemon findByPokemonByName(String name) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest requestFindAll = HttpRequest.newBuilder()
                .uri(URI.create(PokemonAPI.FIND_BY_NAME + name))
                .build();

        HttpResponse<String> responseFindByName = client.send(requestFindAll, HttpResponse.BodyHandlers.ofString());
        JSONObject pokemonJsonResponse = new JSONObject(responseFindByName.body());

        int id = pokemonJsonResponse.getInt("id");
        int generationId = getGenerationIdByPokemonId(id);

        String imageUrl = pokemonJsonResponse.getJSONObject("sprites").getJSONObject("other").getJSONObject("dream_world").getString("front_default");

        List<String> types = new ArrayList<>();
        JSONArray typesResponse = pokemonJsonResponse.getJSONArray("types");
        for(Object obj : typesResponse) {
            JSONObject typeWrapper = (JSONObject) obj;
            JSONObject typeResponse = typeWrapper.getJSONObject("type");
            String typeName = typeResponse.getString("name");
            types.add(typeName);
        }

        double height = pokemonJsonResponse.getInt("height");
        double weight = pokemonJsonResponse.getInt("weight");

        List<String> abilities = new ArrayList<>();
        JSONArray abilitiesResponse = pokemonJsonResponse.getJSONArray("abilities");
        for(Object obj : abilitiesResponse) {
            JSONObject abilityWrapper = (JSONObject) obj;
            JSONObject abilityResponse = abilityWrapper.getJSONObject("ability");
            String abilityName = abilityResponse.getString("name");
            boolean abilityHidden = abilityWrapper.getBoolean("is_hidden");

            if(!abilityHidden) {
                abilities.add(abilityName);
            }
        }

        return new Pokemon(null, id,generationId, imageUrl, types, height, weight, abilities);
    }

    private int getGenerationIdByPokemonId(int pokemonId) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest requestFindAll = HttpRequest.newBuilder()
                .uri(URI.create(PokemonAPI.FIND_GENERATION_BY_POKEMON_ID + pokemonId))
                .build();

        HttpResponse<String> responseFindByName = client.send(requestFindAll, HttpResponse.BodyHandlers.ofString());
        JSONObject pokemonJsonResponse = new JSONObject(responseFindByName.body());

        String generationUrl = pokemonJsonResponse.getJSONObject("generation").getString("url");
        return Integer.parseInt(String.valueOf(generationUrl.charAt(generationUrl.length()-2)));
    }

    private Pokemon getPokemonById(int pokemonId) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest requestFindAll = HttpRequest.newBuilder()
                .uri(URI.create(PokemonAPI.findPokemonById(pokemonId)))
                .build();

        HttpResponse<String> responseFindByName = client.send(requestFindAll, HttpResponse.BodyHandlers.ofString());
        JSONObject pokemonJsonResponse = new JSONObject(responseFindByName.body());

        return new Pokemon();
    }
}
