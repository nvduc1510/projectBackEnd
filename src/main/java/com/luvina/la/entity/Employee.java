
package com.luvina.la.entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
@Entity
@Table(name = "employees")
@Data
public class Employee implements Serializable {
    private static final long serialVersionUID = 5771173953267484096L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", unique = true)
    private Long employeeId;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments department;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "employee_name_kana")
    private String employeeNameKana;

    @Column(name = "employee_birth_date")
    private LocalDate employeeBirthDate;

    @Column(name = "employee_email")
    private String employeeEmail;

    @Column(name = "employee_telephone")
    private String employeeTelephone;

    @Column(name = "employee_login_id")
    private String employeeLoginId;

    @Column(name = "employee_login_password")
    private String employeeLoginPassword;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL,  orphanRemoval = true)
    private EmployeesCertifications employeeCertifications;

}
