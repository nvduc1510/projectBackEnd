/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * EmployeeController.java, July 30, 2023 nvduc
 */
package com.luvina.la.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
*  Lớp `GetEmployeeDTO` đại diện cho đối tượng dùng để chứa thông tin chi tiết về một nhân viên cụ thể.
* @author nvduc
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeeDTO implements Serializable {
    private long code; // Mã nhân viên cụ thể.

    private long employeeId; // ID của nhân viên.

    private String employeeName; // Tên của nhân viên.

    private LocalDate employeeBirthDate; // Ngày sinh của nhân viên.

    private String departmentId; // Mã bộ phận của nhân viên

    private String departmentName; // Tên bộ của phận  nhân .

    private String employeeEmail; // Email của nhân viên.

    private String employeeTelephone; // Số điện thoại của nhân viên.

    private String employeeNameKana; // Tên Katakana của nhân viên.

    private String employeeLoginId; // Tên đăng nhập của nhân viên.

    private List<GetEmployeeCertificationDTO> certifications; // Danh sách các chứng chỉ của nhân viên .

}
