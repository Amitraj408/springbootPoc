package com.neosoft.springbootCurdOperation.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class QueryResponse {

    public String empName;
    public String phoneNumber;

    public QueryResponse(String empName, String phoneNumber) {
        this.empName = empName;
        this.phoneNumber = phoneNumber;
    }
}
