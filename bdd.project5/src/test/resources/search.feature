Feature: Search
  As an end user
  I want to search for product
  So that i can see all respective result

  Scenario: Search for product
    Given i am on homepage
    When i search for product "nike"
    Then i should be able to see respective result