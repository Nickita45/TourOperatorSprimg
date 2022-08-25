package edu.buem.form;

public class RoutesClient {
    private String id;
    private String name;
    private String description;
    private String clients;
    private String routes;
    private int number;

    public RoutesClient(String id, String name, String description, String clients, String routes, int number) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.clients = clients;
        this.routes = routes;
        this.number = number;
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

    public String getClients() {
        return clients;
    }

    public void setClients(String clients) {
        this.clients = clients;
    }

    public String getRoutes() {
        return routes;
    }

    public void setRoutes(String routes) {
        this.routes = routes;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "RoutesClient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", clients='" + clients + '\'' +
                ", routes='" + routes + '\'' +
                ", number=" + number +
                '}';
    }
}
