package com.primenumbers.app.service;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PrimeNumberGeneratorService {

    /**
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

//    /**
//     * @param upperBound number upto which prime numbers are found starting from 2
//     * @return list off all prime numbers from 2 to upperBound
//     */
//    public List<Integer> getPrimeNumbers_1(int upperBound) {
//        List<Integer> primeNumbers = new LinkedList<Integer>();
//        List<Integer> allNumbers = new LinkedList<Integer>();
//        for (int i = 2; i <= upperBound; i++) {
//            allNumbers.add(i);
//        }
//
//
//        for(int i=2;i<=upperBound; i++){
//upperBound
//        }
//
//        allNumbers
//        return primeNumbers;
//    }


}
