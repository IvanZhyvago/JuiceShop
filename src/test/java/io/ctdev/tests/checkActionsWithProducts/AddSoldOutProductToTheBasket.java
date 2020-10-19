package io.ctdev.tests.checkActionsWithProducts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddSoldOutProductToTheBasket extends SetData {
    private String nameProduct = "OWASP Juice Shop Coaster (10pcs)";
    private String expectedResult = "We are out of stock! Sorry for the inconvenience.";

    @Test
    public void validateError() {
        //        Actions act =  new Actions(driver);
//        act.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
//        act.moveToElement(driver.findElement(By.xpath("//button[@aria-label = 'Next page']"))).click().perform();
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label = 'Next page']"))).click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), '"+nameProduct+"')]/../../../div/child::button"))).click();
        Assert.assertTrue(driver.findElements(By.xpath("//*[contains(text(), '" + expectedResult + "')]")).size() != 0);
    }
}
