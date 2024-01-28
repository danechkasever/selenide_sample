package steps;

import com.google.inject.Inject;
import common.webdriver.Browser;
import io.qameta.allure.Step;
import org.assertj.core.api.WithAssertions;
import pages.SecurityPage;

public class SecurityStep implements WithAssertions {
    private final Browser browser;
    @Inject
    SecurityPage securityPage;

    @Inject
    public SecurityStep(Browser browser) {
        this.browser = browser;
    }

    @Step("Check Security Page Visibility")
    public void checkSecurityPageVisibility() {
        assertThat(securityPage.isPasskeysFormDisplayed()).isTrue().as("Security visibility");
    }
}
