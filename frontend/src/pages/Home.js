import React from 'react';
import { SearchBar } from '../components/SearchBar.js';
import { PokemonList } from '../components/PokemonList.js'
import '../styles/Home.css';

export const Home = () => {
  return (
    <div className="home-container">
        <SearchBar />
        <PokemonList />
    </div>
  );
};