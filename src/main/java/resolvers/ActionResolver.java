package resolvers;

import org.junit.jupiter.api.extension.*;
import parameters.ActionsParameter;

public class ActionResolver implements ParameterResolver, AfterEachCallback, BeforeEachCallback {
    ActionsParameter actionsParameter;

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == ActionsParameter.class;
    }

    @Override
    public ActionsParameter resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return actionsParameter;
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) {
        actionsParameter.getAllSteps().iBrowser().closeDriver();
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) {
        actionsParameter = new ActionsParameter();
        actionsParameter.getAllSteps().iBrowser().openPage();
    }
}
