package com.tas_laptop.tas_lapop.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transaction")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transaction {

    @Id
    private long id;

    @Column(name = "customer_email")
    private String customerEmail;

    @Column(name = "tax_rate")
    private double taxRate;

    @Column(name = "tax_amount")
    private double taxAmount;

    private LocalDateTime time;

}
