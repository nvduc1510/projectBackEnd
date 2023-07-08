/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * EmployeeServiceImpl.java, July 5, 2023 nvduc
 */
package com.luvina.la.service.impl;

import com.luvina.la.dto.EmployeeCertificationDTO;
import com.luvina.la.dto.EmployeeDTO;
import com.luvina.la.dto.ListEmployeeDTO;
import com.luvina.la.entity.Certifications;
import com.luvina.la.entity.Departments;
import com.luvina.la.entity.Employee;
import com.luvina.la.entity.EmployeesCertifications;
import com.luvina.la.exception.NotFoundException;
import com.luvina.la.exception.YourCustomException;
import com.luvina.la.repository.CertificationsRepository;
import com.luvina.la.repository.DepartmentRepository;
import com.luvina.la.repository.EmployeeCertificationRepository;
import com.luvina.la.repository.EmployeeRepository;
import com.luvina.la.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
*Xu ly các thông tin liên quan đến Employees
* @author nvduc
*/
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    CertificationsRepository certificationsRepository;
    @Autowired
    EmployeeCertificationRepository employeeCertificationRepository;
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
    public Page<ListEmployeeDTO> getAllListEmployeesDTO(String employeeName,
                                                        Long departmentId,
                                                        String ordEmployeeName,
                                                        String ordCertificationName,
                                                        String ordEndDate,
                                                        int offset, int limit) {
        try {
            String escapedEmployeeName = employeeName != null ? employeeName.replace("\\", "\\\\")
                    .replace("%", "\\%")
                    .replace("_", "\\_")
                    .replace(";", "\\;") : null;
            Pageable pageable = PageRequest.of(offset - 1, limit);
            Page<ListEmployeeDTO> employees = employeeRepository.getListEmployeeDTO(
                    escapedEmployeeName,
                    departmentId,
                    ordEmployeeName,
                    ordCertificationName,
                    ordEndDate,
                    pageable);
            if (employees.isEmpty()) {
                throw new NotFoundException("No employees found");
            }
            return employees;
        } catch (Exception e) {
            throw new YourCustomException("Failed to get list of employees", e);
        }
    }

    /**
     * Thực hiện thêm mới một nhân viên và các chứng chỉ của nhân viên đó vào cơ sở dữ liệu.
     *
     * @param employeeDTO Thông tin nhân viên được truyền dưới dạng đối tượng EmployeeDTO
     * @return Đối tượng Employee đã được thêm mới
     */
    @Override
    @Transactional
    public Employee addEmployees(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setEmployeeName(employeeDTO.getEmployeeName());
        employee.setEmployeeBirthDate(employeeDTO.getEmployeeBirthDate());
        employee.setEmployeeEmail(employeeDTO.getEmployeeEmail());
        employeeDTO.setEmployeeTelephone(employeeDTO.getEmployeeTelephone());
        employeeDTO.setEmployeeName(employeeDTO.getEmployeeName());
        employee.setEmployeeLoginId(employeeDTO.getEmployeeLoginId());

        String password = employeeDTO.getEmployeeLoginPassword();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        employee.setEmployeeLoginPassword(passwordEncoder.encode(password));

        Departments department = departmentRepository
                .findById(employeeDTO.getDepartmentId())
                .orElseThrow();
        employee.setDepartment(department);
        employeeRepository.save(employee);

        if(employeeDTO.getEmployeesCertifications() != null){
            for (EmployeeCertificationDTO employeeCertificationDTO : employeeDTO.getEmployeesCertifications()) {
                Certifications certification = certificationsRepository
                        .findById(employeeCertificationDTO.getEmployeeCertificationId())
                        .orElseThrow();
                EmployeesCertifications employeeCertification = new EmployeesCertifications();
                employeeCertification.setEmployee(employee);
                employeeCertification.setCertification(certification);
                employeeCertification.setStartDate(employeeCertificationDTO.getStartDate());
                employeeCertification.setEndDate(employeeCertificationDTO.getEndDate());
                employeeCertification.setScore(employeeCertificationDTO.getScore());
                employeeCertificationRepository.save(employeeCertification);
            }
        }
        return employee;
    }
}