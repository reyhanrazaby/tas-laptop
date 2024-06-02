package com.tas_laptop.tas_lapop.controller.response;

import lombok.Data;

@Data
public class ReportItem {
    private int no;
    private long productId;
    private String productName;
    private String productTypeName;
    private double price;
    private double profitAmount;
}
