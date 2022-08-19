package edu.buem.model_old;

import edu.buem.model.ClimateTypes;

import java.time.LocalDateTime;

public class Country {
    private String id;
    private String name;
    private boolean isVisa;
    private int levelTourism;
    private ClimateTypes climateTypes;

    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
