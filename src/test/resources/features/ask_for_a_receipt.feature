Feature: Ask for a receipt

  Background:
    Given Sarah has a Caffinate-Me account

    Scenario: Order several items
      Given Sarah has ordered:
      | Quantity | Product          |
      | 1        | large cappuccino |
      | 2        | muffin           |
      | 1        | espresso         |
