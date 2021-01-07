@title
Feature:Title verification

  Background:
    Given User is on the Etsy Homepage
  @failed_Test_check
  Scenario: Etsy Title Verification
    Then User should see title Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone

  Scenario:Etsy Search Functionality Title Verification (without parameterization)
    When User searches Wooden spoon in search box
    Then User should see Wooden spoon as title

    @woodenspoonEtsy
  Scenario: Etsy Search Functionality Title Verification (with parameterization)
    When User searches "Wooden spoon" in search box
    Then User should see "Wooden spoon" as title
