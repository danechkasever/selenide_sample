package steps;

import com.google.inject.Inject;
import common.webdriver.IBrowser;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class AllSteps {
    private final IBrowser iBrowser;
    @Inject
    private AuthSteps authStep;
    @Inject
    private MainPageVisibilitySteps securityStep;
    @Inject
    private MainPageVisibilitySteps mainPageVisibilitySteps;

    @Inject
    public AllSteps(IBrowser iBrowser) {
        this.iBrowser =iBrowser;
    }
}
