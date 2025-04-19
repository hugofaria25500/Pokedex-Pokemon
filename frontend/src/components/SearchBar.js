import React from "react";
import { useNavigate } from 'react-router-dom';
import { AiOutlineSearch } from "react-icons/ai";
import logo from "../resources/logo.png";
import pokeball from "../resources/pokeball.png";

export const SearchBar = () => {
  const navigate = useNavigate();
    
    function redirectToHome() {
      navigate("/pokemon");
    }

    return (
        <div className='navbar-container'>
          
            <div className="logo-container">
                <img src={logo} alt="Logo"/>
            </div>
            <div className="searchBar-container">
                <div className="searchBar">
                    <div className="searchBar-left">
                        <input type="text" placeholder="Bulbasaur e.g"></input>
                        <div className="searchButton">
                            <AiOutlineSearch />
                        </div>
                    </div>
                    <div className="searchBar-right">
                        <button className="filterButton">Filter</button>
                    </div>
                </div>
                <div className='separator'/>
            </div>
            <div className="pokeball-container" onClick={redirectToHome}>
                <img src={pokeball} alt="Pokeball"/>
            </div>
        </div>
    );
};