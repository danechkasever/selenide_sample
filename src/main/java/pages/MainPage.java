package pages;

import com.codeborne.selenide.SelenideDriver;
import com.google.inject.Inject;
import common.webdriver.Browser;
import common.webdriver.CustomCommands;
import org.openqa.selenium.By;

public class MainPage implements CustomCommands {
    private final SelenideDriver selenideDriver;
    private final By logoLink = By.cssSelector("[data-testid='header-booking-logo']");
    private final By languagePickerBtn = By.cssSelector("[data-testid='header-language-picker-trigger']");
    private final By signUpLink = By.cssSelector("[data-testid='header-sign-up-button']");
    private final By signInLink = By.cssSelector("[data-testid='header-sign-in-button']");
    private final By profileBtn = By.cssSelector("[data-testid='header-profile']");
    private final By accommodationsLink = By.id("accommodations");
    private final By flightsLink = By.id("flights");
    private final By packagesLink = By.id("packages");
    private final By carsLink = By.id("cars");
    private final By attractionsLink = By.id("attractions");
    private final By airportTaxisLink = By.id("airport_taxis");
    private final By destinationInput = By.id(":re:");
    private final By dateFromBtn = By.cssSelector("[data-testid='date-display-field-start']");
    private final By dateToBtn = By.cssSelector("[data-testid='date-display-field-end']");
    private final By searchBtn = By.cssSelector("button[type='submit']");


    @Inject
    public MainPage(Browser browser) {
        this.selenideDriver = browser.getDriver();
    }

    public Boolean isLogoLinkDisplayed() {
        return selenideDriver.$(logoLink).isDisplayed();
    }

    public Boolean isLanguagePickerBtnDisplayed() {
        return selenideDriver.$(languagePickerBtn).isDisplayed();
    }

    public Boolean isSignUpLinkDisplayed() {
        return selenideDriver.$(signUpLink).isDisplayed();
    }

    public Boolean isSignInLinkDisplayed() {
        return selenideDriver.$(signInLink).isDisplayed();
    }

    public Boolean isProfileDisplayed() {
        return selenideDriver.$(profileBtn).isDisplayed();
    }

    public Boolean isAccommodationsLinkDisplayed() {
        return selenideDriver.$(accommodationsLink).isDisplayed();
    }

    public Boolean isFlightsLinkDisplayed() {
        return selenideDriver.$(flightsLink).isDisplayed();
    }

    public Boolean isPackagesLinkDisplayed() {
        return selenideDriver.$(packagesLink).isDisplayed();
    }

    public Boolean isCarsLinkDisplayed() {
        return selenideDriver.$(carsLink).isDisplayed();
    }

    public Boolean isAttractionsLinkDisplayed() {
        return selenideDriver.$(attractionsLink).isDisplayed();
    }

    public Boolean isAirportTaxisLinkDisplayed() {
        return selenideDriver.$(airportTaxisLink).isDisplayed();
    }


    public Boolean isDestinationInputDisplayed() {
        return selenideDriver.$(destinationInput).isDisplayed();
    }

    public Boolean isDateFromBtnDisplayed() {
        return selenideDriver.$(dateFromBtn).isDisplayed();
    }

    public Boolean isDateToBtnDisplayed() {
        return selenideDriver.$(dateToBtn).isDisplayed();
    }

    public Boolean isSearchBtnDisplayed() {
        return selenideDriver.$(searchBtn).isDisplayed();
    }

    public void languagePickerBtnClick() {
        clickElement(selenideDriver.$(languagePickerBtn));
    }

    public void signUpLinkClick() {
        clickElement(selenideDriver.$(signUpLink));
    }

    public void signInLinkClick() {
        clickElement(selenideDriver.$(signInLink));
    }

    public void accommodationsLinkClick() {
        clickElement(selenideDriver.$(accommodationsLink));
    }

    public void flightsLinkClick() {
        clickElement(selenideDriver.$(flightsLink));
    }

    public void packagesLinkClick() {
        clickElement(selenideDriver.$(packagesLink));
    }

    public void carsLinkClick() {
        clickElement(selenideDriver.$(carsLink));
    }

    public void attractionsLinkClick() {
        clickElement(selenideDriver.$(attractionsLink));
    }

    public void airportTaxisLinkClick() {
        clickElement(selenideDriver.$(airportTaxisLink));
    }

    public void airportTaxisLinkSetText(String destination) {
        setText(selenideDriver.$(destinationInput), destination);
    }

    public void dateFromBtnClick() {
        clickElement(selenideDriver.$(dateFromBtn));
    }

    public void dateToBtnClick() {
        clickElement(selenideDriver.$(dateToBtn));
    }

    public void searchBtnClick() {
        clickElement(selenideDriver.$(searchBtn));
    }
}
