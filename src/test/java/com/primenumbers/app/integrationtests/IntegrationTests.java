package com.primenumbers.app.integrationtests;

import com.primenumbers.app.PrimeNumbersApp;
import com.primenumbers.app.model.PrimeNumberResponse;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

@CucumberContextConfiguration
@SpringBootTest(classes = PrimeNumbersApp.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class IntegrationTests {

    ResponseEntity<PrimeNumberResponse> responseEntity;

    protected RestTemplate restTemplate = new RestTemplate();

    void executeGet(String url, Map<String, String> urlPrams) throws IOException {

        URI uri = UriComponentsBuilder.fromUriString(url)
                .buildAndExpand(urlPrams)
                .toUri();

        responseEntity =
                restTemplate.exchange(RequestEntity.get(uri).build(), PrimeNumberResponse.class);
    }
}
