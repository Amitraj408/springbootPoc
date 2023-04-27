package com.neosoft.springbootCurdOperation.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neosoft.springbootCurdOperation.dto.EmployeeRequest;
import com.neosoft.springbootCurdOperation.dto.EmployeeResponse;
import com.neosoft.springbootCurdOperation.dto.QueryResponse;
import com.neosoft.springbootCurdOperation.entity.Employee;
import com.neosoft.springbootCurdOperation.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public EmployeeResponse saveemployee(EmployeeRequest employeeRequest) {

        Employee employee = objectMapper.convertValue(employeeRequest, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeResponse employeeResponse = objectMapper.convertValue(savedEmployee, EmployeeResponse.class);
        employeeResponse.setEmpId(savedEmployee.getEmpId());
        return employeeResponse;
    }

    @Override
    public List<EmployeeResponse> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();

        return employees
                .stream()
                .map(employee -> EmployeeResponse.builder()
                               .empId(employee.getEmpId())
                        .empName(employee.getEmpName())
                        .empDepartment(employee.getEmpDepartment())
                        .address(employee.getAddress())
                        .phoneNumber(employee.getPhoneNumber())
                        .empSalary(employee.getEmpSalary())
                        .gender(employee.getGender())
                        .dateOfJoining(employee.getDateOfJoining())
                        .email(employee.getEmail()).build()).collect(Collectors.toList());

 //      EmployeeResponse employeeResponse = objectMapper.convertValue(employees, EmployeeResponse.class);
    }

    @Override
    public EmployeeResponse getEmployeeById(Integer empId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(empId);
        if(optionalEmployee.isEmpty()){
            throw new RuntimeException("employee is not present");
        }
        Employee employee = optionalEmployee.get();
        return objectMapper.convertValue(employee,EmployeeResponse.class);

    }

    @Override
    public void deleteEmployeeById(Integer empId) {
        Optional<Employee> optionalId = employeeRepository.findById(empId);
        Optional<Employee> optionalEmployee = employeeRepository.findById(empId);
        if(optionalEmployee.isEmpty()){
            throw new RuntimeException("Employee with id " + empId + " is not present in database");

        }
        Employee employee = optionalEmployee.get();
        employeeRepository.delete(employee);
    }

    @Override
    public EmployeeResponse updateEmployee(Integer empId,EmployeeRequest employeeRequest) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(empId);
        if(optionalEmployee.isEmpty()){
            throw new RuntimeException("Employee with id " + empId + " is not present in database");

        }
        Employee toSaveEmployee = objectMapper.convertValue(employeeRequest, Employee.class);
        toSaveEmployee.setEmpId(empId);
        Employee savedEmployee = employeeRepository.save(toSaveEmployee);
        return objectMapper.convertValue(savedEmployee,EmployeeResponse.class);

    }
    public List<EmployeeResponse> getAllEmployeeBySorting(String field){
        List<Employee> employees = employeeRepository.findAll(Sort.by(Sort.Direction.ASC, field));
        return employees
                .stream()
                .map(employee -> EmployeeResponse.builder()
                        .empId(employee.getEmpId())
                        .empName(employee.getEmpName())
                        .empDepartment(employee.getEmpDepartment())
                        .address(employee.getAddress())
                        .phoneNumber(employee.getPhoneNumber())
                        .empSalary(employee.getEmpSalary())
                        .gender(employee.getGender())
                        .dateOfJoining(employee.getDateOfJoining())
                        .email(employee.getEmail()).build()).collect(Collectors.toList());

    }
    public Page<Employee> getAllEmployeeByPagination(int offset, int pageSize){
        return employeeRepository.findAll(PageRequest.of(offset,pageSize));

    }

    public Page<Employee> getAllEmployeeByPaginationWithSorting(int offset, int pageSize,String field){
        return employeeRepository.findAll(PageRequest.of(offset,pageSize).withSort(Sort.by(field)));

    }
    public List<QueryResponse> getEmployeeWithPhoneNumber(){
        return employeeRepository.getEmployeeWithPhoneNumber();
    }
}
