package io.ctdev.sign_up;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


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

    private String idPassword = "passwordControl";
    private String idRepeatPassword = "repeatPasswordControl";


    public void passwordAdviceTest(String password){
        driver.findElement(By.id(idPassword)).sendKeys(password);
        driver.findElement(By.id(idPassword)).sendKeys(Keys.TAB);
        driver.findElement(By.id(idRepeatPassword)).sendKeys(password);
        driver.findElement(By.id(idRepeatPassword)).sendKeys(Keys.TAB);

    }

    @BeforeMethod
    public void clearValues() {
        driver.findElement(By.id("passwordControl")).clear();
        driver.findElement(By.id("repeatPasswordControl")).clear();
    }

    @BeforeClass
    public void openSlide () {
        driver.findElement(By.xpath("//input [contains(@id , 'mat-slide-toggle')]/../../..")).click();
        System.out.println("Click slider show password advice");
    }


    @Test
    public void passwordAdviceOneLowerCharacterValidation () {
        passwordAdviceTest(password1);
        actualResult = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'contains at least one lower character']/../mat-icon"))).getAttribute("innerText");
        Assert.assertEquals(actualResult, expectedResult1, "Actual result --> " + actualResult);
    }

    @Test
    public void passwordAdviceOneUpperCharacterValidation () {
        passwordAdviceTest(password2);
        actualResult = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'contains at least one upper character']/../mat-icon"))).getAttribute("innerText");
        Assert.assertEquals(actualResult, expectedResult1, "Actual result --> " + actualResult);
    }

    @Test
    public void passwordAdviceOneDigitValidation () {
        passwordAdviceTest(password3);
        actualResult = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'contains at least one digit']/../mat-icon"))).getAttribute("innerText");
        Assert.assertEquals(actualResult, expectedResult1, "Actual result --> " + actualResult);
    }

    @Test
    public void passwordAdviceOneSpecialValidation () {
        passwordAdviceTest(password4);
        actualResult = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'contains at least one special character']/../mat-icon"))).getAttribute("innerText");
        Assert.assertEquals(actualResult, expectedResult1, "Actual result --> " + actualResult);
    }

    @Test
    public void passwordEightCharactersValidation () {
        passwordAdviceTest(password5);
        actualResult = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'contains at least 8 characters']/../mat-icon"))).getAttribute("innerText");
        Assert.assertEquals(actualResult, expectedResult1, "Actual result --> " + actualResult);
    }

    @Test
    public void passwordCorrectValidation () {
        softAssert = new SoftAssert();
        passwordAdviceTest(passwordCorrect);
        actualResult = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'contains at least 8 characters']/../mat-icon"))).getAttribute("innerText");
        softAssert.assertEquals(actualResult, expectedResult2, "Actual result --> " + actualResult);
        actualResult = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'contains at least one special character']/../mat-icon"))).getAttribute("innerText");
        softAssert.assertEquals(actualResult, expectedResult2, "Actual result --> " + actualResult);
        actualResult = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'contains at least one digit']/../mat-icon"))).getAttribute("innerText");
        softAssert.assertEquals(actualResult, expectedResult2, "Actual result --> " + actualResult);
        actualResult = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'contains at least one upper character']/../mat-icon"))).getAttribute("innerText");
        softAssert.assertEquals(actualResult, expectedResult2, "Actual result --> " + actualResult);
        actualResult = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'contains at least one lower character']/../mat-icon"))).getAttribute("innerText");
        softAssert.assertEquals(actualResult, expectedResult2, "Actual result --> " + actualResult);
        softAssert.assertAll();
    }
}
