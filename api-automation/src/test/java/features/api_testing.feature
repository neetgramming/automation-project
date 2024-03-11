Feature: API Testing for Pet Store: https://petstore.swagger.io/

  Scenario: Create a pet
    Given I have the following Pet Data
    | name    | category             | tags                           | status              |
    | Wolf    | {name=dog}           | {name=energetic}, {name=loyal} | available           |
    | Fluffy  | {name=dog}           | {name=Cute}, {name=Playful}    | pending             |
    | Snowy   | {name=guinea-pig}    | {name=Cute}, {name=friendly}   | sold                |
    | Piggy   | {name=pig}           | {name=friendly}                | available           |
    When I send a POST request to "/pet"
    Then the status code should be 200
    And the response should contain the pet details
    | id            | name    | category             | tags                           | status              |
    | expectedValue | Wolf    | {name=dog}           | {name=energetic}, {name=loyal} | available           |
    | expectedValue | Fluffy  | {name=dog}           | {name=Cute}, {name=Playful}    | pending             |
    | expectedValue | Snowy   | {name=guinea-pig}    | {name=Cute}, {name=friendly}   | sold                |
    | expectedValue | Piggy   | {name=pig}           | {name=friendly}                | available           |