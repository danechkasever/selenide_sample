package pages;

import com.codeborne.selenide.SelenideDriver;
import com.google.inject.Inject;
import common.webdriver.Browser;
import org.openqa.selenium.By;

public class SecurityPage {
    private final SelenideDriver selenideDriver;
    private final By passkeysForm = By.className("passkeys-register-wrapper");

    @Inject
    public SecurityPage(Browser driver){
        this.selenideDriver = driver.getDriver();
    }

    public Boolean isPasskeysFormDisplayed() {
        return selenideDriver.$(passkeysForm).isDisplayed();
    }
}
