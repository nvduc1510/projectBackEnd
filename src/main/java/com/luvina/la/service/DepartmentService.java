/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * DepartmentService.java, July 5, 2023 nvduc
 */
package com.luvina.la.service;

import com.luvina.la.entity.Departments;
import java.util.List;
/**
* Cung cấp các phương thức truy xuất
* @author nvduc
*/
public interface DepartmentService {
    List<Departments> getAllDepartment();
}
