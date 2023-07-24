/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * DepartmentRepository.java, July 5, 2023 nvduc
 */
package com.luvina.la.repository;

import com.luvina.la.entity.Departments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Giao diện kho lưu trữ để truy cập và quản lý dữ liệu department trong cơ sở dữ liệu.
 * @author nvduc
 */
@Repository
public interface DepartmentRepository extends CrudRepository<Departments, Long> {
    boolean existsByDepartmentId(long departmentId);
}
