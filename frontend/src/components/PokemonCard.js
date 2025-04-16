import React from "react";

export const PokemonCard = (props) => {
    return (
        <div className="pokemon-card">
            <div className="card-top">
                <div className={`circle circle-type-${props.types[0].toLowerCase()}`}/>
                <h3 className="pokemonId">{props.pokemonId}</h3>
                <img className="pokemonImage" src={props.imageUrl} alt=""></img>
            </div>
            <div className="card-bottom">
                <h3 className="pokemonName">{props.pokemonName}</h3>
                <div className="pokemonTypes">
                    {Array.isArray(props.types) && props.types.map((type, index) => (
                        <span key={index} className={`type-${type.toLowerCase()}`}>
                            {type}
                        </span>
                    ))}
                </div>
            </div>
        </div>
    );
};