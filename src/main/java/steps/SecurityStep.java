package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.SecurityPage;

public class SecurityStep {
    @Step("Check Security Page Visibility")
    public void checkSecurityPageVisibility() {
        Assert.assertTrue(new SecurityPage().isPasskeysFormDisplayed(), "Security form isn't visible");
    }
}
