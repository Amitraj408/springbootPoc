package com.neosoft.springbootCurdOperation.repository;

import com.neosoft.springbootCurdOperation.dto.EmployeeResponse;
import com.neosoft.springbootCurdOperation.dto.QueryResponse;
import com.neosoft.springbootCurdOperation.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query("select new com.neosoft.springbootCurdOperation.dto.QueryResponse(e.empName,p.phoneNumber) from Employee e join e.phoneNumber p")
    List<QueryResponse> getEmployeeWithPhoneNumber();
}
