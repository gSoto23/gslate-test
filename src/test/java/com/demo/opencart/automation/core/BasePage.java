package com.demo.opencart.automation.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    private WebDriver driver;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * This is the method to get the driver in the stepsDef
     * @return driver
     */
    public WebDriver getDriver(){
        return driver;
    }
}

