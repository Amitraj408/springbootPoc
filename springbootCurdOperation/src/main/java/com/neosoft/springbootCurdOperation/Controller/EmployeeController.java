package com.neosoft.springbootCurdOperation.Controller;

import com.neosoft.springbootCurdOperation.dto.EmployeeRequest;
import com.neosoft.springbootCurdOperation.dto.EmployeeResponse;
import com.neosoft.springbootCurdOperation.dto.QueryResponse;
import com.neosoft.springbootCurdOperation.entity.Employee;
import com.neosoft.springbootCurdOperation.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeResponse saveEmployee(@RequestBody @Valid EmployeeRequest employeeRequest){
        return employeeService.saveemployee(employeeRequest);

    }
    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<EmployeeResponse> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{empId}")
    @ResponseStatus(HttpStatus.FOUND)
    public EmployeeResponse getEmployeeById(@PathVariable Integer empId){
        return employeeService.getEmployeeById(empId);
    }
    @DeleteMapping("/{empId}")
    @ResponseStatus(HttpStatus.GONE)
    public void deleteEmployeeById(@PathVariable Integer empId){
        employeeService.deleteEmployeeById(empId);
    }
    @PutMapping("/{empId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public EmployeeResponse updateEmployee(@PathVariable Integer empId,@RequestBody @Valid EmployeeRequest employeeRequest){
        return employeeService.updateEmployee(empId,employeeRequest);
    }
    @GetMapping("/bySorting/{field}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<EmployeeResponse> getAllEmployeeBySorting(@PathVariable String field){
        return employeeService.getAllEmployeeBySorting(field);
    }

    @GetMapping("/byPagination/{offset}/{pageSize}")
    @ResponseStatus(HttpStatus.FOUND)
    public Page<Employee> getAllEmployeeByPagination(@PathVariable int offset, @PathVariable int pageSize){
        return employeeService.getAllEmployeeByPagination(offset,pageSize);
    }


    @GetMapping("/byPagination/{offset}/{pageSize}/{field}")
    @ResponseStatus(HttpStatus.FOUND)
    public Page<Employee> getAllEmployeeByPaginationWithSorting(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field){
        return employeeService.getAllEmployeeByPaginationWithSorting(offset,pageSize,field);
    }
    @GetMapping("/phoneNumber")
    @ResponseStatus(HttpStatus.FOUND)
    public List<QueryResponse> getEmployeeWithPhoneNumber(){
        return employeeService.getEmployeeWithPhoneNumber();
    }
}
