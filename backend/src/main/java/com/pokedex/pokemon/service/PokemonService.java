package com.pokedex.pokemon.service;

import com.pokedex.pokemon.model.Pokemon;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {



    private Pokemon pokemonMapper(String response) {
        JSONObject jsonObject = new JSONObject(response);

        String name;
        int id;
        int generationId;
        String imageUrl;
        String iconUrl;
        String type;
        String species;
        double height;
        double weight;
        List<String> abilities;

        return new Pokemon();
    }
}
