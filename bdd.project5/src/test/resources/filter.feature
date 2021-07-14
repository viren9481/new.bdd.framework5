Feature: Filter by
  As an end user
  I want to apply filter on product
  So that i can see all filtered products

  Scenario: Filter by review
    Given i am on homepage
    When i search for product "nike"
    And i apply filter "4or more" on result
    Then i can see all product "review" are filtered "4.0"
    Scenario: Filter by range
      Given i am on homepage
      When  i search for product "nike"
      And i apply filter "£15 - £20" on result
      Then i can see all product "range" are filtered "15-20"
