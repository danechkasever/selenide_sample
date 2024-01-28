package steps;

import com.google.inject.Inject;
import common.webdriver.Browser;
import io.qameta.allure.Step;
import models.Auth;
import org.assertj.core.api.WithAssertions;
import pages.AuthPage;

public class AuthStep implements WithAssertions {
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
        assertThat(authPage.isLoginDisplayed()).isTrue().as("Login input visibility");
        assertThat(authPage.isSignInContinueBtnDisplayed()).isTrue().as("SignInContinue Button visibility");
    }
}
