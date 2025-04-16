import React from 'react';
import { SearchBar } from '../components/SearchBar.js';
import { PokemonList } from '../components/PokemonList.js'
import { MoreButton } from '../components/MoreButton.js';
import '../styles/Home.css';

export const Home = () => {
  return (
    <div className="home-container">
        <SearchBar />
        <PokemonList />
        <MoreButton />
    </div>
  );
};