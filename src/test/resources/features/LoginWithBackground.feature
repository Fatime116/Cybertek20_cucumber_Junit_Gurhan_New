@loginWithBackground
Feature: Login feature
  CBT-25: As a user, I should be able to login with correct credentials
  to different accounts. and dashboard should be displayed.
#this is how you comment in feature file

  Background: User is on the login page
    Given User is on the login page
#After Annotation runs here

  Scenario: Librarian login scenario
    When user logs in as librarian
    Then User should see dashboard
#After Annotation runs here

  Scenario: Student login scenario
    When user logs in as student
    Then User should see dashboard
#After Annotation runs here

  @db
  Scenario: Admin login scenario
     #Before Annotation runs here
    #BeforeStep runs here
    When user logs in as admin
    #AfterStep runs here
    #BeforeStep runs here
    Then User should see dashboard
    #After step runs here
    #After Annotation runs here