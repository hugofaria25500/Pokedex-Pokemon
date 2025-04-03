package com.pokedex.pokemon.model;

import java.util.List;

public class Pokemon {
    private String name;
    private int id;
    private int generationId;
    private String imageUrl;
    private String iconUrl;
    private String type;
    private String species;
    private double height;
    private double weight;
    private List<String> abilities;

    public Pokemon(String name, int id, int generationId, String imageUrl, String iconUrl, String type, String species, double height, double weight, List<String> abilities) {
        this.name = name;
        this.id = id;
        this.generationId = generationId;
        this.imageUrl = imageUrl;
        this.iconUrl = iconUrl;
        this.type = type;
        this.species = species;
        this.height = height;
        this.weight = weight;
        this.abilities = abilities;
    }

    public Pokemon() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGenerationId() {
        return generationId;
    }

    public void setGenerationId(int generationId) {
        this.generationId = generationId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", generationId=" + generationId +
                ", imageUrl='" + imageUrl + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", type='" + type + '\'' +
                ", species='" + species + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", abilities=" + abilities +
                '}';
    }
}
