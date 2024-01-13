package auth;


import com.google.inject.Guice;
import com.google.inject.Injector;
import common.webdriver.BrowserModule;
import common.webdriver.WebDriverOperations;
import io.qameta.allure.Feature;
import models.Auth;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.AuthStep;
import steps.SecurityStep;

@Feature("Auth")
public class AuthorisationTest {


    WebDriverOperations webDriverOperations;

    AuthStep authStep;

    SecurityStep securityStep;


    @BeforeMethod
    void beforeMethod() {
        Injector injector = Guice.createInjector(new BrowserModule());
        webDriverOperations = injector.getInstance(WebDriverOperations.class);
        authStep = injector.getInstance(AuthStep.class);
        securityStep = injector.getInstance(SecurityStep.class);
        webDriverOperations.open();
    }

    @Test
    void authVisibilityTest() {
        authStep.checkAuthPageVisibility();
    }

    @Test
    void authSuccessfulTest() {
        authStep.signIn(new Auth());
        securityStep.checkSecurityPageVisibility();
    }

    @AfterMethod
    void afterMethod() {
        webDriverOperations.close();
    }

}
