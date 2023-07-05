package com.luvina.la.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class EmployeeDTO implements Serializable {

    private static final long serialVersionUID = 6868189362900231672L;

    private Long employeeId;
    private String employeeName;
    private Date employeeBirthDate;
    private String departmentName;
    private String employeeEmail;
    private String employeeTelephone;
    private String certificationName;
    private Date endDate;
    private BigDecimal score;
}