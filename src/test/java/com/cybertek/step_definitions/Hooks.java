package com.cybertek.step_definitions;
/**
 * Hooks name is not reserved. You may name this class in any way.
 * For example: SuiteSetupAndTearDown
 * Hooks triggered based on tags not class name or their location.
 * These methods can be a part of any step definition class.
 * Common practice is to store them in the separate class.
 */

import com.cybertek.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.util.concurrent.TimeUnit;
public class Hooks {
//    hook before = @BeforeMethod in TestNG
//    hook after = @AfterMethod in TestNG
//    it's not a good idea to mix implicit and explicit waits. It can lead to unexpectedly long waits.
//    usually, we just use explicit and fluent waits.

    @Before
    public void setup(Scenario scenario) {
        System.out.println("::: Starting Automation:::");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @BeforeStep
    public void beforeStep(){
        System.out.println("I'm before step");
    }
//    this hook will run only before scenarios with a tag @db

    /**
     * @db Scenario: I don't know but here I'm connecting to DB
     * Given user runs following query "SELECT * ...."
     * <p>
     * order = 0 - to define hooks execution order
     */
    @Before(value = "@db", order = 0)
    public void dbSetup() {
        System.out.println("::: Connecting to the database:::");
    }

    @After("@db")
    public void dbTearDown() {
        System.out.println("::: Disconnecting from the database:::");
    }

    @After
    public void tearDown(Scenario scenario) {
        //close browser, close DB connection, close tunnel,capture screenshot of the error, etc..
        //this is a hook after
        //runs automatically after every test
        if (scenario.isFailed()) {
            byte[] data = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", scenario.getName());
        }

        Driver.closeDriver();
        System.out.println(":::(^_^) End of test execution (*_*):::");
    }
//    @Before(order =2)
//    public void setUpScenario(){
//        System.out.println("----> Before annotation: Setting up browser");
//    }
//
//    @Before(value = "@db",order = 1)//runs with matching @db feature class
//    public void setUpDatabaseConnection(){
//        System.out.println("----> Before annotation: DB connection created <-----");
//    }
//
//    @After(order = 1)
//    public void tearDownScenario(Scenario scenario){
//       // System.out.println("-------->After annotation: Closing browser");
//        //Scenario class coming from cucumber, it is allowing us to get information about the
//        //the currently running scenario
//
////        System.out.println("scenario.getName() = " + scenario.getName());
////        System.out.println("scenario.getSourceTagNames() = " + scenario.getSourceTagNames());
////        System.out.println("scenario.isFailed() = " + scenario.isFailed());
//
//        //#1we need to take a screen shot using Selenium
//         //used downCasting,driver type to  TakesScreenshot
//        // in order to use the method getScreenshotAs() from TakesScreenshot interface,
//
//
//        //#2 we are going to attach it into our report
//        //attach method accepts 3 arguments. #1: Screenshot itself #2: image type #3 current scenario's name
//        //I attach it when ONLY after my each scenario is failed
//
//        if(scenario.isFailed()){
//            byte[] screenshot = ( (TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot,"image/png",scenario.getName());
//        }
//    }
//
//    @After(value = "@db",order = 2)//after scenario
//    public void tearDownDatabaseConnection(){
//        System.out.println("----> After annotation: DB connection closed <-----");
//    }
//
//    @BeforeStep
//    public void setupStep(){
//        System.out.println("==============> BeforeStep: Taking Screen shot <================");
//    }
//
//    @AfterStep
//    public void tearDownStep(){
//        System.out.println("==============> AfterStep: Taking Screen shot <================");
//    }


}
