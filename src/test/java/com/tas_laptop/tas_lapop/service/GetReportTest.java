package com.tas_laptop.tas_lapop.service;

import com.tas_laptop.tas_lapop.controller.response.Report;
import com.tas_laptop.tas_lapop.entity.Product;
import com.tas_laptop.tas_lapop.entity.TransactionItem;
import com.tas_laptop.tas_lapop.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetReportTest {

    @InjectMocks
    private GetReport service;

    @Mock
    private TransactionRepository repository;

    @Test
    void testStartAndEndTime() {
        when(repository.getTransactionItems(any(), any())).thenReturn(List.of());

        service.get(YearMonth.of(2023, Month.NOVEMBER), YearMonth.of(2024, Month.FEBRUARY));

        LocalDateTime expectedStartTime = LocalDateTime.of(2023, Month.NOVEMBER, 1, 0, 0, 0);
        LocalDateTime expectedEndTime = LocalDateTime.of(2024, Month.FEBRUARY, 29, 23, 59, 59);
        verify(repository).getTransactionItems(eq(expectedStartTime), eq(expectedEndTime));
    }

    @Test
    void testReportItemNumbers() {
        when(repository.getTransactionItems(any(), any()))
                .thenReturn(List.of(dummyTransactionItem(), dummyTransactionItem(), dummyTransactionItem()));

        Report report = service.get(YearMonth.of(2023, Month.NOVEMBER), YearMonth.of(2024, Month.FEBRUARY));

        assertNotNull(report);
        assertEquals(3, report.getList().size());
        assertEquals(1, report.getList().get(0).getNo());
        assertEquals(2, report.getList().get(1).getNo());
        assertEquals(3, report.getList().get(2).getNo());
    }

    private TransactionItem dummyTransactionItem() {
        return TransactionItem.builder().product(new Product()).build();
    }

}