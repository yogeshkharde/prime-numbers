package com.primenumbers.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PrimeNumberResponse {
    @JsonProperty
    private int initial;

    @JsonProperty
    private List<Integer> primes;

    public PrimeNumberResponse() {
    }

    public PrimeNumberResponse(int initial, List<Integer> primes) {
        this.initial = initial;
        this.primes = primes;
    }

    public int getInitial() {
        return initial;
    }

    public List<Integer> getPrimes() {
        return primes;
    }
}
