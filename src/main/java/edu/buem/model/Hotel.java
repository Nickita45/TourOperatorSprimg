package edu.buem.model;

import java.time.LocalDateTime;

public class Hotel {
    private String id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private int countStars;
    private boolean isParking;
    private boolean isAllInclude;
    private int countRooms;
    private boolean isLuxury;

}
