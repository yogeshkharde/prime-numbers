package com.primenumbers.app.service;

import org.apache.commons.collections4.CollectionUtils;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PrimeNumberGeneratorServiceTest {

    private PrimeNumberGeneratorService service = new PrimeNumberGeneratorService();

    @Test
    public void testNumberOfPrimeElementsAreNotMoreOrLessThanExpected() {
        //execute
        List<Integer> primeNumbers = service.getPrimeNumbers(5);

        //assert
        Assertions.assertEquals(3, primeNumbers.size());
    }

    @Test
    public void testNumberOfPrimeElementsAreNotMoreOrLessThanExpected_1() {
        //execute
        List<Integer> primeNumbers = service.getPrimeNumbers_1(5);

        //assert
        Assertions.assertEquals(3, primeNumbers.size());
    }

    @Test
    public void testReturnedPrimeNumbersAreSameAsExpected() {
        //prepare
        List<Integer> expectedList = Lists.newArrayList(2, 5, 3, 7, 11, 13);

        //execute
        List<Integer> primeNumbers = service.getPrimeNumbers(15);

        //assert
        CollectionUtils.isEqualCollection(expectedList, primeNumbers);
    }

    @Test
    public void testReturnedPrimeNumbersAreSameAsExpected_1() {
        //prepare
        List<Integer> expectedList = Lists.newArrayList(2, 5, 3, 7, 11, 13);

        //execute
        List<Integer> primeNumbers = service.getPrimeNumbers_1(15);

        //assert
        CollectionUtils.isEqualCollection(expectedList, primeNumbers);
    }
}