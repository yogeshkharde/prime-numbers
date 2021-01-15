Feature: prime numbers can be retrieved
  Scenario: client makes call to GET /primes
    When the client requests prime numbers with upper bound of 10
    Then the client receives status code of 200
    And the client receives 4 prime numbers