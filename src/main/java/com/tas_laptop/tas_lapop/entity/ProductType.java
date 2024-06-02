package com.tas_laptop.tas_lapop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_type")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductType {

    @Id
    private long id;

    private String name;

}
