package io.ctdev.sign_up;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmailValidationTest extends SetData {
    private String actualResult;
    private String expectedResult = "Email address is not valid.";
    private String emailAddress1 = "";
    private String emailAddress2 = "@gmail.com";
    private String emailAddress3 = "Иван@gmail.com";
    private String emailAddress4 = "smth@@rambler.ru";
    private String emailAddress5 = "sa_*212!^&*)@aa.com";
    private String emailAddress6 = "wizdmak";
    private String idEmailControl = "emailControl";

    private String xpathFindError = "//input [@id = 'emailControl']/ancestor::div[contains(@class,'mat-form-field')]//mat-error";


    @BeforeMethod
    public void clearFields() {
        driver.findElement(By.id(idEmailControl)).clear();
    }

    @Test
    public void checkEmptyEmailValidation() {
        driver.findElement(By.id(idEmailControl)).sendKeys(emailAddress1);
        driver.findElement(By.id(idEmailControl)).sendKeys(Keys.TAB);
        actualResult = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathFindError))).getText();
        Assert.assertEquals(actualResult, expectedResult, "Email validation Fail -> " + emailAddress1);
    }

    @Test()
    public void checkOnlyRightPartEmailValidation() {
        driver.findElement(By.id(idEmailControl)).sendKeys(emailAddress2);
        driver.findElement(By.id(idEmailControl)).sendKeys(Keys.TAB);
        actualResult = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathFindError))).getText();;
        Assert.assertEquals(actualResult, expectedResult, "Email validation Fail -> " + emailAddress2);
    }

    @Test()
    public void checkCyrillicEmailValidation() {
        driver.findElement(By.id(idEmailControl)).sendKeys(emailAddress3);
        driver.findElement(By.id(idEmailControl)).sendKeys(Keys.TAB);
        actualResult = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathFindError))).getText();
        Assert.assertEquals(actualResult, expectedResult, "Email validation Fail -> " + emailAddress3);
    }

    @Test()
    public void checkDoubleAtEmailValidation() {
        driver.findElement(By.id(idEmailControl)).sendKeys(emailAddress4);
        driver.findElement(By.id(idEmailControl)).sendKeys(Keys.TAB);
        actualResult = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathFindError))).getText();
        Assert.assertEquals(actualResult, expectedResult, "Email validation Fail -> " + emailAddress4);
    }

    @Test()
    public void checkSpecialSymbolsEmailValidation() {
        driver.findElement(By.id(idEmailControl)).sendKeys(emailAddress5);
        driver.findElement(By.id(idEmailControl)).sendKeys(Keys.TAB);
        actualResult = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathFindError))).getText();
        Assert.assertEquals(actualResult, expectedResult, "Email validation Fail -> " + emailAddress5);
    }

    @Test()
    public void checkOnlyFirstPartEmailValidation() throws InterruptedException {
        driver.findElement(By.id(idEmailControl)).sendKeys(emailAddress6);
        driver.findElement(By.id(idEmailControl)).sendKeys(Keys.TAB);
        actualResult = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathFindError))).getText();
        Assert.assertEquals(actualResult, expectedResult, "Email validation Fail -> " + emailAddress6);
    }

}
