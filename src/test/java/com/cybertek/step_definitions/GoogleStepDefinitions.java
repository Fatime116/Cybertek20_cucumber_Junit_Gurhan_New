package com.cybertek.step_definitions;

import com.cybertek.pages.GoogleSearchPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

public class GoogleStepDefinitions {

    //creating the page object, i use this in the class level
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Given("User is on the google search page")
    public void user_is_on_the_google_search_page() {
        //onpurpose failing
       // Assert.fail("onpurpose failing...!"); //if first one fails, skip executing second one
        Driver.getDriver().get("https://www.google.com");
        //added
        //
    }

    @Then("User should see title is Google")
    public void user_should_see_title_is_google() {
      String actualTitle = Driver.getDriver().getTitle();
      String expectedTitle = "Google";
      //onpurpose failing, Assert.fail will fail the test no matter what
      //Assert.fail("onpurpose failing...!");
        //Assert is from Junit here, because we are using cucumber with Junit
        Assert.assertEquals("Actual title does not match expected title",actualTitle,expectedTitle);

    }

    @When("User searches apple")
    public void userSearchesApple() {

        googleSearchPage.searchBox.sendKeys("apple" + Keys.ENTER);
    }

    @Then("User should see apple in the title")
    public void userShouldSeeAppleInTheTitle() {

        String expectedTitle = "apple - Google Search";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);


    }


    @When("User searches {string}")
    public void userSearches(String searchValue) {

        googleSearchPage.searchBox.sendKeys(searchValue + Keys.ENTER);

    }

    @Then("User should see {string} in the title")
    public void userShouldSeeInTheTitle(String expectedInTitle) {

        String expectedTitle = expectedInTitle + " - Google Search";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
    }


    @Then("User should see About link")
    public void userShouldSeeAboutLink() {
        Assert.assertTrue(googleSearchPage.aboutLink.isDisplayed());

    }

    @And("User clicks to About link")
    public void userClicksToAboutLink() {
        googleSearchPage.aboutLink.click();
    }

    @Then("User should see title Google - About Google, Our Culture & Company News")
    public void userShouldSeeTitleGoogleAboutGoogleOurCultureCompanyNews() {

        String expectedTitle = "Google - About Google, Our Culture & Company News";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

    }

    @Then("User should see six links in the footer")
    public void user_should_see_six_links_in_the_footer(List<String> linkStrings) {

       //listStrings is from our feature file
        System.out.println("linkStrings = " + linkStrings);
        int expectedSize = linkStrings.size();
        int actualSize = googleSearchPage.footerLinks.size();

        Assert.assertEquals(actualSize,expectedSize);




    }




    

}
