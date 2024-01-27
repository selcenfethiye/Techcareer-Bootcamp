Feature: Search Feature

  Background:

    Given I open home page

  Scenario: Search product

    Then I see "LC Waikiki" as page title

    When I click the searchbar

    And I type "elb" in the search bar

    Then I see "Çocuk Elbise" as first suggestion

    And I close driver

    