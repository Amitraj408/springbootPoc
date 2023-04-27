package com.neosoft.springbootCurdOperation.service;

import com.neosoft.springbootCurdOperation.dto.EmployeeRequest;
import com.neosoft.springbootCurdOperation.dto.EmployeeResponse;
import com.neosoft.springbootCurdOperation.dto.QueryResponse;
import com.neosoft.springbootCurdOperation.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse saveemployee(EmployeeRequest employeeRequest);

    List<EmployeeResponse> getAllEmployee();

    EmployeeResponse getEmployeeById(Integer empId);

    void deleteEmployeeById(Integer empId);

    EmployeeResponse updateEmployee(Integer empId,EmployeeRequest employeeRequest);
    public List<EmployeeResponse> getAllEmployeeBySorting(String field);

    Page<Employee> getAllEmployeeByPagination(int offset, int pageSize);
    public Page<Employee> getAllEmployeeByPaginationWithSorting(int offset, int pageSize,String field);
    public List<QueryResponse> getEmployeeWithPhoneNumber();
}
