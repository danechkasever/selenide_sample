package steps;

import com.google.inject.Inject;
import common.webdriver.Browser;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.AuthPage;

public class AuthStep {
    private final Browser browser;

    @Inject
    public AuthStep(Browser driver) {
        this.browser = driver;
    }

    @Step("SignIn with login {0} and password {1}")
    public void signIn(String login, String password) {
        new AuthPage(browser).setLogin(login);
        new AuthPage(browser).setPassword(password);
        new AuthPage(browser).signInBtnClick();
    }

    @Step("Check Auth Page Visibility")
    public void checkAuthPageVisibility() {
        Assert.assertTrue(new AuthPage(browser).isLoginDisplayed(), "Login input isn't visible");
        Assert.assertTrue(new AuthPage(browser).isSignInContinueBtnDisplayed(), "SignInContinue Button isn't visible");
    }
}
