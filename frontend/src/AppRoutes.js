import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import { Home } from "./pages/Home";
import { PokemonDetails } from "./pages/PokemonDetails";
import { NoPageFound } from "./pages/NoPageFound";

export const AppRoutes = () => {
    return (
      <Router>
        <Routes>
          <Route path="/" element={<Navigate to="/pokemon" />} />
          <Route path="/pokemon" element={<Home />} />
          <Route path="/pokemon/:pokemonid" element={<PokemonDetails />} />
          <Route path="*" element={<NoPageFound />} />
        </Routes>
      </Router>
    );
  };