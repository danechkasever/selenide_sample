package pages;

import com.codeborne.selenide.SelenideDriver;
import com.google.inject.Inject;
import common.webdriver.Browser;
import common.webdriver.CustomCommands;
import org.openqa.selenium.By;

public class AuthPage implements CustomCommands {
    private final SelenideDriver selenideDriver;
    private final By loginInput = By.id("userid");
    private final By signInContinueBtn = By.id("signin-continue-btn");
    private final By passwordInput = By.id("pass");
    private final By signInBtn = By.id("sgnBt");

    @Inject
    public AuthPage(Browser browser) {
        this.selenideDriver = browser.getDriver();
    }


    public void setLogin(String login) {
        setText(selenideDriver.$(loginInput), login);
        clickElement(selenideDriver.$(signInContinueBtn));
    }

    public Boolean isLoginDisplayed() {
        return selenideDriver.$(loginInput).isDisplayed();
    }

    public Boolean isSignInContinueBtnDisplayed() {
        return selenideDriver.$(signInContinueBtn).isDisplayed();
    }

    public void setPassword(String password) {
        setText(selenideDriver.$(passwordInput), password);
    }

    public void signInBtnClick() {
        clickElement(selenideDriver.$(signInBtn));
    }
}
