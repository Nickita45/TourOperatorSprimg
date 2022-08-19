package edu.buem.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Country {
    private String id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private boolean isVisa;
    private int levelTourism;
    private ClimateTypes climateTypes;

    public Country(String id, String name, String description, LocalDateTime createdAt, LocalDateTime updatedAt, boolean isVisa, int levelTourism, ClimateTypes climateTypes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isVisa = isVisa;
        this.levelTourism = levelTourism;
        this.climateTypes = climateTypes;
    }

    public Country(String id, String name, boolean isVisa, int levelTourism, ClimateTypes climateTypes) {
        this.id = id;
        this.name=name;
        this.isVisa = isVisa;
        this.levelTourism = levelTourism;
        this.climateTypes = climateTypes;
        this.description = "";

        LocalDateTime now = LocalDateTime.now();
        this.createdAt=now;
        this.updatedAt=now;
    }

    public Country() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isVisa() {
        return isVisa;
    }

    public void setVisa(boolean visa) {
        isVisa = visa;
    }

    public int getLevelTourism() {
        return levelTourism;
    }

    public void setLevelTourism(int levelTourism) {
        this.levelTourism = levelTourism;
    }

    public ClimateTypes getClimateTypes() {
        return climateTypes;
    }

    public void setClimateTypes(ClimateTypes climateTypes) {
        this.climateTypes = climateTypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return id.equals(country.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", isVisa=" + isVisa +
                ", levelTourism=" + levelTourism +
                ", climateTypes=" + climateTypes +
                '}';
    }
}
