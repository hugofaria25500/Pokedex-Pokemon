package com.pokedex.pokemon.controller;

import com.pokedex.pokemon.model.Pokemon;
import com.pokedex.pokemon.service.PokemonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {
    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<Pokemon> getPokemonList() throws IOException, InterruptedException {
        return pokemonService.findFirstDefault();
    }

    @GetMapping("/{id}")
    public Pokemon getPokemon(@PathVariable int id) {
        return null;
    }
}
