package edu.buem.model_old;

import java.time.LocalDateTime;
import java.util.List;

public class VoucherManager {

    private String id;
    private String name;

    private Client client;
    private Voucher voucher;
    private List<Route> routes;
    private List<Country> countries;
    private List<Hotel> hotels;
    private Discount discount;


    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
