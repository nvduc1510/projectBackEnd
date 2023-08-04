/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * EmployeeController.java, July 30, 2023 nvduc
 */
package com.luvina.la.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Thực hiện lữu trữ thông tin chứng chỉ
 * @author nvduc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeeCertificationDTO {
    private long certificationId;
    private String certificationName;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal score;
}
