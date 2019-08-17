package com.testvagrant.qa.testcases;

import com.testvagrant.qa.base.TestBase;
import com.testvagrant.qa.pages.ClearTripScreen;
import com.testvagrant.qa.util.TestUtil;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HotelBookingTest extends TestBase {

    ClearTripScreen clearTripScreen;
    TestUtil testUtil;

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        clearTripScreen = new ClearTripScreen(driver);
    }

    @Test
    public void shouldBeAbleToSearchForHotels() {
        Assert.assertTrue(isFound(clearTripScreen.hotelsLinkText),
                "Check the hotels tag is found");
        clearTripScreen.hotelsLinkText.click();

        Assert.assertTrue(isFound(clearTripScreen.tags),
                "Check the hotels tag is found");
        clearTripScreen.tags.sendKeys("Indiranagar, Bangalore");

        Assert.assertTrue(isFound(clearTripScreen.travellersOnHome),
                "Check the hotels travellers number is found");
        new Select(clearTripScreen.travellersOnHome).selectByVisibleText("1 room, 2 adults");

        Assert.assertTrue(isFound(clearTripScreen.searchHotelsButton),
                "Check the search hotels button is found");
        clearTripScreen.searchHotelsButton.click();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
