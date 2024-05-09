package pages;

import com.google.inject.Inject;
import common.by.ByEx;
import common.by.CustomBy;
import common.webdriver.IBrowser;

public class MainPage {
    private final IBrowser iBrowser;
    private final CustomBy logoLink = new CustomBy(ByEx.CSS, "[data-testid='header-booking-logo']");
    private final CustomBy languagePickerBtn = new CustomBy(ByEx.CSS, "[data-testid='header-language-picker-trigger']");
    private final CustomBy signUpLink = new CustomBy(ByEx.CSS, "[data-testid='header-sign-up-button']");
    private final CustomBy signInLink = new CustomBy(ByEx.CSS, "[data-testid='header-sign-in-button']");
    private final CustomBy profileBtn = new CustomBy(ByEx.CSS, "[data-testid='header-profile']");
    private final CustomBy accommodationsLink = new CustomBy(ByEx.ID, "accommodations");
    private final CustomBy flightsLink = new CustomBy(ByEx.ID, "flights");
    private final CustomBy packagesLink = new CustomBy(ByEx.ID, "packages");
    private final CustomBy carsLink = new CustomBy(ByEx.ID, "cars");
    private final CustomBy attractionsLink = new CustomBy(ByEx.ID, "attractions");
    private final CustomBy airportTaxisLink = new CustomBy(ByEx.ID, "airport_taxis");
    private final CustomBy destinationInput = new CustomBy(ByEx.ID, ":re:");
    private final CustomBy dateFromBtn = new CustomBy(ByEx.CSS, "[data-testid='date-display-field-start']");
    private final CustomBy dateToBtn = new CustomBy(ByEx.CSS, "[data-testid='date-display-field-end']");
    private final CustomBy searchBtn = new CustomBy(ByEx.CSS, "button[type='submit']");
    private final CustomBy propertyType = new CustomBy(ByEx.XPATH, ".//*[contains(@*, 'PropertyTypes')]//*[@data-testid='web-core-stacked-card']");
    private final CustomBy picture = new CustomBy(ByEx.XPATH, ".//picture");
    private final CustomBy topMenu = new CustomBy(ByEx.XPATH, ".//nav[@data-testid='header-xpb']");
    private final CustomBy link = new CustomBy(ByEx.XPATH, ".//a");





    @Inject
    public MainPage(IBrowser iBrowser) {
        this.iBrowser = iBrowser;
    }


    public Integer getPropertyTypesCount() {
        return iBrowser.getElements(propertyType).size();
    }

    public Integer getTopMenuItemsCount() {
        return iBrowser.getElements(link, topMenu).size();
    }
    public Boolean isLogoLinkDisplayed() {
        return iBrowser.getElement(logoLink).isDisplayedElement();
    }

    public Boolean isLanguagePickerBtnDisplayed() {
        return iBrowser.getElement(languagePickerBtn).isDisplayedElement();
    }

    public Boolean isSignUpLinkDisplayed() {
        return iBrowser.getElement(signUpLink).isDisplayedElement();
    }

    public Boolean isSignInLinkDisplayed() {
        return iBrowser.getElement(signInLink).isDisplayedElement();
    }

    public Boolean isProfileDisplayed() {
        return iBrowser.getElement(profileBtn).isDisplayedElement();
    }

    public Boolean isAccommodationsLinkDisplayed() {
        return iBrowser.getElement(accommodationsLink).isDisplayedElement();
    }

    public Boolean isFlightsLinkDisplayed() {
        return iBrowser.getElement(flightsLink).isDisplayedElement();
    }

    public Boolean isPackagesLinkDisplayed() {
        return iBrowser.getElement(packagesLink).isDisplayedElement();
    }

    public Boolean isCarsLinkDisplayed() {
        return iBrowser.getElement(carsLink).isDisplayedElement();
    }

    public Boolean isAttractionsLinkDisplayed() {
        return iBrowser.getElement(attractionsLink).isDisplayedElement();
    }

    public Boolean isAirportTaxisLinkDisplayed() {
        return iBrowser.getElement(airportTaxisLink).isDisplayedElement();
    }


    public Boolean isDestinationInputDisplayed() {
        return iBrowser.getElement(destinationInput).isDisplayedElement();
    }

    public Boolean isDateFromBtnDisplayed() {
        return iBrowser.getElement(dateFromBtn).isDisplayedElement();
    }

    public Boolean isDateToBtnDisplayed() {
        return iBrowser.getElement(dateToBtn).isDisplayedElement();
    }

    public Boolean isSearchBtnDisplayed() {
        return iBrowser.getElement(searchBtn).isDisplayedElement();
    }

    public void languagePickerBtnClick() {
        iBrowser.getElement(languagePickerBtn).clickWithLoadElement();
    }

    public void signUpLinkClick() {
        iBrowser.getElement(signUpLink).clickWithLoadElement();
    }

    public void signInLinkClick() {
        iBrowser.getElement(signInLink).clickWithLoadElement();
    }


    public void accommodationsLinkClick() {
        iBrowser.getElement(accommodationsLink).clickWithScrollElement();
    }

    public void flightsLinkClick() {
        iBrowser.getElement(flightsLink).clickWithScrollElement();
    }

    public void packagesLinkClick() {
        iBrowser.getElement(packagesLink).clickWithScrollElement();
    }

    public void carsLinkClick() {
        iBrowser.getElement(carsLink).clickWithScrollElement();
    }

    public void attractionsLinkClick() {
        iBrowser.getElement(attractionsLink).clickWithScrollElement();
    }

    public void airportTaxisLinkClick() {
        iBrowser.getElement(airportTaxisLink).clickWithScrollElement();
    }

    public void airportTaxisLinkSetText(String destination) {
        iBrowser.getElement(destinationInput).clickWithScrollElement();
    }

    public void dateFromBtnClick() {
        iBrowser.getElement(dateFromBtn).clickWithScrollElement();
    }

    public void dateToBtnClick() {
        iBrowser.getElement(dateToBtn).clickWithScrollElement();
    }

    public void searchBtnClick() {
        iBrowser.getElement(searchBtn).clickWithScrollElement();
    }
}

