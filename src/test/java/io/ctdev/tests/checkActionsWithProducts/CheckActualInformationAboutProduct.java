package io.ctdev.tests.checkActionsWithProducts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckActualInformationAboutProduct extends SetData  {

    private SoftAssert softAssert;
    private String nameOfProduct = "Green Smoothie";
    private String expectedName = nameOfProduct;
    private String expectedDescription = "Looks poisonous but is actually very good for your health! Made from green cabbage, spinach, kiwi and grass.";
    private String expectedPrice = "1.99¤";
    private String actualTextResult;
    private String[] actualResult;

    @BeforeClass
    public void clickProduct() {
        softAssert = new SoftAssert();
    }

    @Test
    public void checkProductGreenSmoothieInformation() {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'" + nameOfProduct + "')]"))).click();
        actualTextResult = driver.findElement(By.xpath("//mat-dialog-container")).getAttribute("innerText");
        actualResult = actualTextResult.split("\n");
        softAssert.assertEquals(actualResult[5], expectedPrice, "Incorrect price of product -> " + actualResult[5]);
        softAssert.assertEquals(actualResult[1], expectedDescription, "Incorrect content of product -> " + actualResult[1]);
        softAssert.assertEquals(actualResult[0], expectedName, "Incorrect name of product -> " + actualResult[0]);
        softAssert.assertAll();
    }
}
