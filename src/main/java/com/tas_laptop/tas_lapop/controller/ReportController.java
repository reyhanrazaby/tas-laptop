package com.tas_laptop.tas_lapop.controller;

import com.tas_laptop.tas_lapop.controller.response.Report;
import com.tas_laptop.tas_lapop.service.GetReport;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.YearMonth;

@Setter
@RestController
public class ReportController {

    final static String REG_EXP = "\\d{4}-\\d{2}";
    final static String ERR_MSG = "must be in format YYYY-MM";

    @Autowired
    private GetReport service;

    @GetMapping(path = "/api/report")
    public Report getReport(
            @Valid @NotBlank @Pattern(regexp = REG_EXP, message = ERR_MSG) String from,
            @Valid @NotBlank @Pattern(regexp = REG_EXP, message = ERR_MSG) String to
    ) {
        YearMonth startYm = YearMonth.parse(from);
        YearMonth endYm = YearMonth.parse(to);
        return service.get(startYm, endYm);
    }
}
