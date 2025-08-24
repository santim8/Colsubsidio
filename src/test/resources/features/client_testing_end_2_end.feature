@active
Feature: End to End services

  Scenario: Validate Preapproved for the user
    Given The user is affiliate and titular
    And  The User has credentials
    When I GET request the preapproved response
    Then The response should have a status code of 200

  Scenario: Validation rights for the user
    Given The user is affiliate and titular
    And  The User has credentials
    When I Get request the validation rights response
    Then The response should have a status code of 200
    And The User is active
    And The User is adult

  Scenario: Validate Card for the user
    Given The user is affiliate and titular
    And  The User has credentials
    When I POST request the validation card response
    Then The response should have a status code of 200


  Scenario: Validation Restrictive List for the user
    Given The user is affiliate and titular
    And  The User has credentials
    When I POST request the validation restrictive list response
    Then The response should have a status code of 200
    And The User pass restrictive validation

  Scenario: Validation Preapproved
    Given The user is affiliate and titular
    And  The User has credentials
    When I GET request validation preapproved response
    Then The response should have a status code of 200
    And The User pass preapproved validation