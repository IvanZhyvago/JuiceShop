package io.ctdev.tests.sign_up;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class PasswordValidationTest extends SetData {

    private String actualResult;
    private String expectedResultProvide = "Please provide a password.";
    private String expectedResultCharactersLong = "Password must be 5-20 characters long.";
    private String expectedResultNotMatch = "Passwords do not match";

    private String password1 = " ";
    private String password2 = "qwer";
    private String password3 = "Qwerty123!12$";

    @BeforeMethod
    public void clearValues() {
        signUpPage.clearPasswordField().clearRepeatPasswordField();
    }
    @Test
    public void passwordEmptyValidation () {

        signUpPage.enterPassword(password1).sendKeysFromKeyboardToPasswordField(Keys.BACK_SPACE).
                sendKeysFromKeyboardToPasswordField(Keys.TAB);
        actualResult = signUpPage.getCurrentPasswordError();
        Assert.assertEquals(actualResult, expectedResultProvide, "Password validation Fail -> " + password1);
    }

    @Test
    public void passwordContainsAtLeastFourCharactersValidation () {
        signUpPage.enterPassword(password2).sendKeysFromKeyboardToPasswordField(Keys.TAB);
        actualResult = signUpPage.getCurrentPasswordError();
        Assert.assertEquals(actualResult, expectedResultCharactersLong, "Password validation Fail -> " + password2);
    }

    @Test
    public void passwordDoNotMatchValidation () {
        signUpPage.enterPassword(password3).sendKeysFromKeyboardToPasswordField(Keys.TAB);
        signUpPage.enterRepeatPassword("errorPassword").sendKeysFromKeyboardToRepeatPasswordField(Keys.TAB);
        actualResult = signUpPage.getCurrentRepeatPasswordError();
        Assert.assertEquals(actualResult, expectedResultNotMatch, "Password validation Fail -> " + password3);
    }
}
