package io.ctdev.checkActionsWithProducts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckActualInformationAboutProduct extends SetData {

    private String nameOfProduct = "Green Smoothie";
    private String expectedName = nameOfProduct;
    private String expectedDescription ="Looks poisonous but is actually very good for your health! Made from green cabbage, spinach, kiwi and grass.";
    private String expectedPrice = "1.99¤";
    private String actualTextResult;
    private String [] actualResult;

    @BeforeClass
    public void clickProduct () {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'"+nameOfProduct+"')]"))).click();
        actualTextResult = driver.findElement(By.xpath("//mat-dialog-container")).getAttribute("innerText");
        actualResult = actualTextResult.split("\n");
    }
    @Test
    public void checkProductPriceInformation () {
       Assert.assertEquals(actualResult[5],expectedPrice, "Incorrect price of product -> " + actualResult[5]);
    }
    @Test
    public void checkProductDescriptionInformation () {
       Assert.assertEquals(actualResult[1],expectedDescription, "Incorrect content of product -> " + actualResult[1]);
    }
    @Test
    public void checkProductNameInformation () {
       Assert.assertEquals(actualResult[0],expectedName, "Incorrect name of product -> " + actualResult[0]);
    }


}
