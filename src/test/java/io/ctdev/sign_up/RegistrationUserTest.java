package io.ctdev.sign_up;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Random;

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
        driver.findElement(By.id("navbarAccount")).click();
        System.out.println("Click Account button");
        driver.findElement(By.id("navbarLoginButton")).click();
        System.out.println("Click login button");
        driver.findElement(By.id("newCustomerLink")).click();
        System.out.println("Click register button");
        driver.findElement(By.id("emailControl")).sendKeys(emailStart+randomNumberToLogin+emailEnd);
        System.out.println("Enter email -> "+ emailStart+randomNumberToLogin+emailEnd);
        driver.findElement(By.id("passwordControl")).sendKeys(password);
        System.out.println("Enter password -> "+ password);
        driver.findElement(By.id("repeatPasswordControl")).sendKeys(password);
        System.out.println("Repeat password -> "+ password);
        driver.findElement(By.xpath("//input [contains(@id , 'mat-slide-toggle')]/../../..")).click();
        System.out.println("Click slider show password advice");
        act.moveToElement(driver.findElement(By.xpath("//mat-select[@aria-label = 'Selection list for the security question']"))).click().perform();
        //driver.findElement(By.xpath("//mat-select[@id = 'mat-select-1']/div")).click();
        System.out.println("User click to listbox");
        driver.findElement(By.xpath("//span[contains(text() , 'Number of one of your customer or ID cards?')]")).click();
        System.out.println("Select question");
        driver.findElement(By.id("securityAnswerControl")).sendKeys(answer);
        System.out.println("Enter answer");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registerButton"))).click();
        System.out.println("Click Register");
        actualResult = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Registration completed successfully. You can now log in.')]"))).getAttribute("innerText");
        Assert.assertEquals(actualResult,expectedResult, "Registration failed");
    }

}
