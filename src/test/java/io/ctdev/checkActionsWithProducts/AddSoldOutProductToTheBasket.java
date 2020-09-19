package io.ctdev.checkActionsWithProducts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddSoldOutProductToTheBasket extends SetData {
    private String nameProduct = "OWASP Juice Shop Coaster (10pcs)";
    private String expectedResult = "We are out of stock! Sorry for the inconvenience.";

    @BeforeClass
    public void addProductToBasket() {
//        Actions act =  new Actions(driver);
//        act.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
//        act.moveToElement(driver.findElement(By.xpath("//button[@aria-label = 'Next page']"))).click().perform();
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label = 'Next page']"))).click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), '"+nameProduct+"')]/../../../div/child::button"))).click();

    }

    @Test
    public void validateError() {
        Assert.assertTrue(driver.findElements(By.xpath("//*[contains(text(), '" + expectedResult + "')]")).size() != 0);
    }
}
