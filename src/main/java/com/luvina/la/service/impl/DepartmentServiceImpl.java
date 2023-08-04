/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * DepartmentServiceImpl.java, July 5, 2023 nvduc
 */
package com.luvina.la.service.impl;

import com.luvina.la.entity.Departments;
import com.luvina.la.repository.DepartmentRepository;
import com.luvina.la.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
* Xử lý thông tin liên quan đến Department
* @author nvduc
*/
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Departments> getAllDepartment() {

        return (List<Departments>) departmentRepository.findAll();
    }
}
