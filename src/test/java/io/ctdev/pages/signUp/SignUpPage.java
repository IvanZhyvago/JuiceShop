package io.ctdev.pages.signUp;

import io.ctdev.config.TestConfig;
import io.ctdev.pages.AbstractPage;
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

    public SignUpPage enterEmail (String email){
        System.out.println("Enter Email: " + email);
        driver.findElement(idEmailControl).sendKeys(email);
        return this;
    }
    public SignUpPage enterPassword (String password){
        System.out.println("Enter Password: " + password);
        driver.findElement(idPassword).sendKeys(password);
        return this;
    }

    public SignUpPage enterRepeatPassword (String repeatPassword){
        System.out.println("Enter repeat password: " + repeatPassword);
        driver.findElement(idRepeatPassword).sendKeys(repeatPassword);
        return this;
    }
    public SignUpPage enterSecurityAnswer (String answer){
        System.out.println("Enter security answer: " + answer);
        driver.findElement(fieldToAnswerSecurityQuestion).sendKeys(answer);
        return this;
    }

    public SignUpPage enterRegisterButton (){
        System.out.println("Enter register button");
        driver.findElement(registerButton).click();
        return this;
    }

    public SignUpPage selectSecurityQuestion (String answer){
        System.out.println("Select security answer: " + answer);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(elementByContainsText, answer)))).click();
        return this;
    }

    public SignUpPage sendKeysFromKeyboardToEmailField (Keys key) {
        System.out.println("Push Tab");
        driver.findElement(idEmailControl).sendKeys(key);
        return this;
    }
    public SignUpPage sendKeysFromKeyboardToPasswordField (Keys key) {
        System.out.println("Push Tab");
        driver.findElement(idPassword).sendKeys(key);
        return this;
    }
    public SignUpPage sendKeysFromKeyboardToRepeatPasswordField (Keys key) {
        System.out.println("Push Tab");
        driver.findElement(idRepeatPassword).sendKeys(key);
        return this;
    }

    public SignUpPage openSlidePasswordAdvice () {
        System.out.println("Click slider show password advice");
        driver.findElement(slideToggle).click();
        return this;
    }
    public SignUpPage openListOfSecurityQuestion () {
        System.out.println("Open list of security questions");
        //driver.findElement(listOfSecurityQuestion).click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(listOfSecurityQuestion)).click();
        return this;
    }

    public String getCurrentEmailError() {
        System.out.println("Get Email Error");
        WebElement errorElement = driverWait.until(ExpectedConditions.visibilityOfElementLocated(findEmailError));
        return errorElement.getText().trim();
    }

    public String getCurrentPasswordError() {
        System.out.println("Get Password Error");
        WebElement errorElement = driverWait.until(ExpectedConditions.visibilityOfElementLocated(findPasswordError));
        return errorElement.getText().trim();
    }
    public String getCurrentRepeatPasswordError() {
        System.out.println("Get Password Error");
        WebElement errorElement = driverWait.until(ExpectedConditions.visibilityOfElementLocated(findRepeatPasswordError));
        return errorElement.getText().trim();
    }

    public void clearEmailField () {
        System.out.println("Clear Email");
        driver.findElement(idEmailControl).clear();
    }

    public SignUpPage clearPasswordField () {
        System.out.println("Clear Password");
        driver.findElement(idPassword).clear();
        return this;
    }

    public SignUpPage clearRepeatPasswordField () {
        System.out.println("Clear repeat password");
        driver.findElement(idRepeatPassword).clear();
        return this;
    }

    public SignUpPage closeDialogWindow () {
        System.out.println("Close dialog window");
        driver.findElement(dialogWindowElement).click();
        return this;
    }

    public SignUpPage searchSpanElementByText(String text) {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(elementByText, text))));
        return this;
    }

    public String getTextFromElementWithText (String text) {
       WebElement element =  driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(elementByText, text))));
       return element.getAttribute("innerText");
    }
    public String getTextFromElementWithContainText (String text) {
       WebElement element =  driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(elementByContainsText, text))));
       return element.getAttribute("innerText");
    }
}
