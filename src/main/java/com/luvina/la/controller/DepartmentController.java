/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * DepartmentController.java, July 5, 2023 nvduc
 */
package com.luvina.la.controller;

import com.luvina.la.entity.Departments;
import com.luvina.la.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
*Xu ly cac logic lien quan den Departments
* @author nvduc
*/
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Departments> getAllDepartment(){
        List<Departments> departmentsList = departmentService.getAllDepartment();
        return  departmentsList;
    }
}
