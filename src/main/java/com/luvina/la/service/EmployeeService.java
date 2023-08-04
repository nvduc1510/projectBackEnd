/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * EmployeeService.java, July 5, 2023 nvduc
 */
package com.luvina.la.service;

import com.luvina.la.dto.GetEmployeeDTO;
import com.luvina.la.payload.EmployeeResponse;
import com.luvina.la.payload.validator.ValidatorsException;
import com.luvina.la.dto.EmployeeDTO;
import com.luvina.la.dto.ListEmployeeDTO;
import com.luvina.la.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
* Cung cấp các phương thức để truy xuất
* @author nvduc
*/
public interface EmployeeService {
    /**
     * Phương thức này trả về một trang (Page) các đối tượng ListEmployeeDTO dựa trên các tiêu chí đã chỉ định.
     *
     * @param employeeName tên nhân viên
     * @param departmentId ID của phòng ban
     * @param ordEmployeeName thứ tự sắp xếp cho tên nhân viên
     * @param ordCertificationName thứ tự sắp xếp cho tên chứng chỉ
     * @param ordEndDate thứ tự sắp xếp cho ngày kết thúc
     * @param offset vị trí bắt đầu của các phần tử sẽ được trả về
     * @param limit số lượng tối đa các phần tử sẽ được trả về
     * @return đối tượng ResponseEntity chứa thông tin trả về: mã trạng thái, tổng số phần tử và nội dung danh sách ListEmployeeDTO
    */
    Page<ListEmployeeDTO> getAllListEmployeesDTO(String employeeName, Long departmentId,
                                                 String ordEmployeeName, String ordCertificationName,
                                                 String ordEndDate, int offset, int limit);
    /**
    *Thuc hien add
    * @param  employeeDTO key cua message
    */
//    Employee addEmployees(EmployeeDTO employeeDTO);
    @Transactional
    Employee createEmployee(EmployeeDTO employeeDTO)throws ValidatorsException;

    /**
     * Lấy thông tin nhân viên dựa trên employeeId.
     *
     * @param employeeId Id của nhân viên cần lấy thông tin.
     * @return Đối tượng GetEmployeeDTO chứa thông tin nhân viên nếu tìm thấy.
     * @throws EmployeeResponse Nếu không tìm thấy nhân viên, sẽ ném lỗi EmployeeResponse.
     */
    GetEmployeeDTO getEmployeeById(long employeeId) throws EmployeeResponse;

    Optional<Employee> deleteEmployee(long employeeId) ;
}
