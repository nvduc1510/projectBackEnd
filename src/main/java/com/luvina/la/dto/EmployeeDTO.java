/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * EmployeeDTO.java, July 14, 2023 nvduc
 */
package com.luvina.la.dto;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDTO {
    private String employeeId;
//    @JsonProperty("departmentId")
    private String  departmentId;
    private String employeeName;
//    @JsonFormat(pattern = "yyyy/MM/dd")
    private String employeeBirthDate;
    private String employeeEmail;
    private String employeeTelephone;
    private String employeeNameKana;
    private String employeeLoginId;
    private String employeeLoginPassword;
//    @JsonProperty("certifications")
    private List<EmployeeCertificationDTO> certifications;
}