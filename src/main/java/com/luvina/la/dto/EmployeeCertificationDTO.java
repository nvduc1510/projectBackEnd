package com.luvina.la.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EmployeeCertificationDTO {
    private Long employeeCertificationId;
//    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate startDate;
//    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate endDate;
    private BigDecimal score;
}
