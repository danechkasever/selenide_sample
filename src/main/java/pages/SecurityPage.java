package pages;

import com.google.inject.Inject;
import common.by.ByEx;
import common.by.CustomBy;
import common.webdriver.IBrowser;

public class SecurityPage {
    private final IBrowser iBrowser;
    @Inject
    public SecurityPage(IBrowser iBrowser){
        this.iBrowser = iBrowser;
    }

    private final CustomBy passkeysForm = new CustomBy(ByEx.CLASS_NAME, "passkeys-register-wrapper");



    public Boolean isPasskeysFormDisplayed() {
        return iBrowser.getElement(passkeysForm).isDisplayedElement();
    }
}
