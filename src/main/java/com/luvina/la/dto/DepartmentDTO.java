/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * EmployeeController.java, July 5, 2023 nvduc
 */
package com.luvina.la.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
/**
* Lớp `DepartmentDT` đại diện cho đối tượng dùng để chứa thông tin cơ bản về một phòng ban.
* @author nvduc
*/

@Data
@AllArgsConstructor
public class DepartmentDTO {
    private Long departmentId;
    private String departmentName;
}
