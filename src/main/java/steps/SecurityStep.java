package steps;

import com.google.inject.Inject;
import common.webdriver.Browser;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.SecurityPage;

public class SecurityStep {
    private final Browser browser;
    @Inject
    SecurityPage securityPage;

    @Inject
    public SecurityStep(Browser browser) {
        this.browser = browser;
    }
    @Step("Check Security Page Visibility")
    public void checkSecurityPageVisibility() {
        Assert.assertTrue(securityPage.isPasskeysFormDisplayed(), "Security form isn't visible");
    }
}
