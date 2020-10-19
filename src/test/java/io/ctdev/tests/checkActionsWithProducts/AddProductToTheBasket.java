package io.ctdev.tests.checkActionsWithProducts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddProductToTheBasket extends SetData {

    private SoftAssert softAssert;
    private String nameProduct = "Green Smoothie";
    private String expectedName = nameProduct;
    private String expectedTotal = "1";
    private String expectedPrice = "1.99¤";
    private String actualTextResult;
    private String [] actualResult;

    @BeforeClass
    public void addProductToBasket() {
        softAssert = new SoftAssert();
    }

    @Test
    public void verifyInformationAboutGreenSmoothieInBasket() {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), '" + nameProduct + "')]/../../../div/child::button"))).click();
        driver.findElement(By.xpath("//button[@aria-label='Show the shopping cart']")).click();
        actualTextResult = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-row"))).getAttribute("innerText");
        actualResult = actualTextResult.split("\n");
        softAssert.assertEquals(actualResult[0], expectedName, "Incorrect name of product -> " + actualResult[0]);
        softAssert.assertEquals(actualResult[1], expectedTotal, "Incorrect total of product -> " + actualResult[1]);
        softAssert.assertEquals(actualResult[2], expectedPrice, "Incorrect price of product -> " + actualResult[2]);
        softAssert.assertAll();
    }
}