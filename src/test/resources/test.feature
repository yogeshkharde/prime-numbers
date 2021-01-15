Feature: prime numbers can be retrieved

  Scenario: client makes call to GET /primes
    When the client requests prime numbers with upper bound of 10
    Then the client receives status code of 200
    And the response type is "xml"
    And the client receives 4 prime numbers

  Scenario: client makes call to GET /primes with a accept value
    When the client requests prime numbers with upper bound of 10 and response type as "application/json"
    Then the client receives status code of 200
    And the response type is "json"
    And the client receives 4 prime numbers

  Scenario: client makes call to GET /primes with invalid upper bound
    When the client requests prime numbers with upper bound of 1 and request fails as bad request