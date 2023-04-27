package com.neosoft.springbootCurdOperation.dto;

import com.neosoft.springbootCurdOperation.entity.Address;
import com.neosoft.springbootCurdOperation.entity.Gender;
import com.neosoft.springbootCurdOperation.entity.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployeeResponse {
    private Integer empId;
    private String empName;
    private String empDepartment;

    private Address address;

    private List<PhoneNumber> phoneNumber;
    private Double empSalary;
    private Gender gender;
    private Date dateOfJoining;
    private String email;


}
