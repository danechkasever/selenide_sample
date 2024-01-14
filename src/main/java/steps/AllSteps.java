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
    private AuthStep authStep;
    @Inject
    private SecurityStep securityStep;

    @Inject
    public AllSteps(Browser browser) {
        this.browser = browser;
    }
}
