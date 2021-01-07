Feature: Ask for a receipt

  Background:
    Given Sarah has a Caffinate-Me account

  Scenario: Order several items
    Given Sarah has ordered:
      | Quantity | Product          |
      | 1        | large cappuccino |
      | 1        | muffin           |
    When she asks for a receipt
    Then she should receive a receipt totalling:
      | subtotal | Service Fee | Total |
      | 3.50     | 0.18        | 3.68  |
