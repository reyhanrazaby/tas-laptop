package com.tas_laptop.tas_lapop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "transaction_item")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TransactionItem {

    @EmbeddedId
    private TransactionItemId id;

    private double price;

    @Column(name = "profit_margin")
    private double profitMargin;

    @Column(name = "profit_Amount")
    private double profitAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @ToString.Exclude
    private Product product;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_type_id")
    private long productTypeId;

    @Column(name = "product_type_name")
    private String productTypeName;

}
