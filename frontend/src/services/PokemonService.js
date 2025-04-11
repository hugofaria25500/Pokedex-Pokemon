import axios from 'axios';

const API_BASE_URL_FIND_FIRST = 'http://localhost:8080/api/pokemon';

export const PokemonService = {
    getAllPokemons: async () => {
        try {
            const response = await axios.get(`${API_BASE_URL_FIND_FIRST}`);
            return response.data;
        } catch (error) {
            console.error('Erro ao buscar os Pokémons:', error);
            return [];
        }
    }
    /*
    getPokemonByName: async (name) => {
        try {
            const response = await axios.get(`${API_BASE_URL}/pokemon/${name}`);
            return response.data;
        } catch (error) {
            console.error(`Erro ao buscar o Pokémon ${name}:`, error);
            return null;
        }
    }*/
}