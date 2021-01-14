package com.primenumbers.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PrimeNumberResponse {
    private int initial;
    private List<Integer> primes;
}
