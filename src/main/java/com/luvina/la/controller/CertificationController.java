package com.luvina.la.controller;

import com.luvina.la.entity.Certifications;
import com.luvina.la.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/certification")
public class CertificationController {
    @Autowired
    private CertificationService certificationService;

    @GetMapping("/")
    public List<Certifications> getALLCertification(){
        List<Certifications> certifications = certificationService.getAllCertification();
        return  certifications;
    }
}
