package parameters;

import com.google.inject.Guice;
import com.google.inject.Injector;
import common.webdriver.BrowserModule;
import lombok.Data;
import steps.AllSteps;

@Data
public class ActionsParameter {
    AllSteps allSteps;

    public ActionsParameter() {
        Injector injector = Guice.createInjector(new BrowserModule());
        allSteps = injector.getInstance(AllSteps.class);
    }
}
