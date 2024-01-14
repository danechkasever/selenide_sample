package parameters;

import com.google.inject.Guice;
import com.google.inject.Injector;
import common.webdriver.BrowserModule;
import common.webdriver.WebDriverOperations;
import lombok.Data;
import steps.AllSteps;

@Data
public class ActionsParameter {
    AllSteps allSteps;
    WebDriverOperations webDriverOperations;

    public ActionsParameter() {
        Injector injector = Guice.createInjector(new BrowserModule());
        allSteps = injector.getInstance(AllSteps.class);
        webDriverOperations = injector.getInstance(WebDriverOperations.class);
    }
}
