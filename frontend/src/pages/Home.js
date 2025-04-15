import React from 'react';
import { PokemonList } from '../components/PokemonList.js'
import { NavBar } from '../components/NavBar.js';
import '../styles/Home.css';

export const Home = () => {
  return (
    <div className="home-container">
        <div className='navbar'>
            <NavBar />
        </div>
        <div className='separator'/>
        <PokemonList />
        <div className='extend-list'>
            <button>More</button>
        </div>
    </div>
  );
};