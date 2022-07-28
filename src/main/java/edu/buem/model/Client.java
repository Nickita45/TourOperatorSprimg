package edu.buem.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Client {
    private String idClient;
    private String firstName;
    private String secondName;
    private String patronymic;
    private String address;
    private String telephoneNumber;
    private LocalDateTime registrationDate;

    public Client() {
    }

    public Client(String firstName, String secondName, String patronymic) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
    }

    public Client(String idClient, String firstName, String secondName, String patronymic, String address, String telephoneNumber, LocalDateTime registrationDate) {
        this.idClient = idClient;
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.registrationDate = registrationDate;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return idClient.equals(client.idClient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient);
    }

    @Override
    public String toString() {
        return "Clients{" +
                "idClient='" + idClient + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address='" + address + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
