package io.ctdev.tests.sign_up;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmailValidationTest extends SetData {
    private String actualResult;
    private String expectedResult = "Email address is not valid.";
    private String expectedResult2 = "Please provide an email address.";
    private String emailAddress1 = "";
    private String emailAddress2 = "@gmail.com";
    private String emailAddress3 = "Иван@gmail.com";
    private String emailAddress4 = "smth@@rambler.ru";
    private String emailAddress5 = "sa_*212!^&*)@aa.com";
    private String emailAddress6 = "wizdmak";

    @BeforeMethod
    public void clearFields() {
        signUpPage.clearEmailField();
    }

    @Test
    public void checkEmptyEmailValidation() {
        signUpPage.enterEmail(emailAddress1).sendKeysFromKeyboardToEmailField(Keys.TAB);
        actualResult = signUpPage.getCurrentEmailError();
        Assert.assertEquals(actualResult, expectedResult, "Email validation Fail -> " + emailAddress1);
    }

    @Test()
    public void checkOnlyRightPartEmailValidation() {
        signUpPage.enterEmail(emailAddress2).sendKeysFromKeyboardToEmailField(Keys.TAB);
        actualResult = signUpPage.getCurrentEmailError();
        Assert.assertEquals(actualResult, expectedResult, "Email validation Fail -> " + emailAddress2);
    }

    @Test()
    public void checkCyrillicEmailValidation() {
        signUpPage.enterEmail(emailAddress3).sendKeysFromKeyboardToEmailField(Keys.TAB);
        actualResult = signUpPage.getCurrentEmailError();
        Assert.assertEquals(actualResult, expectedResult, "Email validation Fail -> " + emailAddress3);
    }

    @Test()
    public void checkDoubleAtEmailValidation() {
        signUpPage.enterEmail(emailAddress4).sendKeysFromKeyboardToEmailField(Keys.TAB);
        actualResult = signUpPage.getCurrentEmailError();
        Assert.assertEquals(actualResult, expectedResult, "Email validation Fail -> " + emailAddress4);
    }

    @Test()
    public void checkSpecialSymbolsEmailValidation() {
        signUpPage.enterEmail(emailAddress5).sendKeysFromKeyboardToEmailField(Keys.TAB);
        actualResult = signUpPage.getCurrentEmailError();
        Assert.assertEquals(actualResult, expectedResult, "Email validation Fail -> " + emailAddress5);
    }

    @Test()
    public void checkOnlyFirstPartEmailValidation() {
        signUpPage.enterEmail(emailAddress6).sendKeysFromKeyboardToEmailField(Keys.TAB);
        actualResult = signUpPage.getCurrentEmailError();
        Assert.assertEquals(actualResult, expectedResult, "Email validation Fail -> " + emailAddress6);
    }

}
