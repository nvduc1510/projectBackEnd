/*
 * Copyright(C) 2023 Luvina Software Company
 *
 * CertificationServiceImpl.java, July 5, 2023 nvduc
 */
package com.luvina.la.service.impl;

import com.luvina.la.entity.Certifications;
import com.luvina.la.repository.CertificationsRepository;
import com.luvina.la.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
*Xu ly ve cac thông tin liên quan đến Certification
* @author nvduc
*/
@Service
public class CertificationServiceImpl implements CertificationService {
    @Autowired
    private CertificationsRepository certificationsRepository;
    @Override
    public List<Certifications> getAllCertification() {
        return (List<Certifications>) certificationsRepository.findAll();
    }
}
