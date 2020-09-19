package io.ctdev.sign_up;

import io.ctdev.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;


public class PasswordValidationTest extends SetData {

    private String actualResult;
    private String expectedResultProvide = "Please provide a password.";
    private String expectedResultCharactersLong = "Password must be 5-20 characters long.";
    private String expectedResultNotMatch = "Passwords do not match";

    private String password1 = " ";
    private String password2 = "qwer";
    private String password3 = "Qwerty123!12$";

    private String idPassword = "passwordControl";
    private String idRepeatPassword = "repeatPasswordControl";

    private String xpathPasswordControl = "//input [@id = 'passwordControl']/ancestor::div[contains(@class,'mat-form-field')]//mat-error";
    private String xpathRepeatPasswordControl = "//input [@id = 'repeatPasswordControl']/ancestor::div[contains(@class,'mat-form-field')]//mat-error";

    @BeforeMethod
    public void clearValues() {
        driver.findElement(By.id(idPassword)).clear();
        driver.findElement(By.id(idRepeatPassword)).clear();
    }
    @Test
    public void passwordEmptyValidation () {
        driver.findElement(By.id(idPassword)).sendKeys(password1);
        driver.findElement(By.id(idPassword)).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.id(idPassword)).sendKeys(Keys.TAB);
        actualResult = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathPasswordControl))).getText();
        Assert.assertEquals(actualResult, expectedResultProvide, "Password validation Fail -> " + password1);
    }

    @Test
    public void passwordContainsAtLeastFourCharactersValidation () {
        driver.findElement(By.id(idPassword)).sendKeys(password2);
        driver.findElement(By.id(idPassword)).sendKeys(Keys.TAB);
        actualResult = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathPasswordControl))).getText();
        Assert.assertEquals(actualResult, expectedResultCharactersLong, "Password validation Fail -> " + password2);
    }

    @Test
    public void passwordDoNotMatchValidation () throws InterruptedException {
        driver.findElement(By.id(idPassword)).sendKeys(password2);
        driver.findElement(By.id(idPassword)).sendKeys(Keys.TAB);
        driver.findElement(By.id(idRepeatPassword)).sendKeys("errorPassword");
        driver.findElement(By.id(idRepeatPassword)).sendKeys(Keys.TAB);
        Thread.sleep(2000);
        actualResult = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathRepeatPasswordControl))).getText();
        Assert.assertEquals(actualResult, expectedResultNotMatch, "Password validation Fail -> " + password3);
    }
}
