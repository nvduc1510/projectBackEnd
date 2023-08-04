/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * EmployeeController.java, July 10, 2023 nvduc
 */
package com.luvina.la.service;

import com.luvina.la.entity.Certifications;
import java.util.List;
/**
 * Cung cấp các phương thức truy xuất của certification
 * @author nvduc
 */
public interface CertificationService {
    List<Certifications> getAllCertification();
}
