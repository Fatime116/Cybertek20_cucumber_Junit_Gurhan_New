package com.cybertek.step_definitions;

import com.cybertek.pages.WikiPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class WikiStepDefinitions {


    WikiPage wikiPage = new WikiPage();

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {

        Driver.getDriver().get("https://www.wikipedia.org");
    }

    @When("User searches {string} in the wiki search box")
    public void user_searches_in_the_wiki_search_box(String string) {
    wikiPage.searchBox.sendKeys(string + Keys.ENTER);

    }

    @Then("User should see {string} is in the wiki title")
    public void user_should_see_is_in_the_wiki_title(String string) {

      String actualTitle = Driver.getDriver().getTitle();


        Assert.assertTrue(actualTitle.contains(string));//string is my expected title

    }


    @Then("User should see {string} is in the main header")
    public void userShouldSeeIsInTheMainHeader(String expected) {

        String actualHeaderText = wikiPage.mainHeaderAfterSearch.getText();

        Assert.assertEquals(actualHeaderText,expected);

    }

    @Then("User should see {string} is in the image header")
    public void userShouldSeeIsInTheImageHeader(String expectedHeaderText) throws InterruptedException{

        String actualImageHeaderText= wikiPage.imageHeaderAfterSearch.getText();
        Thread.sleep(3000);
        Assert.assertEquals(actualImageHeaderText,expectedHeaderText);
    }
}
