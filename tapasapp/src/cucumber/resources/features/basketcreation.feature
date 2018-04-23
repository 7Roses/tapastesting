Feature: A new empty basket can be created
  Scenario: Client creates a new Basket, and verifies it's empty
    When the user creates a new Basket
    Then the total number of items in the Basket with id 1 equals 0

  Scenario: Client can add a Tapas to his Basket
    When the user creates a new Basket
    And the user adds 5 Tapas with id 3 to the Basket with id 1
    Then the number of items with id 3 in the Basket with id 1 equals 5
    And the total number of items in the Basket with id 1 equals 5

  Scenario: Client can add several Tapas to his Basket
    When the user creates a new Basket
    And the user adds 5 Tapas with id 3 to the Basket with id 1
    And the user adds 3 Tapas with id 5 to the Basket with id 1
    Then the number of items with id 3 in the Basket with id 1 equals 5
    And the number of items with id 5 in the Basket with id 1 equals 3
    And the total number of items in the Basket with id 1 equals 8

  Scenario: Client can Calculate a Total Cost for all the Tapas in his Basket
    When the user creates a new Basket
    And the user adds 5 Tapas with id 3 to the Basket with id 1
    And the user adds 3 Tapas with id 5 to the Basket with id 1
    Then the Total Cost for all the Tapas in the Basket with id 1 equals 24

  Scenario: Client can Add and then Remove Tapas from his Basket
    When the user creates a new Basket
    And the user adds 5 Tapas with id 3 to the Basket with id 1
    And the user adds 3 Tapas with id 5 to the Basket with id 1
    Then the Total Cost for all the Tapas in the Basket with id 1 equals 24