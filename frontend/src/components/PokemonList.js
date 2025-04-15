import React from "react";
import { PokemonCard } from "./PokemonCard.js";
import grass from "../resources/bulbasur_test.svg";
import fire from "../resources/charmander_test.svg";
import water from "../resources/squirtle_test.svg";
import normal from "../resources/snorlax_test.svg";
import eletric from "../resources/pikachu_test.svg";
import ice from "../resources/glaceon_test.svg";
import fighting from "../resources/machamp_test.svg";
import poison from "../resources/gengar_test.svg";
import ground from "../resources/garchomp_test.svg";
import flying from "../resources/pidgeot_test.svg";
import psychic from "../resources/alakazam_test.svg";
import bug from "../resources/scyther_test.svg";
import rock from "../resources/onix_test.svg";
import ghost from "../resources/mismagious_test.svg";
import dragon from "../resources/dragonite_test.svg";
import dark from "../resources/umbreon_test.svg";
import steel from "../resources/metagross_test.svg";
import fairy from "../resources/togekiss_test.svg";

export const PokemonList = () => {
  return (
    <div className="pokemon-grid">
        <PokemonCard pokemonId="#001" imageUrl={grass} pokemonName="Bulbusar" types={["Grass", "Normal"]}/>
        <PokemonCard pokemonId="#002" imageUrl={fire} pokemonName="Charmander" types={["Fire", "Ghost"]}/>
        <PokemonCard pokemonId="#003" imageUrl={water} pokemonName="Squirtle" types={["Water", "Dragon"]}/>
        <PokemonCard pokemonId="#143" imageUrl={normal} pokemonName="Snorlax" types={["Normal"]}/>
        <PokemonCard pokemonId="#025" imageUrl={eletric} pokemonName="Pikachu" types={["Eletric"]}/>
        <PokemonCard pokemonId="#471" imageUrl={ice} pokemonName="Glaceon" types={["Ice"]}/>
        <PokemonCard pokemonId="#068" imageUrl={fighting} pokemonName="Machamp" types={["Fighting"]}/>
        <PokemonCard pokemonId="#094" imageUrl={poison} pokemonName="Gengar" types={["Poison"]}/>
        <PokemonCard pokemonId="#445" imageUrl={ground} pokemonName="Garchomp" types={["Ground"]}/>
        <PokemonCard pokemonId="#018" imageUrl={flying} pokemonName="Pidgeot" types={["Flying"]}/>
        <PokemonCard pokemonId="#065" imageUrl={psychic} pokemonName="Alakazam" types={["Psychic"]}/>
        <PokemonCard pokemonId="#123" imageUrl={bug} pokemonName="Scyther" types={["Bug"]}/>
        <PokemonCard pokemonId="#095" imageUrl={rock} pokemonName="Onix" types={["Rock"]}/>
        <PokemonCard pokemonId="#429" imageUrl={ghost} pokemonName="Mismagious" types={["Ghost"]}/>
        <PokemonCard pokemonId="#149" imageUrl={dragon} pokemonName="Dragonite" types={["Dragon"]}/>
        <PokemonCard pokemonId="#197" imageUrl={dark} pokemonName="Umbreon" types={["Dark"]}/>
        <PokemonCard pokemonId="#376" imageUrl={steel} pokemonName="Metagross" types={["Steel"]}/>
        <PokemonCard pokemonId="#468" imageUrl={fairy} pokemonName="Togekiss" types={["Fairy"]}/>
    </div>
  );
};