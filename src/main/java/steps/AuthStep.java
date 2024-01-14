package steps;

import com.google.inject.Inject;
import common.webdriver.Browser;
import io.qameta.allure.Step;
import models.Auth;
import org.testng.Assert;
import pages.AuthPage;

public class AuthStep {
    private final Browser browser;
    @Inject
    AuthPage authPage;

    @Inject
    public AuthStep(Browser browser) {
        this.browser = browser;
    }

    @Step("SignIn with login {0} and password {1}")
    public void signIn(Auth auth) {
        authPage.setLogin(auth.getUser());
        authPage.setPassword(auth.getPassword());
        authPage.signInBtnClick();
    }

    @Step("Check Auth Page Visibility")
    public void checkAuthPageVisibility() {
        Assert.assertTrue(authPage.isLoginDisplayed(), "Login input isn't visible");
        Assert.assertTrue(authPage.isSignInContinueBtnDisplayed(), "SignInContinue Button isn't visible");
    }
}
