package com.testvagrant.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Facebook Sign In Screen locators
 */
public class ClearTripScreen {

    public ClearTripScreen(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.LINK_TEXT, using = Locators.ClearTripScreen.YOUR_TRIP_LINKTEXT)
    public WebElement yourTrip;

    @FindBy(how = How.ID, using = Locators.ClearTripScreen.SIGN_IN_ID)
    public WebElement signInId;

    @FindBy(how = How.XPATH, using = Locators.ClearTripScreen.SIGN_IN_BUTTON)
    public WebElement signInButton;

    @FindBy(how = How.ID, using = Locators.ClearTripScreen.ERRORS_LABEL)
    public WebElement errorsLabel;

    @FindBy(how = How.ID, using = Locators.ClearTripScreen.ONE_WAY_ID)
    public WebElement oneWayID;

    @FindBy(how = How.ID, using = Locators.ClearTripScreen.FROM_TAG)
    public WebElement fromTag;

    @FindBy(how = How.ID, using = Locators.ClearTripScreen.ORIGIN_OPTION)
    public WebElement originOption;

    @FindBy(how = How.ID, using = Locators.ClearTripScreen.TO_TAG)
    public WebElement toTag;

    @FindBy(how = How.ID, using = Locators.ClearTripScreen.DESTINATION_OPTION)
    public WebElement destinationOption;

    @FindBy(how = How.XPATH, using = Locators.ClearTripScreen.DATE_PICKER)
    public WebElement datePicker;

    @FindBy(how = How.ID, using = Locators.ClearTripScreen.SEARCH_BUTTON)
    public WebElement searchButton;

    @FindBy(how = How.XPATH, using = Locators.ClearTripScreen.SEARCH_SUMMARY)
    public WebElement searchSummary;

    @FindBy(how = How.LINK_TEXT, using = Locators.ClearTripScreen.HOTELS_LINKTEXT)
    public WebElement hotelsLinkText;

    @FindBy(how = How.ID, using = Locators.ClearTripScreen.TAGS)
    public WebElement tags;

    @FindBy(how = How.ID, using = Locators.ClearTripScreen.SEARCH_HOTELS_BUTTON)
    public WebElement searchHotelsButton;

    @FindBy(how = How.ID, using = Locators.ClearTripScreen.TRAVELLERS_ON_HOME)
    public WebElement travellersOnHome;
}
