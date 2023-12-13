package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.AuthPage;

public class AuthStep {
    @Step("SignIn with login {0} and password {1}")
    public void signIn(String login, String password) {
        new AuthPage().setLogin(login);
        new AuthPage().setPassword(password);
        new AuthPage().signInBtnClick();
    }

    @Step("Check Auth Page Visibility")
    public void checkAuthPageVisibility() {
        Assert.assertTrue(new AuthPage().isLoginDisplayed(), "Login input isn't visible");
        Assert.assertTrue(new AuthPage().isSignInContinueBtnDisplayed(), "SignInContinue Button isn't visible");
    }
}
