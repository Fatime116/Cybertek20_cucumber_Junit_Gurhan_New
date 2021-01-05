@etsyAll
Feature: Etsy search feature
  Agile story:  User should be able to enter search terms and see
  relevant results in the page and in the title

  Background: User is on the Etsy Home page
    Given User is on the Etsy Home page

  Scenario: Etsy Title Verification
    Then User should see title is as expected

    #expected : Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone
  @etsyWip
  Scenario: Etsy Search Functionality Title Verification
    When User searches "wooden spoon" in the search box
    And User clicks to search button
    Then User should see"Wooden spoon" in the Etsy title


