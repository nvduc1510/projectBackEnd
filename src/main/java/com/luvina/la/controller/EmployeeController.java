/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * EmployeeController.java, July 5, 2023 nvduc
 */
package com.luvina.la.controller;

import com.luvina.la.dto.ListEmployeeDTO;
import com.luvina.la.payload.ListEmployeeResponse;
import com.luvina.la.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Xu ly cac logic lien quan den Employees
 *
 * @author nvduc
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * Phương thức controller để lấy danh sách nhân viên dưới dạng phản hồi (response).
     *
     * @param employeeName Tên nhân viên để tìm kiếm
     * @param departmentId ID của phòng ban để lọc
     * @param ordEmployeeName Thứ tự sắp xếp cho tên nhân viên
     * @param ordCertificationName Thứ tự sắp xếp cho tên chứng chỉ)
     * @param ordEndDate Thứ tự sắp xếp cho ngày kết thúc
     * @param offset Vị trí bắt đầu của danh sách nhân viên trong kết quả phân trang
     * @param limit Số lượng nhân viên trên mỗi trang
     * @return Phản hồi (response) chứa danh sách nhân viên trong trang và thông tin phân trang.
    */
    @GetMapping("/")
    public ResponseEntity<?> getListEmployees(
            @RequestParam(required = false, defaultValue = "") String employeeName,
            @RequestParam(required = false) Long departmentId,
            @RequestParam(required = false, defaultValue = "") String ordEmployeeName,
            @RequestParam(required = false, defaultValue = "") String ordCertificationName,
            @RequestParam(required = false, defaultValue = "") String ordEndDate,
            @RequestParam(required = false, defaultValue = "1") int offset,
            @RequestParam(required = false, defaultValue = "5") int limit) {

        try {
            Page<ListEmployeeDTO> employees = employeeService.getAllListEmployeesDTO(
                    employeeName, departmentId, ordEmployeeName, ordCertificationName, ordEndDate, offset, limit);
            return ResponseEntity.ok(new ListEmployeeResponse("200", employees.getTotalElements(), employees.getContent()));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to get list of employees");
        }
    }
}
