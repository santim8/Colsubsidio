@active
Feature: End to End services

  Scenario Outline: Validation rights for the user
    Given a user with docType "<docType>" and docNumber "<docNumber>"
    And   The User has credentials
    When  I Get request the validation rights response
    Then  The response should have a status code of 200
    And   The User is active
    And   The User is adult

    Examples:
      | docType | docNumber |
      | CC      | 7277260   |

  Scenario Outline: Validate Card for the user
    Given a user with docType "<docType>" and docNumber "<docNumber>"
    And The user is affiliate and titular
    And  The User has credentials
    When I POST request the validation card response
    Then The response should have a status code of 200
    Examples:
      | docType | docNumber |
      | CC      | 7277260   |


  Scenario Outline: Validation Restrictive List for the user
    Given a user with docType "<docType>" and docNumber "<docNumber>"
    And The user is affiliate and titular
    And  The User has credentials
    When I POST request the validation restrictive list response
    Then The response should have a status code of 200
    And The User pass restrictive validation
    Examples:
      | docType | docNumber |
      | CC      | 7277260   |

  Scenario Outline: Validate Preapproved for the user
    Given a user with docType "<docType>" and docNumber "<docNumber>"
    And  The User has credentials
    When I GET request the preapproved response
    Then The response should have a status code of 200
    And The User pass preapproved validation
    Examples:
      | docType | docNumber |
      | CC      | 7277260   |