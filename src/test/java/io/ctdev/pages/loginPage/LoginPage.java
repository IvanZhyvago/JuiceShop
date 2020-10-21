package io.ctdev.pages.loginPage;

import io.ctdev.config.TestConfig;
import io.ctdev.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {

    private WebDriverWait driverWait;

    private By customerLinkElement = By.id("newCustomerLink");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driverWait = new WebDriverWait(driver, TIME_OUT);
    }

    @Override
    public void openPage() { driver.get(TestConfig.cfg.webSite() + "#/login");}

    public LoginPage clickNotYetCustomerButton () {
        System.out.println("Click not yet a customer");
        driver.findElement(customerLinkElement).click();
        return this;
    }
}
