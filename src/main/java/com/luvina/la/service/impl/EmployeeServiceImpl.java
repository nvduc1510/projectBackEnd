/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * EmployeeServiceImpl.java, July 5, 2023 nvduc
 */
package com.luvina.la.service.impl;

import com.luvina.la.dto.ListEmployeeDTO;
import com.luvina.la.exception.NotFoundException;
import com.luvina.la.exception.YourCustomException;
import com.luvina.la.repository.EmployeeRepository;
import com.luvina.la.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
*Xu ly các thông tin liên quan đến Employees
* @author nvduc
*/
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    /**
     * Phương thức này trả về một trang (Page) các đối tượng ListEmployeeDTO.
     * @param employeeName tên nhân viên
     * @param departmentId ID của phòng ban
     * @param ordEmployeeName thứ tự sắp xếp cho tên nhân viên
     * @param ordCertificationName thứ tự sắp xếp cho tên chứng chỉ
     * @param ordEndDate thứ tự sắp xếp cho ngày kết thúc
     * @param offset vị trí bắt đầu của các phần tử
     * @param limit số lượng tối đa các phần tử
     * @return đối tượng Page chứa các đối tượng ListEmployeeDTO
     * @throws NotFoundException nếu không tìm thấy nhân viên nào
     * @throws YourCustomException nếu có lỗi xảy ra khi lấy danh sách nhân viên
    */
    @Override
    public Page<ListEmployeeDTO> getAllListEmployeesDTO(String employeeName, Long departmentId, String ordEmployeeName, String ordCertificationName, String ordEndDate, int offset, int limit) {
        try {
            String escapedEmployeeName = employeeName != null ? employeeName.replace("\\", "\\\\")
                    .replace("%", "\\%")
                    .replace("_", "\\_")
                    .replace(";", "\\;") : null;
            Pageable pageable = PageRequest.of(offset - 1, limit);
            Page<ListEmployeeDTO> employees = employeeRepository.getListEmployeeDTO(
                    escapedEmployeeName, departmentId, ordEmployeeName, ordCertificationName, ordEndDate, pageable
            );
            if (employees.isEmpty()) {
                throw new NotFoundException("No employees found");
            }
            return employees;
        } catch (Exception e) {
            throw new YourCustomException("Failed to get list of employees", e);
        }
    }
}