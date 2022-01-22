package com.demo.opencart.automation.pages;

import com.demo.opencart.automation.core.BasePage;
import com.demo.opencart.automation.core.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    //Locators
    @FindBy(css = "a.dropdown-toggle[title='My Account']")
    private WebElement myAccountBtn;

    @FindBy(css = "a[href='https://demo.opencart.com/index.php?route=account/register']")
    private WebElement registerBtn;

    @FindBy(id = "input-firstname")
    private WebElement firstName;

    @FindBy(id = "input-lastname")
    private WebElement lastName;

    @FindBy(id = "input-email")
    private WebElement email;

    @FindBy(id = "input-telephone")
    private WebElement phone;

    @FindBy(id = "input-password")
    private WebElement password;

    @FindBy(id = "input-confirm")
    private WebElement confirmPassword;

    @FindBy(css = "input[type='checkbox']")
    private WebElement privacyPolicy;

    @FindBy(css = "input.btn-primary[type='submit']")
    private WebElement continueBtn;

    @FindBy(css = "#common-success h1")
    private WebElement successMsg;

    @FindBy(css = "#content a.btn-primary")
    private WebElement finishBtn;

    public RegisterPage (Hook hook) {
        super(hook.driver);
    }

    @Given("Go to home page")
    public void goToHomePage() {
        Utils.waitForPageLoad(getDriver());
    }

    @And("Click on my account button")
    public void clickOnMyAccountButton() {
        Utils.findAndClick(myAccountBtn,getDriver());
    }

    @And("Click on register")
    public void clickOnRegister() {
        Utils.findAndClick(registerBtn,getDriver());
    }

    @And("Fill up the form to create a user Name: {string} LastName: {string} Email: {string} Phone: {string} Password: {string}")
    public void fillUpTheFormToCreateAUserNameLastNameEmailPhonePassword(String arg0, String arg1, String arg2, String arg3, String arg4) {
        Utils.type(firstName,arg0);
        Utils.type(lastName,arg1);
        Utils.type(email,arg2);
        Utils.type(phone,arg3);
        Utils.type(password,arg4);
        Utils.type(confirmPassword,arg4);
    }

    @And("Click in the checkbox to accept Privacy Policy")
    public void clickInTheCheckboxToAcceptPrivacyPolicy() {
        Utils.findAndClick(privacyPolicy,getDriver());
    }

    @And("Click on continue")
    public void clickOnContinue() {
        Utils.findAndClick(continueBtn,getDriver());
    }

    @Then("Verify that user was created successfully")
    public void verifyThatUserWasCreatedSuccessfully() {
        Utils.isDisplayed(successMsg);
        Utils.findAndClick(finishBtn,getDriver());
    }
}
