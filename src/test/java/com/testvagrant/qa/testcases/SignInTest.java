package com.testvagrant.qa.testcases;

import com.testvagrant.qa.base.TestBase;
import com.testvagrant.qa.pages.ClearTripScreen;
import com.testvagrant.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTest extends TestBase {
    ClearTripScreen clearTripScreen;
    TestUtil testUtil;

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        clearTripScreen = new ClearTripScreen(driver);
    }

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        clearTripScreen.yourTrip.click();
        clearTripScreen.signInId.click();
        driver.switchTo().frame("modal_window");
        waitForLoading();
        waitForAnElement();
        clearTripScreen.signInButton.click();
        String errors1 = clearTripScreen.errorsLabel.getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
