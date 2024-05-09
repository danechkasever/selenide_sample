package auth;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import parameters.ActionsParameter;
import resolvers.ActionResolver;

@Feature("Main")

public class MainPageTest {
    @Test()
    @ExtendWith(ActionResolver.class)
    void checkPropertyTypesCountTest(ActionsParameter actionsParameter) {
        actionsParameter.getAllSteps().mainPageVisibilitySteps().checkPropertyTypesCount(24);
    }

    @Test()
    @ExtendWith(ActionResolver.class)
    void checkTopMenuItemsCountTest(ActionsParameter actionsParameter) {
        actionsParameter.getAllSteps().mainPageVisibilitySteps().checkTopMenuItemsCount(5);
    }
}
