package com.cybertek.step_definitions;

import com.cybertek.pages.EtsyTitleVerificationPage_mine;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class EysyTitleVerificationStepDefinitions_Mine {

    EtsyTitleVerificationPage_mine etsyTitleVerificationPage = new EtsyTitleVerificationPage_mine();

    @Given("User is on the Etsy Homepage")
    public void user_is_on_the_etsy_homepage() {

        Driver.getDriver().get("https://www.etsy.com/");

    }


    @Then("User should see title Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone")
    public void userShouldSeeTitleEtsyShopForHandmadeVintageCustomAndUniqueGiftsForEveryone() {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        Assert.assertEquals("Actual title does not match expected title", actualTitle, expectedTitle);
    }


    @When("User searches Wooden spoon in search box")
    public void userSearchesWoodenSpoonInSearchBox() {

        etsyTitleVerificationPage.EtsySearchBox.sendKeys("Wooden Spoon" + Keys.ENTER);
    }

    @Then("User should see Wooden spoon as title")
    public void userShouldSeeWoodenSpoonAsTitle() {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Wooden spoon | Etsy";
        Assert.assertEquals(actualTitle,expectedTitle);

    }

    @When("User searches {string} in search box")
    public void userSearchesInSearchBox(String searchItem) {
        etsyTitleVerificationPage.EtsySearchBox.sendKeys(searchItem + Keys.ENTER);

    }

    @Then("User should see {string} as title")
    public void userShouldSeeAsTitle(String expectedSearchItem) {

      String actualTitle = Driver.getDriver().getTitle();
      String expectedTitle = expectedSearchItem + " | Etsy";
        Assert.assertEquals(actualTitle,expectedTitle);

    }
}