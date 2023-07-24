package com.luvina.la.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class CertificationDTO {

    private long certificationId;

    private String certificationName;

    private Integer certificationLevel;

//    private List<EmployeeCertificationDTO> employeeCertifications;
}
