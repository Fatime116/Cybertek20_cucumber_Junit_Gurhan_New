Feature: Search
  Agile Story: As a user, I should be able to search when I am on Google search page

  @ScenarioOutline @googleSearch
  Scenario Outline: Google title verification after search
    Given User is on the google search page
    When User searches "<searchValue>"
    Then User should see "<expectedValue>" in the title

    Examples: Search values I want to search in Google
    |searchValue|expectedValue|
    #if first one fail, but it did not stop rest of them to be continued
    |apple      |apple        |
    |kiwi       |kiwi         |
    |orange     |orange       |