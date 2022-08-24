package edu.buem.form;

import edu.buem.model.Hotel;
import edu.buem.model.Hotels;

import java.time.LocalDateTime;

public class RouteClientCountry {

    private String name;
    private String description;

    private Integer cost;
    private Integer duration;
    private String countries;
    private String clients;
    private Hotels hotel;

    public RouteClientCountry(String name, String description, Integer cost, Integer duration, String countries, String clients, Hotels hotel) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.duration = duration;
        this.countries = countries;
        this.clients = clients;
        this.hotel = hotel;
    }

    public RouteClientCountry() {
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

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public Hotels getHotel() {
        return hotel;
    }

    public void setHotel(Hotels hotel) {
        this.hotel = hotel;
    }

    public String getClients() {
        return clients;
    }

    public void setClients(String clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "RouteClientCountry{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", duration=" + duration +
                ", countries='" + countries + '\'' +
                ", clients='" + clients + '\'' +
                ", hotel=" + hotel +
                '}';
    }
}
