/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * EmployeeController.java, July 5, 2023 nvduc
 */
package com.luvina.la.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
/**
* Lớp `EmployeeDTO` đại diện cho đối tượng dùng để chứa thông tin cơ bản về một nhân viên.
* @author nvduc
*/

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
