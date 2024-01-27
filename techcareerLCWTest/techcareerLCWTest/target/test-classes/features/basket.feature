Feature: Basket Feature

  Background:

    Given I open home page

  Scenario: Add product and go basket page

    Then I see "LC Waikiki" as page title

    When I go shoes category page

    Then I see "https://www.lcwaikiki.com/tr-TR/TR/erkek/ayakkabi" as page URL for "Shoes Category"

    When I go product page

    Then I see "https://www.lcwaikiki.com/tr-TR/TR/urun/" as page URL for "Product"

    When I go basket page

    Then I see "https://www.lcwaikiki.com/tr-TR/TR/sepetim" as page URL for "Basket"

    When I go home page

    Then I see "LC Waikiki" as page title

    And I close driver

