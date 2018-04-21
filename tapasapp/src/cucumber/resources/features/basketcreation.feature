Feature: A new empty basket can be created
  Scenario: Client creates a new basket, and verifies it's empty
    When the user creates a new basket
    Then the number of items in the basket with id 1 equals 0