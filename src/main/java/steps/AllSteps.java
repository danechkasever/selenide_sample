package steps;

import com.google.inject.Inject;
import common.webdriver.Browser;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class AllSteps {
    private final Browser browser;
    @Inject
    private AuthSteps authStep;
    @Inject
    private MainPageVisibilitySteps securityStep;
    @Inject
    private MainPageVisibilitySteps mainPageVisibilitySteps;

    @Inject
    public AllSteps(Browser browser) {
        this.browser = browser;
    }
}
