@wiki
Feature:Wiki title verification

  Background:
    Given User is on Wikipedia home page

  Scenario:Search Functionality Title Verification
    When User searches "Steve Jobs" in the wiki search box
    Then User should see "Steve Jobs" is in the wiki title


  Scenario:Search Functionality header Verification
    When User searches "Steve Jobs" in the wiki search box
    Then User should see "dsfg sfgdh" is in the main header

  Scenario:Search Functionality header Verification
    When User searches "Steve Jobs" in the wiki search box
    Then User should see "Steve Jobs" is in the image header

  @wikiScenarioOutline
  Scenario Outline:Search Functionality Title Verification
    When User searches "<searchValue>" in the wiki search box
    Then User should see "<expectedTitle>" is in the wiki title
    Then User should see "<expectedMainHeader>" is in the main header
    Then User should see "<expectedImageHeader>" is in the image header

    Examples: example test data for wikipedia search
      | searchValue     | expectedTitle   | expectedMainHeader | expectedImageHeader |
      | Steve Jobs      | Steve Jobs      | Steve Jobs         | Steve Jobs          |
      | John Travolta   | John Travolta   | John Travolta      | John Travolta       |
      | Albert Einstein | Albert Einstein | Albert Einstein    | Albert Einstein     |
      | Keanu Reeves    | Keanu Reeves    | Keanu Reeves       | Keanu Reeves        |
      | Bruce Lee       | Bruce Lee       | Bruce Lee          | Bruce Lee           |
      | Dua Lipa        | Dua Lipa        | Dua Lipa           | Dua Lipa            |
      | Thomas Edison   | Thomas Edison   | Thomas Edison      | Thomas Edison       |
    #command+option +L
