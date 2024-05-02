package steps;

import com.google.inject.Inject;
import common.webdriver.IBrowser;
import io.qameta.allure.Step;
import org.assertj.core.api.WithAssertions;
import pages.MainPage;

public class MainPageVisibilitySteps implements WithAssertions {
    private final IBrowser iBrowser;
    @Inject
    MainPage mainPage;

    @Inject
    public MainPageVisibilitySteps(IBrowser iBrowser
    ) {
        this.iBrowser = iBrowser;
    }

    @Step("Check Profile Button Visibility")
    public void checkProfileButtonVisibility() {
        assertThat(mainPage.isProfileDisplayed()).isTrue().as("Profile Button visibility");
    }

    @Step("Navigate To SignIn")
    public void navigateToSignIn() {
        mainPage.signInLinkClick();
    }

    @Step("Navigate To SignUp")
    public void navigateToSignUp() {
        mainPage.signUpLinkClick();
    }
}
