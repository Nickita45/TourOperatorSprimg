package edu.buem.model;

import java.util.Objects;

public class Route {
    private String id;
    private Voucher idVoucher;
    private String Country;
    private ClimateTypes climateTypes;
    private int durationInDays;
    private String nameHotel;
    private int cost;

    public Route() {
    }

    public Route(String id) {
        this.id = id;
    }

    public Route(String id, Voucher idVoucher, String country, ClimateTypes climateTypes, int durationInDays, String nameHotel, int cost) {
        this.id = id;
        this.idVoucher = idVoucher;
        Country = country;
        this.climateTypes = climateTypes;
        this.durationInDays = durationInDays;
        this.nameHotel = nameHotel;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Voucher getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(Voucher idVoucher) {
        this.idVoucher = idVoucher;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public ClimateTypes getClimateTypes() {
        return climateTypes;
    }

    public void setClimateTypes(ClimateTypes climateTypes) {
        this.climateTypes = climateTypes;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }

    public String getNameHotel() {
        return nameHotel;
    }

    public void setNameHotel(String nameHotel) {
        this.nameHotel = nameHotel;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return id.equals(route.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Route{" +
                "id='" + id + '\'' +
                ", idVoucher=" + idVoucher +
                ", Country='" + Country + '\'' +
                ", climateTypes=" + climateTypes +
                ", durationInDays=" + durationInDays +
                ", nameHotel='" + nameHotel + '\'' +
                ", cost=" + cost +
                '}';
    }
}
