package edu.buem.model;

import java.time.LocalDateTime;
import java.util.List;

public class VoucherManager {

    private String id;
    private String name;

    private Client client;
    private Voucher voucher;
    private ClimateTypes climateTypes;
    private List<Route> routes;
    private List<Country> countries;
    private List<Hotel> hotels;
    private Discount discount;


    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
