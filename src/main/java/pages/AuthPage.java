package pages;

import common.webdriver.CustomCommands;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AuthPage implements CustomCommands {
    private final By loginInput = By.id("userid");
    private final By signInContinueBtn = By.id("signin-continue-btn");
    private final By passwordInput = By.id("pass");
    private final By signInBtn = By.id("sgnBt");


    public void setLogin(String login) {
        setText($(loginInput), login);
        clickElement($(signInContinueBtn));
    }

    public Boolean isLoginDisplayed() {
        return $(loginInput).isDisplayed();
    }

    public Boolean isSignInContinueBtnDisplayed() {
        return $(signInContinueBtn).isDisplayed();
    }

    public void setPassword(String password) {
        setText($(passwordInput), password);
    }

    public void signInBtnClick() {
        clickElement($(signInBtn));
    }
}
