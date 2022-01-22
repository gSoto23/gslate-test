package com.demo.opencart.automation.pages;

import com.demo.opencart.automation.core.BasePage;
import com.demo.opencart.automation.core.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    //Locators
    @FindBy(css = "#search input")
    private WebElement searchInput;

    @FindBy(css = ".button-group button")
    private WebElement searchResult;

    @FindBy(id = "cart-total")
    private WebElement cartTotal;

    @FindBy(css = "#form-currency button.dropdown-toggle")
    private WebElement currencyBtn;

    @FindBy(css = "li button.currency-select")
    private List<WebElement> currencyOpt;

    public HomePage (Hook hook) {
        super(hook.driver);
    }

    @Given("I navigate to home page")
    public void iNavigateToHomePage() {
        Utils.waitForPageLoad(getDriver());
    }

    @And("Search for a product {string}")
    public void searchForAProduct(String arg0) {
        Utils.type(searchInput,arg0);
    }

    @And("Select the first result displayed to add to the cart")
    public void selectTheFirstResultDisplayedToAddToTheCart() {
        Utils.waitForElementToBeClickable(searchResult,getDriver());
    }

    @Then("The product should be added to the shopping cart {string}")
    public void theProductShouldBeAddedToTheShoppingCart(String arg0) throws InterruptedException {
        Utils.findAndClick(searchResult,getDriver());
        Thread.sleep(2000);
        Utils.compareStrings(cartTotal,arg0);
    }

    @And("Look for the currency dropdown")
    public void lookForTheCurrencyDropdown() {
        Utils.findAndClick(currencyBtn,getDriver());
    }

    @And("Change the currency to € Euro")
    public void changeTheCurrencyTo€Euro() {
        Utils.waitForElementToBeClickable(currencyOpt.get(0),getDriver());
        Utils.findAndClick(currencyOpt.get(0),getDriver());
    }

    @Then("Verify that the currency in the shopping cart match with the currency preselected {string}")
    public void verifyThatTheCurrencyInTheShoppingCartMatchWithTheCurrencyPreselected(String arg0) {
        Utils.textContain(cartTotal,arg0);
    }
}