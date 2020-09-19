package io.ctdev.checkActionsWithProducts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddProductToTheBasket extends SetData {

    private String nameProduct = "Green Smoothie";
    private String expectedName = nameProduct;
    private String expectedTotal = "1";
    private String expectedPrice = "1.99¤";
    private String actualTextResult;
    private String [] actualResult;

    @BeforeClass
    public void addProductToBasket() {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), '"+nameProduct+"')]/../../../div/child::button"))).click();
        driver.findElement(By.xpath("//button[@aria-label='Show the shopping cart']")).click();
        actualTextResult = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-row"))).getAttribute("innerText");
        actualResult = actualTextResult.split("\n");
    }
    @Test
    public void verifyNameInBasket () {
        Assert.assertEquals(actualResult[0],expectedName, "Incorrect name of product -> " + actualResult[0]);
    }
    @Test
    public void verifyTotalInBasket () {
        Assert.assertEquals(actualResult[1],expectedTotal, "Incorrect total of product -> " + actualResult[1]);
    }
    @Test
    public void verifyPriceInBasket () {
        Assert.assertEquals(actualResult[2],expectedPrice, "Incorrect price of product -> " + actualResult[2]);
    }
}
