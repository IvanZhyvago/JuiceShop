package io.ctdev.tests.sign_up;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//@Listeners(UniversalVideoListener.class)
@Epic("SignUp")
@Story("Password Advice Validation")
public class PasswordAdviceValidationTest extends SetData {


    private SoftAssert softAssert;
    private String actualResult;
    private String expectedResult1 = "error";
    private String expectedResult2 = "done";
    private String password1 = "QWERTY12!!";
    private String password2 = "qwerty12!!";
    private String password3 = "Qwerty!!";
    private String password4 = "qWErty22";
    private String password5 = "QwE@14";
    private String passwordCorrect = "Qwerty1234!2#";


    @BeforeMethod
    public void clearValues() {
        signUpPage.clearPasswordField().clearRepeatPasswordField();
    }

    @BeforeClass
    public void openSlide() {
        signUpPage.openSlidePasswordAdvice();
    }


    @Test
    public void passwordAdviceOneLowerCharacterValidation() {

        signUpPage.enterPassword(password1).sendKeysFromKeyboardToPasswordField(Keys.TAB).
                enterRepeatPassword(password1).sendKeysFromKeyboardToRepeatPasswordField(Keys.TAB);
        actualResult = signUpPage.getTextFromElementWithText("contains at least one lower character");
        Assert.assertEquals(actualResult, expectedResult1, "Actual result --> " + actualResult);
    }

    @Test
    public void passwordAdviceOneUpperCharacterValidation() {
        signUpPage.enterPassword(password2).sendKeysFromKeyboardToPasswordField(Keys.TAB).
                enterRepeatPassword(password2).sendKeysFromKeyboardToRepeatPasswordField(Keys.TAB);
        actualResult = signUpPage.getTextFromElementWithText("contains at least one upper character");
        Assert.assertEquals(actualResult, expectedResult1, "Actual result --> " + actualResult);
    }

    @Test
    public void passwordAdviceOneDigitValidation() {
        signUpPage.enterPassword(password3).sendKeysFromKeyboardToPasswordField(Keys.TAB).
                enterRepeatPassword(password3).sendKeysFromKeyboardToRepeatPasswordField(Keys.TAB);
        actualResult = signUpPage.getTextFromElementWithText("contains at least one digit");
        Assert.assertEquals(actualResult, expectedResult1, "Actual result --> " + actualResult);
    }

    @Test
    public void passwordAdviceOneSpecialValidation() {
        signUpPage.enterPassword(password4).sendKeysFromKeyboardToPasswordField(Keys.TAB).
                enterRepeatPassword(password4).sendKeysFromKeyboardToRepeatPasswordField(Keys.TAB);
        actualResult = signUpPage.getTextFromElementWithText("contains at least one special character");
        Assert.assertEquals(actualResult, expectedResult1, "Actual result --> " + actualResult);
    }

    @Test
    public void passwordEightCharactersValidation() {
        signUpPage.enterPassword(password5).sendKeysFromKeyboardToPasswordField(Keys.TAB).
                enterRepeatPassword(password5).sendKeysFromKeyboardToRepeatPasswordField(Keys.TAB);
        actualResult = signUpPage.getTextFromElementWithText("contains at least 8 characters");
        Assert.assertEquals(actualResult, expectedResult1, "Actual result --> " + actualResult);
    }

    @Test
    public void passwordCorrectValidation() {
        softAssert = new SoftAssert();
        signUpPage.enterPassword(passwordCorrect).sendKeysFromKeyboardToPasswordField(Keys.TAB).
                enterRepeatPassword(passwordCorrect).sendKeysFromKeyboardToRepeatPasswordField(Keys.TAB);
        actualResult = signUpPage.getTextFromElementWithText("contains at least 8 characters");
        softAssert.assertEquals(actualResult, expectedResult2, "Actual result --> " + actualResult);
        actualResult = signUpPage.getTextFromElementWithText("contains at least one special character");
        softAssert.assertEquals(actualResult, expectedResult2, "Actual result --> " + actualResult);
        actualResult = signUpPage.getTextFromElementWithText("contains at least one digit");
        softAssert.assertEquals(actualResult, expectedResult2, "Actual result --> " + actualResult);
        actualResult = signUpPage.getTextFromElementWithText("contains at least one upper character");
        softAssert.assertEquals(actualResult, expectedResult2, "Actual result --> " + actualResult);
        actualResult = signUpPage.getTextFromElementWithText("contains at least one lower character");
        softAssert.assertEquals(actualResult, expectedResult2, "Actual result --> " + actualResult);
        softAssert.assertAll();

    }
}
