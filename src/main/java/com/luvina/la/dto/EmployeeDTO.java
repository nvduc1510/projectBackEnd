package com.luvina.la.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDTO {
    private Long employeeId;
    private String employeeName;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date employeeBirthDate;
    private String employeeEmail;
    private String employeeTelephone;
    private  String employeeNameKana;
    private String employeeLoginId;
    private String employeeLoginPassword;
    @JsonProperty("departmentId")
    private long  departmentId;
    @JsonProperty("certifications")
    private List<EmployeeCertificationDTO> employeesCertifications;
}