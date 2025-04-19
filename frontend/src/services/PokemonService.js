import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api/pokemon';

export const PokemonService = {
  getAllPokemons: async (limit = 20, offset = 0) => {
    try {
      const response = await axios.get(`${API_BASE_URL}?limit=${limit}&offset=${offset}`);
      return response.data;
    } catch (error) {
      console.error('Erro ao buscar os Pokémons:', error);
      return [];
    }
  }
};