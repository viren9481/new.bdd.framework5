Feature: add product to basket
  As an end user
  I want to add product into basket
  So that i can buy that product

  Scenario: Add product to basket
    Given i am on homepage
    When i search for product "puma"
    And i select any product
    And i add product to basket
    Then the product should be in the basket