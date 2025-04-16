import React from "react";
import { AiOutlineSearch } from "react-icons/ai";
 
export const SearchBar = () => {
    return (
        <div className='searchBar-container'>
            <div className="searchBar">
                <input type="text" placeholder="Charmander e.g"></input>
                <span className="searchButton">
                    <AiOutlineSearch />
                </span>
                <button className="filterButton">Filter</button>
                <div className='separator'/>
            </div>
        </div>
    );
};