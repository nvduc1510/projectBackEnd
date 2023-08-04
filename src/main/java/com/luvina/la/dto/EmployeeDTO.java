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
/**
 * Lớp `EmployeeDTO` đại diện cho đối tượng dùng để chứa thông tin cơ bản về một nhân viên.
 * @author nvduc
 */
@Data
@AllArgsConstructor
public class EmployeeDTO {
    private String employeeId;
    private String  departmentId;
    private String employeeName;
    private String employeeBirthDate;
    private String employeeEmail;
    private String employeeTelephone;
    private String employeeNameKana;
    private String employeeLoginId;
    private String employeeLoginPassword;
    private List<EmployeeCertificationDTO> certifications;
}