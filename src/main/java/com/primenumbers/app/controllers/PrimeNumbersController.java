package com.primenumbers.app.controllers;

import com.primenumbers.app.model.PrimeNumberResponse;
import com.primenumbers.app.service.PrimeNumberGeneratorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/primes")
@Api(tags = "Prime Numbers", description = "Controller for generating prime numbers")
public class PrimeNumbersController {

    private final PrimeNumberGeneratorService primeNumberGeneratorService;

    @Autowired
    public PrimeNumbersController(PrimeNumberGeneratorService primeNumberGeneratorService) {
        this.primeNumberGeneratorService = primeNumberGeneratorService;
    }

    @GetMapping("/{upperBound}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get Prime numbers")
    public PrimeNumberResponse getPrimeNumbers(@PathVariable(name = "upperBound") int upperBound) {

        List<Integer> primeNumbers = primeNumberGeneratorService.getPrimeNumbers(upperBound);

        return new PrimeNumberResponse(upperBound, primeNumbers);
    }
}
