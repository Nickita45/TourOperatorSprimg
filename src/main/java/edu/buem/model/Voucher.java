package edu.buem.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Voucher {
    private String id;
    private Voucher idVoucher;
    private Client idClient;
    private LocalDateTime departureDate;
    private int numberOfPeople;
    private int discount;

    public Voucher() {
    }

    public Voucher(String id) {
        this.id = id;
    }

    public Voucher(String id, Voucher idVoucher, Client idClient, LocalDateTime departureDate, int numberOfPeople, int discount) {
        this.id = id;
        this.idVoucher = idVoucher;
        this.idClient = idClient;
        this.departureDate = departureDate;
        this.numberOfPeople = numberOfPeople;
        this.discount = discount;
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

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voucher voucher = (Voucher) o;
        return id.equals(voucher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "id='" + id + '\'' +
                ", idVoucher=" + idVoucher +
                ", idClient=" + idClient +
                ", departureDate=" + departureDate +
                ", numberOfPeople=" + numberOfPeople +
                ", discount=" + discount +
                '}';
    }
}
