import React from 'react';
import { SearchBar } from '../components/SearchBar.js';
import '../styles/PokemonDetails.css';

export const PokemonDetails = () => {
    return (
        <div className="pokemonDetails-container">
            <SearchBar />
        </div>
    )
}