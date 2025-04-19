import React, { useEffect, useState } from 'react';
import { PokemonService } from '../services/PokemonService';
import { PokemonCard } from "./PokemonCard.js";

export const PokemonList = () => {

    const [pokemons, setPokemons] = useState([]);
    const [offset, setOffset] = useState(0);
    const limit = 24;

    useEffect(()=> {
        const fetchPokemons = async() => {
            const newPokemons = await PokemonService.getAllPokemons(limit, offset);
            setPokemons([...pokemons, ...newPokemons]);
        };

        fetchPokemons();
    }, [offset]);

    const loadMore = () => {
      setOffset(prev => prev + limit);
    };

    function capitalize (str) {
        return str.charAt(0).toUpperCase() + str.slice(1);
    } 

    function capitalizeArray(typesArr) {
        return typesArr.map(type => type.charAt(0).toUpperCase() + type.slice(1));
    }

    return (
      <div className='pokemon-list-container'>
          <div className="pokemon-grid">
              {pokemons.map(pokemon => (
                  <PokemonCard
                      key={pokemon.id}
                      pokemonId={pokemon.id}
                      pokemonName={capitalize(pokemon.name)}
                      imageUrl={pokemon.imageUrl}
                      types={capitalizeArray(pokemon.types)}
                  />
              ))}
          </div>
          <div className="buttonSection">
              <button onClick={loadMore}>See More</button>
          </div>
      </div>
      
    );
};