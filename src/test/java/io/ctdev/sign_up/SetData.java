package io.ctdev.sign_up;

import io.ctdev.config.TestConfig;
import io.ctdev.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.util.concurrent.TimeUnit;


public class SetData {

    protected WebDriver driver;
    protected WebDriverWait driverWait;

    @BeforeSuite
    public void setUpToRegisterPage () {
        driver = WebDriverSingleton.getDriver();
        driverWait =  new WebDriverWait(driver,10);
        driver.get(TestConfig.cfg.webSite());
        driver.findElement(By.cssSelector("[class*='close-dialog']")).click();
        driver.findElement(By.id("navbarAccount")).click();
        System.out.println("Click Account button");
        driver.findElement(By.id("navbarLoginButton")).click();
        System.out.println("Click login button");
        driver.findElement(By.id("newCustomerLink")).click();
        System.out.println("Click register button");
    }

    @AfterSuite
    public void afterSuite () {
        WebDriverSingleton.closeDriver();
    }
}
