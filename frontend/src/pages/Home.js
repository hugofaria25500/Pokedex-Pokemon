import React from 'react';
import { PokemonCard } from "../components/PokemonCard.js"
import { PokemonList } from '../components/PokemonList.js'
import { NavBar } from '../components/NavBar.js';
import '../styles/Home.css';

export const Home = () => {
  return (
    <div className="home-container">
        <div className='navbar'>
            <NavBar />
        </div>
        <div className='separator'></div>
        <div className="pokemon-grid">
            <PokemonList />
        </div>
        <div className="pokemon-card">
            <PokemonCard />
        </div>
        <div className='extend-list'>
            <button>More</button>
        </div>
    </div>
  );
};