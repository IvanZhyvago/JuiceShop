package io.ctdev.checkActionsWithProducts;

import io.ctdev.config.TestConfig;
import io.ctdev.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class SetData {
    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected String userEmail = "ivan.zhyvago@ctdev.io";
    protected String userPassword = "Qwerty1234&";

    @BeforeSuite
    public void setUpToLoginUser () {
        driver = WebDriverSingleton.getDriver();
        driverWait = new WebDriverWait(driver,10);
        driver.get(TestConfig.cfg.webSite());
        driver.findElement(By.cssSelector("[class*='close-dialog']")).click();
        driver.findElement(By.id("navbarAccount")).click();
        System.out.println("Click Account button");
        driver.findElement(By.xpath("//a[@aria-label = 'dismiss cookie message']")).click();
        System.out.println("Dismiss cookies");
        driver.findElement(By.id("navbarLoginButton")).click();
        System.out.println("Click login button");
        driver.findElement(By.id("email")).sendKeys(userEmail);
        System.out.println("Enter Email");
        driver.findElement(By.id("password")).sendKeys(userPassword);
        System.out.println("Enter password");
        driver.findElement(By.id("loginButton")).click();
        System.out.println("Click login button");


    }

    @AfterSuite
    public void afterSuite () {
        WebDriverSingleton.closeDriver();
    }
}

