package com.estonianec.hw2dot4;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeArrayOverflow extends RuntimeException {

    public EmployeeArrayOverflow(String s) {
        super(s);
    }
}
