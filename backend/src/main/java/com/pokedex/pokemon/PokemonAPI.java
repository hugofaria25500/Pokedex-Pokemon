package com.pokedex.pokemon;

public class PokemonAPI {

    public static final String FIND_DEFAULT = "https://pokeapi.co/api/v2/pokemon";
    public static final String FIND_BY_NAME = "https://pokeapi.co/api/v2/pokemon/";

    public static final String FIND_BY_ID = "https://pokeapi.co/api/v2/pokemon/";

    public static final String FIND_GENERATION_BY_POKEMON_ID = "https://pokeapi.co/api/v2/pokemon-species/";

    public static String findPokemonWithinRange(int offset, int limit) {
        return String.format("%s?offset=%d&limit=%d", FIND_DEFAULT, offset, limit);
    }

    public static String findPokemonById(int id) {
        return String.format("%s/%d", FIND_BY_ID, id);
    }
}
