package steps;

import com.google.inject.Inject;
import common.webdriver.Browser;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.SecurityPage;

public class SecurityStep {
    private final Browser browser;

    @Inject
    public SecurityStep(Browser driver) {
        this.browser = driver;
    }
    @Step("Check Security Page Visibility")
    public void checkSecurityPageVisibility() {
        Assert.assertTrue(new SecurityPage(browser).isPasskeysFormDisplayed(), "Security form isn't visible");
    }
}
