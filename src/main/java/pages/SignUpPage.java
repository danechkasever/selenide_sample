package pages;

import com.google.inject.Inject;
import common.by.ByEx;
import common.by.CustomBy;
import common.webdriver.IBrowser;
import forms.SubmitEmailForm;

public class SignUpPage {
    private final IBrowser iBrowser;
    private final CustomBy passwordInput = new CustomBy(ByEx.ID, "new_password");
    private final CustomBy passwordConfirmationInput = new CustomBy(ByEx.ID, "confirmed_password");
    private final CustomBy signUpBtn = new CustomBy(ByEx.CSS, "button[type='submit']");
    @Inject
    SubmitEmailForm submitEmailForm;

    @Inject
    public SignUpPage(IBrowser iBrowser) {
        this.iBrowser = iBrowser;
    }


    public void setLogin(String login) {
        iBrowser.getElement(submitEmailForm.getEmailInput()).setTextAfterLoad(login);
        iBrowser.getElement(submitEmailForm.getContinueWithEmailBtn()).clickWithLoadElement();
    }

    public Boolean isLoginInputDisplayed() {
        return iBrowser.getElement(submitEmailForm.getEmailInput()).isDisplayedElement();
    }

    public Boolean isContinueWithEmailBtnDisplayed() {
        return iBrowser.getElement(submitEmailForm.getContinueWithEmailBtn()).isDisplayedElement();
    }

    public void setPassword(String password) {
        iBrowser.getElement(passwordInput).setTextAfterLoad(password);
    }

    public void setPasswordConfirmation(String password) {
       iBrowser.getElement(passwordConfirmationInput).setTextAfterLoad(password);
    }

    public void signUpBtnClick() {
        iBrowser.getElement(signUpBtn).clickWithLoadElement();
    }
}
