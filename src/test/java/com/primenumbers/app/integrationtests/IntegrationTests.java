package com.primenumbers.app.integrationtests;

import com.primenumbers.app.PrimeNumbersApp;
import com.primenumbers.app.model.PrimeNumberResponse;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;
import java.util.Objects;

@CucumberContextConfiguration
@SpringBootTest(classes = PrimeNumbersApp.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class IntegrationTests {

    ResponseEntity<PrimeNumberResponse> responseEntity;

    protected RestTemplate restTemplate = new RestTemplate();

    void executeGet(String url, Map<String, String> urlPrams, MediaType accepts) {

        URI uri = UriComponentsBuilder.fromUriString(url)
                .buildAndExpand(urlPrams)
                .toUri();

        if(Objects.nonNull(accepts)) {
            responseEntity =
                    restTemplate.exchange(RequestEntity.get(uri).accept(accepts).build(), PrimeNumberResponse.class);
        }else{
            responseEntity =
                    restTemplate.exchange(RequestEntity.get(uri).build(), PrimeNumberResponse.class);
        }
    }
}
