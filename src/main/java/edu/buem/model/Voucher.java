package edu.buem.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Voucher {
    private String id;
    private String name;
    private String idVoucher;

    private LocalDateTime departureDate;
    private int numberOfPeople;

    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public Voucher() {
    }


}
