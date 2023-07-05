/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * EmployeeRepository.java, July 5, 2023 nvduc
 */
package com.luvina.la.repository;

import com.luvina.la.dto.ListEmployeeDTO;
import com.luvina.la.entity.Employee;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
* Giao diện kho lưu trữ để truy cập và quản lý dữ liệu Nhân viên trong cơ sở dữ liệu.
* @author ntmhuong
*/
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Optional<Employee> findByEmployeeLoginId(String employeeLoginId);
    Optional<Employee> findByEmployeeId(Long employeeId);
    @Query("SELECT new com.luvina.la.dto.ListEmployeeDTO(e.employeeId, e.employeeName," +
            " e.employeeEmail, e.employeeTelephone, d.departmentName," +
            " ec.startDate, ec.endDate, ec.score, c.certificationName) " +
            "FROM Employee e " +
            "JOIN e.department d " +
            "LEFT JOIN e.employeeCertifications ec " +
            "LEFT JOIN ec.certification c " +
            "WHERE (:employeeName IS NULL OR e.employeeName LIKE CONCAT('%', :employeeName, '%')) " +
            "AND (:departmentId IS NULL OR e.department.departmentId = :departmentId) " +
            "ORDER BY " +
            "CASE WHEN :ordEmployeeName = 'ASC' THEN e.employeeName END ASC, " +
            "CASE WHEN :ordEmployeeName = 'DESC' THEN e.employeeName END DESC, " +
            "CASE WHEN :ordCertificationName = 'ASC' THEN c.certificationName END ASC, " +
            "CASE WHEN :ordCertificationName = 'DESC' THEN c.certificationName END DESC, " +
            "CASE WHEN :ordEndDate = 'ASC' THEN ec.endDate END ASC, " +
            "CASE WHEN :ordEndDate = 'DESC' THEN ec.endDate END DESC" )

    /**
     * Phương thức để lấy danh sách các đối tượng ListEmployeeDTO dựa trên các tham số và phân trang.
     * @param employeeName Tên nhân viên
     * @param departmentId ID của phòng ban
     * @param ordEmployeeName Thứ tự sắp xếp cho tên nhân viên (ASC: tăng dần, DESC: giảm dần)
     * @param ordCertificationName Thứ tự sắp xếp cho tên chứng chỉ (ASC: tăng dần, DESC: giảm dần)
     * @param ordEndDate Thứ tự sắp xếp cho ngày kết thúc (ASC: tăng dần, DESC: giảm dần)
     * @param pageable Đối tượng phân trang
     * @return Trang (Page) chứa danh sách các đối tượng ListEmployeeDTO
    */
    Page<ListEmployeeDTO> getListEmployeeDTO(@Param("employeeName") String employeeName ,
                                             @Param("departmentId") Long departmentId,
                                             @Param("ordEmployeeName") String ordEmployeeName,
                                             @Param("ordCertificationName") String ordCertificationName,
                                             @Param("ordEndDate") String ordEndDate,
                                             Pageable pageable);
}

