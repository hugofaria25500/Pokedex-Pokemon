package com.pokedex.pokemon.controller;

import com.pokedex.pokemon.model.Pokemon;
import com.pokedex.pokemon.service.PokemonService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
@CrossOrigin(origins = "http://localhost:3000")
public class PokemonController {
    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<Pokemon> getPokemonList(@RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "24") int limit) throws IOException, InterruptedException {
        return pokemonService.findFirstDefault(offset, limit);
    }

    @GetMapping("/{id}")
    public Pokemon getPokemon(@PathVariable int id) {
        return null;
    }
}
