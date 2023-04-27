package com.neosoft.springbootCurdOperation.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ErrorResponse {

    private String message;
    private HttpStatus status;
    private String details;
}
