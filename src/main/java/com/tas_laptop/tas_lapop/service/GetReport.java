package com.tas_laptop.tas_lapop.service;

import com.tas_laptop.tas_lapop.controller.response.Report;
import com.tas_laptop.tas_lapop.controller.response.ReportItem;
import com.tas_laptop.tas_lapop.entity.TransactionItem;
import com.tas_laptop.tas_lapop.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;


@Service
@RequiredArgsConstructor
public class GetReport {

    private final TransactionRepository transactionRepository;

    public Report get(YearMonth start, YearMonth end) {
        LocalDateTime startTime = start.atDay(1).atStartOfDay();
        LocalDateTime endTime = end.atEndOfMonth().atTime(23, 59, 59);
        List<TransactionItem> transactionItems = transactionRepository.getTransactionItems(startTime, endTime);
        int size = transactionItems.size();
        Report report = new Report();

        for (int i = 0; i < size; i++) {
            ReportItem reportItem = new ReportItem();
            TransactionItem transactionItem = transactionItems.get(i);

            BeanUtils.copyProperties(transactionItem, reportItem);
            reportItem.setNo(i+1);
            reportItem.setProductId(transactionItem.getProduct().getId());
            report.getList().add(reportItem);
        }
        return report;
    }

}
