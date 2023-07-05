/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * EmployeeCertificationRepository.java, July 5, 2023 nvduc
 */
package com.luvina.la.repository;

import com.luvina.la.entity.EmployeesCertifications;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Giao diện kho lưu trữ để truy cập và quản lý dữ liệu EmployeeCertifications trong cơ sở dữ liệu.
 * @author nvduc
 */
@Repository
public interface EmployeeCertificationRepository extends CrudRepository<EmployeesCertifications, Long> {
}
