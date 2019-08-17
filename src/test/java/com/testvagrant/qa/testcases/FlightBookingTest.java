package com.testvagrant.qa.testcases;

import com.testvagrant.qa.base.TestBase;
import com.testvagrant.qa.pages.ClearTripScreen;
import com.testvagrant.qa.pages.Locators;
import com.testvagrant.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FlightBookingTest extends TestBase {

    ClearTripScreen clearTripScreen;
    TestUtil testUtil;

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        clearTripScreen = new ClearTripScreen(driver);
    }

    @Test
    public void testThatResultsAppearForAOneWayJourney() {

        clearTripScreen.oneWayID.click();
        clearTripScreen.fromTag.clear();
        clearTripScreen.fromTag.sendKeys("Bangalore");
        waitForLoading();

        List<WebElement> originOptions = driver.findElement(By.id(Locators.ClearTripScreen.ORIGIN_OPTION)).findElements(By.tagName("li"));
        originOptions.get(0).click();

        clearTripScreen.toTag.clear();
        clearTripScreen.toTag.sendKeys("Delhi");
        waitForLoading();
        //select the first item from the destination auto complete list
        List<WebElement> destinationOptions = driver.findElement(By.id(Locators.ClearTripScreen.DESTINATION_OPTION)).findElements(By.tagName("li"));
        destinationOptions.get(0).click();

        clearTripScreen.datePicker.click();
        clearTripScreen.searchButton.click();
        waitForLoading();
        waitForAnElement();
        Assert.assertTrue(isFound(clearTripScreen.searchSummary));

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
