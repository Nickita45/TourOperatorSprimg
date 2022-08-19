package edu.buem.model;

import java.time.LocalDateTime;

public class VoucherLog {
    private String id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Voucher voucher;
    private Country country;
    private Client client;
}
