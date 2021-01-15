package com.primenumbers.app.controllers;

import com.primenumbers.app.model.PrimeNumberResponse;
import com.primenumbers.app.service.PrimeNumberGeneratorService;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PrimeNumbersControllerTest {

    @Mock
    private PrimeNumberGeneratorService mockService;

    private PrimeNumbersController primeNumbersController;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        Mockito.when(mockService.getPrimeNumbers_1(Mockito.anyInt())).thenCallRealMethod();
        primeNumbersController = new PrimeNumbersController(mockService);
    }

    @Test
    public void executeGetSuccessfullyWithValidUpperBound() throws Exception {
        //execute
        PrimeNumberResponse primeNumbers = primeNumbersController.getPrimeNumbers(5);

        //assert
        Assert.assertNotNull(primeNumbers);
        List<Integer> primes = primeNumbers.getPrimes();
        Assert.assertTrue(CollectionUtils.isNotEmpty(primes));
    }

    @Test
    public void invalidUpperBoundShouldReturnEmptyListOfPrimes() throws Exception {
        //execute
        PrimeNumberResponse primeNumbers = primeNumbersController.getPrimeNumbers(1);

        //assert
        Assert.assertNotNull(primeNumbers);
        List<Integer> primes = primeNumbers.getPrimes();
        Assert.assertTrue(CollectionUtils.isEmpty(primes));
    }
}