package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before(order =2)
    public void setUpScenario(){
        System.out.println("----> Before annotation: Setting up browser");
    }

    @Before(value = "@db",order = 1)//runs with matching @db feature class
    public void setUpDatabaseConnection(){
        System.out.println("----> Before annotation: DB connection created <-----");
    }

    @After(order = 1)
    public void tearDownScenario(Scenario scenario){
       // System.out.println("-------->After annotation: Closing browser");
        //Scenario class coming from cucumber, it is allowing us to get information about the
        //the currently running scenario

//        System.out.println("scenario.getName() = " + scenario.getName());
//        System.out.println("scenario.getSourceTagNames() = " + scenario.getSourceTagNames());
//        System.out.println("scenario.isFailed() = " + scenario.isFailed());

        //#1we need to take a screen shot using Selenium
         //used downCasting,driver type to  TakesScreenshot
        // in order to use the method getScreenshotAs() from TakesScreenshot interface,


        //#2 we are going to attach it into our report
        //attach method accepts 3 arguments. #1: Screenshot itself #2: image type #3 current scenario's name
        //I attach it when ONLY after my each scenario is failed

        if(scenario.isFailed()){
            byte[] screenshot = ( (TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }
    }

    @After(value = "@db",order = 2)//after scenario
    public void tearDownDatabaseConnection(){
        System.out.println("----> After annotation: DB connection closed <-----");
    }

    @BeforeStep
    public void setupStep(){
        System.out.println("==============> BeforeStep: Taking Screen shot <================");
    }

    @AfterStep
    public void tearDownStep(){
        System.out.println("==============> AfterStep: Taking Screen shot <================");
    }


}
