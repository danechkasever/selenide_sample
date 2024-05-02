package pages;

import com.google.inject.Inject;
import common.by.ByEx;
import common.by.CustomBy;
import common.webdriver.IBrowser;
import forms.SubmitEmailForm;

public class AuthPage  {
    private final IBrowser iBrowser;
    private final CustomBy passwordInput = new CustomBy(ByEx.ID, "password");
    private final CustomBy signInBtn = new CustomBy(ByEx.CSS, "button[type='submit']");
    @Inject
    SubmitEmailForm submitEmailForm;


    @Inject
    public AuthPage(IBrowser iBrowser) {
        this.iBrowser = iBrowser;
    }


    public void setLogin(String login) {
        iBrowser.getElement(submitEmailForm.getEmailInput()).setTextAfterLoad(login);
        iBrowser.getElement(submitEmailForm.getContinueWithEmailBtn()).clickWithLoadElement();
    }

    public Boolean isLoginInputDisplayed() {
        return iBrowser.getElement(submitEmailForm.getEmailInput()).isDisplayed();
    }

    public Boolean isContinueWithEmailBtnDisplayed() {
        return iBrowser.getElement(submitEmailForm.getContinueWithEmailBtn()).isDisplayedElement();
    }

    public void setPassword(String password) {
        iBrowser.getElement(passwordInput).setTextAfterLoad(password);
    }

    public void signInBtnClick() {
        iBrowser.getElement(signInBtn).clickWithLoadElement();
    }
}
