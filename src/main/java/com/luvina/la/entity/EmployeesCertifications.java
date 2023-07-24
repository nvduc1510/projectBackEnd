package com.luvina.la.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees_certifications")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeesCertifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_certification_id")
    private Long employeeCertificationId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonBackReference
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "certification_id")
    @JsonBackReference
    private Certifications certification;


    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "score")
    private BigDecimal score;


}
