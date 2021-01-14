package com.primenumbers.app.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/primes")
@Api(tags = "Prime Numbers", description = "Controller for generating prime numbers")
public class PrimeNumbersController {


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get Prime numbers")
    public String getPrimeNumbers() {
        return "Hello";
    }
}
