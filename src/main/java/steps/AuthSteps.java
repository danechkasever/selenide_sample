package steps;

import com.google.inject.Inject;
import common.webdriver.Browser;
import io.qameta.allure.Step;
import models.Auth;
import org.assertj.core.api.WithAssertions;
import pages.AuthPage;

public class AuthSteps implements WithAssertions {
    private final Browser browser;
    @Inject
    AuthPage authPage;

    @Inject
    public AuthSteps(Browser browser) {
        this.browser = browser;
    }

    @Step("SignIn with login {0} and password {1}")
    public void signIn(Auth auth) {
        authPage.setLogin(auth.getUser());
        authPage.setPassword(auth.getPassword());
        authPage.signInBtnClick();
    }

    @Step("Check Set Login Page Visibility")
    public void checkSetLoginVisibility() {
        assertThat(authPage.isLoginInputDisplayed()).isTrue().as("Login input visibility");
        assertThat(authPage.isContinueWithEmailBtnDisplayed()).isTrue().as("SignInContinue Button visibility");
    }
}
