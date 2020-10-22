package io.ctdev.pages.signUp;

import io.ctdev.config.TestConfig;
import io.ctdev.pages.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends AbstractPage {

    private WebDriverWait driverWait;
    private WebDriver driver;

    private String elementByText = "//span[text() = '%s']/../mat-icon";
    private String elementByContainsText = "//*[contains(text(), '%s')]";



    private By idEmailControl = By.id("emailControl");
    private By slideToggle = By.xpath("//input [contains(@id , 'mat-slide-toggle')]/../../..");
    private By idPassword = By.id("passwordControl");
    private By idRepeatPassword = By.id("repeatPasswordControl");
    private By dialogWindowElement = By.cssSelector("[class*='close-dialog']");
    private By listOfSecurityQuestion = By.xpath("//mat-select[@aria-label = 'Selection list for the security question']");
    private By registerButton = By.id("registerButton");
    private By fieldToAnswerSecurityQuestion = By.id("securityAnswerControl");
    private By findEmailError = By.xpath("//input [@id = 'emailControl']/" +
            "ancestor::div[contains(@class,'mat-form-field')]//mat-error");
    private By findPasswordError = By.xpath("//input [@id = 'passwordControl']/" +
            "ancestor::div[contains(@class,'mat-form-field')]//mat-error");
    private By findRepeatPasswordError = By.xpath("//input [@id = 'repeatPasswordControl']/" +
            "ancestor::div[contains(@class,'mat-form-field')]//mat-error");


    public SignUpPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver,10);
    }

    @Override
    public void openPage() {driver.get(TestConfig.cfg.webSite() + "#/register");}

    @Step ("Enter User Email")
    public SignUpPage enterEmail (String email){
        System.out.println("Enter Email: " + email);
        driver.findElement(idEmailControl).sendKeys(email);
        return this;
    }
    @Step ("Enter User Password")
    public SignUpPage enterPassword (String password){
        System.out.println("Enter Password: " + password);
        driver.findElement(idPassword).sendKeys(password);
        return this;
    }
    @Step("Enter repeat User Password")
    public SignUpPage enterRepeatPassword (String repeatPassword){
        System.out.println("Enter repeat password: " + repeatPassword);
        driver.findElement(idRepeatPassword).sendKeys(repeatPassword);
        return this;
    }
    @Step ("Enter security answer")
    public SignUpPage enterSecurityAnswer (String answer){
        System.out.println("Enter security answer: " + answer);
        driver.findElement(fieldToAnswerSecurityQuestion).sendKeys(answer);
        return this;
    }
    @Step ("Enter registration button")
    public SignUpPage enterRegisterButton (){
        System.out.println("Enter register button");
        driver.findElement(registerButton).click();
        return this;
    }
    @Step ("Select security question")
    public SignUpPage selectSecurityQuestion (String answer){
        System.out.println("Select security answer: " + answer);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(elementByContainsText, answer)))).click();
        return this;
    }
    @Step ("Send key from keyboard to Email field")
    public SignUpPage sendKeysFromKeyboardToEmailField (Keys key) {
        System.out.println("Push key from keyboard ->" + key);
        driver.findElement(idEmailControl).sendKeys(key);
        return this;
    }
    @Step ("Send key from keyboard to Password field")
    public SignUpPage sendKeysFromKeyboardToPasswordField (Keys key) {
        System.out.println("Push Tab");
        driver.findElement(idPassword).sendKeys(key);
        return this;
    }
    @Step ("Send key from keyboard to repeat Password field")
    public SignUpPage sendKeysFromKeyboardToRepeatPasswordField (Keys key) {
        System.out.println("Push Tab");
        driver.findElement(idRepeatPassword).sendKeys(key);
        return this;
    }
    @Step ("Open slide password advice")
    public SignUpPage openSlidePasswordAdvice () {
        System.out.println("Click slider show password advice");
        driver.findElement(slideToggle).click();
        return this;
    }
    @Step ("Open list of security questions")
    public SignUpPage openListOfSecurityQuestion () {
        System.out.println("Open list of security questions");
        //driver.findElement(listOfSecurityQuestion).click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(listOfSecurityQuestion)).click();
        return this;
    }
    @Step ("Get Email error")
    public String getCurrentEmailError() {
        System.out.println("Get Email Error");
        WebElement errorElement = driverWait.until(ExpectedConditions.visibilityOfElementLocated(findEmailError));
        return errorElement.getText().trim();
    }
    @Step ("Get Password error")
    public String getCurrentPasswordError() {
        System.out.println("Get Password Error");
        WebElement errorElement = driverWait.until(ExpectedConditions.visibilityOfElementLocated(findPasswordError));
        return errorElement.getText().trim();
    }
    @Step ("Get repeat Password error")
    public String getCurrentRepeatPasswordError() {
        System.out.println("Get Password Error");
        WebElement errorElement = driverWait.until(ExpectedConditions.visibilityOfElementLocated(findRepeatPasswordError));
        return errorElement.getText().trim();
    }
    @Step ("Clear Email field")
    public void clearEmailField () {
        System.out.println("Clear Email");
        driver.findElement(idEmailControl).clear();
    }
    @Step ("Clear Password field")
    public SignUpPage clearPasswordField () {
        System.out.println("Clear Password");
        driver.findElement(idPassword).clear();
        return this;
    }
    @Step ("Clear repeat Password field")
    public SignUpPage clearRepeatPasswordField () {
        System.out.println("Clear repeat password");
        driver.findElement(idRepeatPassword).clear();
        return this;
    }
    @Step ("Close dialog window")
    public SignUpPage closeDialogWindow () {
        System.out.println("Close dialog window");
        driver.findElement(dialogWindowElement).click();
        return this;
    }
    @Step ("Search span element by text")
    public SignUpPage searchSpanElementByText(String text) {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(elementByText, text))));
        return this;
    }
    @Step ("Get text from element")
    public String getTextFromElementWithText (String text) {
       WebElement element =  driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(elementByText, text))));
       return element.getAttribute("innerText");
    }
    @Step ("Get contain text from element")
    public String getTextFromElementWithContainText (String text) {
       WebElement element =  driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(elementByContainsText, text))));
       return element.getAttribute("innerText");
    }
}
