package edu.buem.model;

import java.time.LocalDateTime;

public class RouteLog {
    private String id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Hotel hotel;
    private Country country;
    private Route route;
    private Client client;
}
