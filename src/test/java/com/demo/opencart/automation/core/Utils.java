package com.demo.opencart.automation.core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

    /**
     * Determinates if an element is displayed.
     * @param element
     */
    public static boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Enters text to an input field element
     * @param element
     * @param text
     */
    public static void type(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    /**
     * This method find and click an specific element.
     * @param element
     */
    public static void findAndClick(WebElement element, WebDriver driver){
        waitForElementToBeClickable(element, driver);
        element.click();
    }

    /**
     * Waits for an element to be clickable
     * @param element
     */
    public static void waitForElementToBeClickable(WebElement element, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,50);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * This Method wait until the page is loaded
     */
    public static void waitForPageLoad(WebDriver driver) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 50);
        wait.until(d -> {
            System.out.println("Current Window State       : "
                    + ((JavascriptExecutor) d).executeScript("return document.readyState"));
            return String
                    .valueOf(((JavascriptExecutor) d).executeScript("return document.readyState"))
                    .equals("complete");
        });
    }

    /**
     * This method compare two different strings from WebElements
     * @param actual
     * @param expected
     * @return Boolean is the strings matches
     */
    public static boolean compareStrings(WebElement actual, String expected){
        if (actual.getText().equals(expected)) {
            System.out.println("String matches " + actual + " and " + expected);
            return true;
        } else throw new RuntimeException("String doesn't matches " + actual.getText() + " and " + expected);
    }

    /**
     * This method test that partial text is displayed in an element.
     * @param element
     * @param expected
     * @return
     */
    public static boolean textContain(WebElement element, String expected){
        try {
            element.getText().contains(expected);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}