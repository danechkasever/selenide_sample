package pages;

import com.codeborne.selenide.SelenideDriver;
import com.google.inject.Inject;
import common.webdriver.Browser;
import common.webdriver.CustomCommands;
import org.openqa.selenium.By;

public class AuthPage implements CustomCommands {
    private final SelenideDriver browser;
    private final By loginInput = By.id("userid");
    private final By signInContinueBtn = By.id("signin-continue-btn");
    private final By passwordInput = By.id("pass");
    private final By signInBtn = By.id("sgnBt");

    @Inject
    public AuthPage(Browser driver) {
        this.browser = driver.getDriver();
    }


    public void setLogin(String login) {
        setText(browser.$(loginInput), login);
        clickElement(browser.$(signInContinueBtn));
    }

    public Boolean isLoginDisplayed() {
        return browser.$(loginInput).isDisplayed();
    }

    public Boolean isSignInContinueBtnDisplayed() {
        return browser.$(signInContinueBtn).isDisplayed();
    }

    public void setPassword(String password) {
        setText(browser.$(passwordInput), password);
    }

    public void signInBtnClick() {
        clickElement(browser.$(signInBtn));
    }
}
