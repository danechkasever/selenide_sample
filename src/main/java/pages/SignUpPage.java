package pages;

import com.codeborne.selenide.SelenideDriver;
import com.google.inject.Inject;
import common.webdriver.Browser;
import common.webdriver.CustomCommands;
import forms.SubmitEmailForm;
import org.openqa.selenium.By;

public class SignUpPage implements CustomCommands {
    private final SelenideDriver selenideDriver;
    private final By passwordInput = By.id("new_password");
    private final By passwordConfirmationInput = By.id("confirmed_password");
    private final By signUpBtn = By.cssSelector("button[type='submit']");
    @Inject
    SubmitEmailForm submitEmailForm;

    @Inject
    public SignUpPage(Browser browser) {
        this.selenideDriver = browser.getDriver();
    }


    public void setLogin(String login) {
        setText(selenideDriver.$(submitEmailForm.getEmailInput()), login);
        clickElement(selenideDriver.$(submitEmailForm.getContinueWithEmailBtn()));
    }

    public Boolean isLoginInputDisplayed() {
        return selenideDriver.$(submitEmailForm.getEmailInput()).isDisplayed();
    }

    public Boolean isContinueWithEmailBtnDisplayed() {
        return selenideDriver.$(submitEmailForm.getContinueWithEmailBtn()).isDisplayed();
    }

    public void setPassword(String password) {
        setText(selenideDriver.$(passwordInput), password);
    }

    public void setPasswordConfirmation(String password) {
        setText(selenideDriver.$(passwordConfirmationInput), password);
    }

    public void signUpBtnClick() {
        clickElement(selenideDriver.$(signUpBtn));
    }
}
