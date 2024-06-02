package com.tas_laptop.tas_lapop.controller.response;

import java.util.LinkedList;
import java.util.List;

import lombok.Data;

@Data
public class Report {
    private List<ReportItem> list = new LinkedList<>();
}
