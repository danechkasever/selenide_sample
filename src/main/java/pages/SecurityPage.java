package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SecurityPage {
    private final By passkeysForm = By.className("passkeys-register-wrapper");

    public Boolean isPasskeysFormDisplayed() {
        return $(passkeysForm).isDisplayed();
    }
}
