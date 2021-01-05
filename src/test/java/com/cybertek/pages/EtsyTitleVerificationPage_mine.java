package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsyTitleVerificationPage_mine {

    public EtsyTitleVerificationPage_mine(){

        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id ="global-enhancements-search-query")
    public WebElement EtsySearchBox;


}
