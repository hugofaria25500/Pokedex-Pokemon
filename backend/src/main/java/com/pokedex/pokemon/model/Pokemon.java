package com.pokedex.pokemon.model;

import java.util.List;

public class Pokemon {
    private String name;
    private int id;
    private String imageUrl;
    private int generation;
    private List<String> types;
    private double height;
    private double weight;
    private List<String> abilities;

    public Pokemon(String name, int id, int generationId, String imageUrl, List<String> types, double height, double weight, List<String> abilities) {
        this.name = name;
        this.id = id;
        this.generation = generationId;
        this.imageUrl = imageUrl;
        this.types = types;
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

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
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
                ", id=" + id + '\'' +
                ", generationId=" + generation + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", type='" + types + '\'' +
                ", height=" + height + '\'' +
                ", weight=" + weight + '\'' +
                ", abilities=" + abilities +
                '}';
    }
}
