package auth;


import io.qameta.allure.Feature;
import models.Auth;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import parameters.ActionsParameter;

@Feature("Auth")
public class AuthorisationTest {
    ActionsParameter actionsParameter;

    @Test()
    void authVisibilityTest() {
        actionsParameter = new ActionsParameter();
        actionsParameter.getWebDriverOperations().openPage();
        actionsParameter.getAllSteps().authStep().checkAuthPageVisibility();
    }


    @Test()
    @Parameters
    void authSuccessfulTest() {
        actionsParameter = new ActionsParameter();
        actionsParameter.getWebDriverOperations().openPage();
        actionsParameter.getAllSteps().authStep().signIn(new Auth());
        actionsParameter.getAllSteps().securityStep().checkSecurityPageVisibility();
    }

    @AfterMethod
    void afterMethod() {
        actionsParameter.getWebDriverOperations().closeDriver();
    }

}
