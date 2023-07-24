package com.luvina.la.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EmployeeCertificationDTO {
    private String certificationId;
//    @JsonFormat(pattern = "yyyy/MM/dd")
    private String certificationStartDate;
//    @JsonFormat(pattern = "yyyy/MM/dd")
    private String certificationEndDate;
    private String employeeCertificationScore;
}
