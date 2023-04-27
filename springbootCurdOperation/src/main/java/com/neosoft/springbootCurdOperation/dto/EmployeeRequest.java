package com.neosoft.springbootCurdOperation.dto;

import com.neosoft.springbootCurdOperation.entity.Address;
import com.neosoft.springbootCurdOperation.entity.Gender;
import com.neosoft.springbootCurdOperation.entity.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeRequest {


    @NotBlank(message = "Employee name cannot be null")
    private String empName;
    @NotBlank(message = "department must not be null")
    private String empDepartment;

    private Address address;

   // @Pattern(regexp = "^\\d{10}$",message = "invalid mobile number entered")
    private List<PhoneNumber> phoneNumber;
    private Double empSalary;
    private Gender gender;
    private Date dateOfJoining;
    @Email
    private String email;

}
