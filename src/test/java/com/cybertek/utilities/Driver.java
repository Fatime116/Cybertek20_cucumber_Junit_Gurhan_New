package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    private Driver(){//private Constructor

    }

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {

            String browser = ConfigurationReader.getProperty("browser");

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "remote-chrome"://it is in the same computer, so it is called remote
                    //we can go to configuration.properties file to change browser type to remote-chrome
                    try {
//                    ChromeOptions chromeOptions = new ChromeOptions();//child of DesiredCapabilities, new way
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();//traditional way
                        desiredCapabilities.setBrowserName("chrome");//we need to tell what kind of browser we need to use in desired capability
                        //can also specify browser version, platform(Linux, IOS, Windows)
                        //by default 4444 is reserved port number for selenium grid hub, it can be changed
                        URL gridUrl = new URL("http://52.204.192.205:4444/wd/hub");
                        driver = new RemoteWebDriver(gridUrl, desiredCapabilities);//RemoteWebDriver is from Selenium
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;


            }

        }

        return driver;
    }


    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
