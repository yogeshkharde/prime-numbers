package com.primenumbers.app.service;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PrimeNumberGeneratorService {

    /** using two for loops
     * @param upperBound number upto which prime numbers are found starting from 2
     * @return list off all prime numbers from 2 to upperBound
     */
    public List<Integer> getPrimeNumbers(int upperBound) {
        List<Integer> primeNumbers = new LinkedList<Integer>();
        for (int i = 1; i <= upperBound; i++) {
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    if (i == j) {
                        primeNumbers.add(i);
                    } else {
                        break;
                    }
                }
            }
        }
        return primeNumbers;
    }

    /** using Sieve of Eratosthenes
     * @param upperBound number upto which prime numbers are found starting from 2
     * @return list off all prime numbers from 2 to upperBound
     */
    public List<Integer> getPrimeNumbers_1(int upperBound) {
        List<Integer> primeNumbers = new LinkedList<>();
        int primes[] = new int[upperBound + 1]; //add all the integers upto n to an array, and lets assume all are prime
        for (int i = 0; i < upperBound; i++) {
            primes[i] = i + 1;
        }

        // now lets find out multiples of square of each prime number starting from 2 and mark them
        for (int p = 2; p * p <= upperBound; p++) {

            // Update all multiples of p to -1
            for (int i = p * p; i <= upperBound; i += p) {
                primes[i] = -1;
            }
        }

        // add all primes numbers to a list
        for (int i = 2; i <= upperBound; i++) {
            if (primes[i] != -1) { //ignore all -1
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }


}
