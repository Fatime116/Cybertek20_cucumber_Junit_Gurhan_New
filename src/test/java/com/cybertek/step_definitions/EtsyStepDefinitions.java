package com.cybertek.step_definitions;

import com.cybertek.pages.EtsySearchPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EtsyStepDefinitions {

    EtsySearchPage etsySearchPage = new EtsySearchPage();

    @Given("User is on the Etsy Home page")
    public void user_is_on_the_etsy_home_page() {

        Driver.getDriver().get("https://www.etsy.com");


    }


    @Then("User should see title is as expected")
    public void userShouldSeeTitleIsAsExpected() {

    String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
    String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
        Driver.closeDriver();

    }


    @When("User searches {string} in the search box")
    public void userSearchesInTheSearchBox(String searchValue) {

      etsySearchPage.searchBox.sendKeys(searchValue);

    }

    @And("User clicks to search button")
    public void userClicksToSearchButton() {

        etsySearchPage.searchButton.click();
    }

    @Then("User should see{string} in the Etsy title")
    public void userShouldSeeInTheEtsyTitle(String expectedTitle) {

  String actualTitle = Driver.getDriver().getTitle();
  Assert.assertTrue(actualTitle.contains(expectedTitle));

  Driver.getDriver().close();


    }
}
