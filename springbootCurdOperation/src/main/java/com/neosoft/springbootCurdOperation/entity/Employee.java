package com.neosoft.springbootCurdOperation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;
    @Column(name = "employee_name")
    @NotNull(message = "Employee name cannot be null")
    private String empName;
    @Column(name = "employee_department")
    private String empDepartment;
    @Embedded
    private Address address;


    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "emp_phone_Table",joinColumns = @JoinColumn(name = "employee_fk")
//    ,inverseJoinColumns = @JoinColumn(name = "phone_fk"))
//    @Column(name = "phone_number",nullable = false,length = 10)
    @JoinColumn(name = "emp_id_fk",referencedColumnName = "empId")
    private List<PhoneNumber> phoneNumber;
    @Column(name = "employee_salary")
    private Double empSalary;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Temporal(TemporalType.DATE)
    private Date dateOfJoining;

    private String email;

}
