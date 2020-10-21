package io.ctdev.tests.sign_up;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

//@Listeners(UniversalVideoListener.class)
public class RegistrationUserTest extends SetData {

    Actions act;
    Random random;


    private String emailStart = "wizdmak+";
    private String emailEnd = "@gmail.com";
    private String password = "Qwerty1234&";
    private String answer = "3777";
    private int randomNumberToLogin;
    private String actualResult;
    private String expectedResult = "Registration completed successfully. You can now log in.";

    @BeforeClass
    public void setRandomName() {
        random = new Random();
        randomNumberToLogin = random.nextInt(1000);
    }

    @Test
    public void userIsAbleToSignUp() {
        act = new Actions(driver);

        signUpPage.openPage();
        signUpPage.enterEmail(emailStart+randomNumberToLogin+emailEnd);
        signUpPage.enterPassword(password);
        signUpPage.enterRepeatPassword(password);
        signUpPage.openSlidePasswordAdvice();
        signUpPage.openListOfSecurityQuestion();
        signUpPage.selectSecurityQuestion("Number of one of your customer or ID cards?");
        signUpPage.enterSecurityAnswer(answer);
        signUpPage.enterRegisterButton();
        actualResult = signUpPage.getTextFromElementWithContainText("Registration completed successfully. You can now log in.");
        Assert.assertEquals(actualResult,expectedResult, "Registration failed");
    }

}
