package io.ctdev.cucumber.stepdef;

import io.ctdev.driver.WebDriverSingleton;
import io.ctdev.pages.signUp.SignUpPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class EmailValidationStepdefs {

    private SignUpPage signUpPage = new SignUpPage(WebDriverSingleton.getDriver());
    @Given("user on SignUp page")
    public void userOnSignUpPage() {
        signUpPage.openPage();
    }

    @When("user enters the email {string}")
    public void userEntersTheEmail(String email) {
        signUpPage.enterEmail(email);
    }

    @And("user enter tab" )
    public void userEnterTab() {
        signUpPage.sendKeysFromKeyboardToEmailField(Keys.TAB);
    }

    @Then("user verify error {string}")
    public void userVerifyError(String expectedError) {
        String error = signUpPage.getCurrentEmailError();
        Assert.assertEquals(error,expectedError, "Incorrect error");
    }


}
