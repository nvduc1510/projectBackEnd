package com.luvina.la.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
* Lớp `CertificationDTO` đại diện cho đối tượng dùng để chứa thông tin cơ bản về chứng chỉ.
* @author nvduc
*/

@Data
@NoArgsConstructor
public class CertificationDTO {

    private long certificationId;

    private String certificationName;

    private Integer certificationLevel;

//    private List<EmployeeCertificationDTO> employeeCertifications;
}
