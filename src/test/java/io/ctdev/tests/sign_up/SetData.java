package io.ctdev.tests.sign_up;

import io.ctdev.driver.WebDriverSingleton;
import io.ctdev.pages.homePage.HomePage;
import io.ctdev.pages.loginPage.LoginPage;
import io.ctdev.pages.signUp.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class SetData {

    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected SignUpPage signUpPage;



    @BeforeSuite
    public void setUpToRegisterPage () {
        driver = WebDriverSingleton.getDriver();
        driverWait =  new WebDriverWait(driver,10);
        homePage = new HomePage (driver);
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);

        signUpPage.openPage();
        signUpPage.closeDialogWindow();

//        homePage.openPage();
//        homePage.closeDialogWindow().clickOnAccountButton().clickOnLoginButton();
//        loginPage.clickNotYetCustomerButton();



    }

    @AfterSuite
    public void afterSuite () {
        WebDriverSingleton.closeDriver();
    }

    }

