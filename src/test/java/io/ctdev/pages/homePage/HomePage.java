package io.ctdev.pages.homePage;

import io.ctdev.config.TestConfig;
import io.ctdev.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

    private WebDriverWait driverWait;
    private WebDriver driver;

    private By dialogWindowElement = By.cssSelector("[class*='close-dialog']");
    private By navBarAccountElement = By.id("navbarAccount");
    private By loginButtonElement = By.id("navbarLoginButton");




    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, TIME_OUT);
    }

    @Override
    public void openPage() {driver.get(TestConfig.cfg.webSite());}

    public HomePage closeDialogWindow () {
        System.out.println("Close dialog window");
        driver.findElement(dialogWindowElement).click();
        return this;
    }

    public HomePage clickOnLoginButton() {
        System.out.println("Click login button");
        driver.findElement(loginButtonElement).click();
        return this;
    }

    public HomePage clickOnAccountButton() {
        System.out.println("Click Account button");
        driver.findElement(navBarAccountElement).click();
        return this;
    }

}
