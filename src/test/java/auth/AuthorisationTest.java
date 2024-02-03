package auth;

import io.qameta.allure.Feature;
import models.Auth;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import parameters.ActionsParameter;
import resolvers.ActionResolver;

@Feature("Auth")

public class AuthorisationTest {

    @Test()
    @ExtendWith(ActionResolver.class)
    void authVisibilityTest(ActionsParameter actionsParameter) {
        actionsParameter.getAllSteps().mainPageVisibilitySteps().navigateToSignIn();
        actionsParameter.getAllSteps().authStep().checkSetLoginVisibility();
    }


    @Test()
    @ExtendWith(ActionResolver.class)
    void authSuccessfulTest(ActionsParameter actionsParameter) {
        actionsParameter.getAllSteps().mainPageVisibilitySteps().navigateToSignIn();
        actionsParameter.getAllSteps().authStep().signIn(new Auth());
        actionsParameter.getAllSteps().mainPageVisibilitySteps().checkProfileButtonVisibility();
    }
}
