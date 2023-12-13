package auth;


import com.google.inject.Inject;
import common.webdriver.CustomWebDriver;
import common.webdriver.WebDriverOperations;
import configs.Configurations;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;
import steps.AuthStep;
import steps.SecurityStep;

@Feature("Auth")
@Guice(modules = {CustomWebDriver.class})
public class AuthorisationTest {
    @Inject
    WebDriverOperations webDriverOperations;
    @Inject
    AuthStep authStep;
    @Inject
    SecurityStep securityStep;

    @BeforeMethod
    void beforeMethod() {
        webDriverOperations.open();
    }

    @Test
    void authVisibilityTest() {
        authStep.checkAuthPageVisibility();
        securityStep.checkSecurityPageVisibility();
    }

    @Test
    void authSuccessfulTest() {
        authStep.signIn(Configurations.user, Configurations.password);
        Assert.assertTrue(true);
    }

    @AfterMethod
    void afterMethod() {
        webDriverOperations.close();
    }

}
