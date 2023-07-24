package com.luvina.la.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
public class ListEmployeeDTO implements Serializable {
    private long employeeId;

    private String employeeName;

    private LocalDate employeeBirthDate;

    private String employeeEmail;

    private String employeeTelephone;

    private String departmentName;

    private LocalDate endDate;

    private BigDecimal score;

    private String certificationName;


}
