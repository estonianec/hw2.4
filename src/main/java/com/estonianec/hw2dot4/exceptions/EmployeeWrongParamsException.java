package com.estonianec.hw2dot4.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeWrongParamsException extends RuntimeException {
    public EmployeeWrongParamsException() {
        super();
    }
}
