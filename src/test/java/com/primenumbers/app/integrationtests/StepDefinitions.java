package com.primenumbers.app.integrationtests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StepDefinitions extends IntegrationTests {

    @When("the client requests prime numbers with upper bound of {int}")
    public void theClientRequestsPrimeNumbersWithUpperBoundOf(int arg0) throws IOException {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("upperBound", Integer.toString(arg0));
        executeGet("http://localhost:8080/primes/{upperBound}", urlParams, null);
    }

    @Then("the client receives status code of {int}")
    public void theClientReceivesStatusCodeOf(int arg0) {
        Assert.assertEquals(arg0, responseEntity.getStatusCodeValue());
    }

    @And("the client receives {int} prime numbers")
    public void theClientReceivesPrimeNumbers(int arg0) {
        Assert.assertEquals(arg0, responseEntity.getBody().getPrimes().size());
    }

    @And("the response type is {string}")
    public void theResponseTypeIs(String arg0) {
        String subtype = responseEntity.getHeaders().getContentType().getSubtype();
        Assert.assertEquals(arg0, subtype);
    }

    @When("the client requests prime numbers with upper bound of {int} and request fails as bad request")
    public void theClientRequestsPrimeNumbersWithUpperBoundOfAndRequestFailsAsBadRequest(int arg0) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("upperBound", Integer.toString(arg0));
        try {
            executeGet("http://localhost:8080/primes/{upperBound}", urlParams, null);
        } catch (HttpClientErrorException cee) {
            Assert.assertEquals(400, cee.getRawStatusCode());
        }
    }

    @When("the client requests prime numbers with upper bound of {int} and response type as {string}")
    public void theClientRequestsPrimeNumbersWithUpperBoundOfAndResponseTypeAs(int arg0, String arg1) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("upperBound", Integer.toString(arg0));

        MediaType accepts = null;

        if (arg1.equalsIgnoreCase("application/json")) {
            accepts = MediaType.APPLICATION_JSON;
        } else if (arg1.equalsIgnoreCase("application/xml")) {
            accepts = MediaType.APPLICATION_XML;
        }
        executeGet("http://localhost:8080/primes/{upperBound}", urlParams, accepts);
    }
}
