package edu.buem.model_old;

import java.time.LocalDateTime;

public class Route {
    private String id;
    private String name;

    private int durationInDays;

    private int cost;

    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public Route() {
    }

    public Route(String id) {
        this.id = id;
    }



}
