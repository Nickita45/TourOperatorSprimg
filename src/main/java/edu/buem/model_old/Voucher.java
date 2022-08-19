package edu.buem.model_old;

import java.time.LocalDateTime;

public class Voucher {
    private String id;
    private String name;
    private String idVoucher;

    private LocalDateTime departureDate;
    private int numberOfPeople;
    private int percentageDiscount;

    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public Voucher() {
    }


}
