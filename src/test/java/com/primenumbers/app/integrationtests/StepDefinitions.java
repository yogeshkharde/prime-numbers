package com.primenumbers.app.integrationtests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StepDefinitions extends IntegrationTests {

    @When("the client requests prime numbers with upper bound of {int}")
    public void theClientRequestsPrimeNumbersWithUpperBoundOf(int arg0) throws IOException {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("upperBound", Integer.toString(arg0));
        executeGet("http://localhost:8080/primes/{upperBound}", urlParams);
    }

    @Then("the client receives status code of {int}")
    public void theClientReceivesStatusCodeOf(int arg0) {
        Assert.assertEquals(arg0, responseEntity.getStatusCodeValue());
    }

    @And("the client receives {int} prime numbers")
    public void theClientReceivesPrimeNumbers(int arg0) {
        Assert.assertEquals(arg0, responseEntity.getBody().getPrimes().size());
    }
}
