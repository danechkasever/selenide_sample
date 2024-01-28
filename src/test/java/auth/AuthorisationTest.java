package auth;

import io.qameta.allure.Feature;
import models.Auth;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import parameters.ActionsParameter;
import resolvers.ActionResolver;

@Feature("Auth")
@ExtendWith(ActionResolver.class)
public class AuthorisationTest {

    @Test()
    void authVisibilityTest(ActionsParameter actionsParameter) {
        actionsParameter.getWebDriverOperations().openPage();
        actionsParameter.getAllSteps().authStep().checkAuthPageVisibility();
    }


    @Test()
    void authSuccessfulTest(ActionsParameter actionsParameter) {
        actionsParameter.getWebDriverOperations().openPage();
        actionsParameter.getAllSteps().authStep().signIn(new Auth());
        actionsParameter.getAllSteps().securityStep().checkSecurityPageVisibility();
    }
}
