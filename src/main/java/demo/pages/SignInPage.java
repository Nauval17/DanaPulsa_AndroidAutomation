package demo.pages;

import demo.locator.GeneralLocator;
import demo.locator.SignInPageLocator;
import pageobjects.AndroidPageObject;

public class SignInPage extends AndroidPageObject {

    public boolean isOnPage() {
        return checkIfDisplayed(SignInPageLocator.DANA_Logo);
    }
    public void inputPhoneNumber(String phoneNumber) {
        typeON(SignInPageLocator.Input_PhoneNumber_Field, phoneNumber);
    }
    public void clickSignInButton() {
        clickOn(SignInPageLocator.SignIn_Button);
    }
    public void clickSignUpButton() {
        clickOn(SignInPageLocator.SignUp_Button);
    }
    public void checkErrorDialog() {
        waitUntilDisplayed(GeneralLocator.ErrorDialog_Text);
    }
    public void clickErrorDialogOkButton() {
        clickOn(GeneralLocator.ErrorDialog_OK_Button);
    }
    public String getErrorDialogText() {
        return getText(GeneralLocator.ErrorDialog_Text);
    }
    public String getToastMessage() { return checkToast(GeneralLocator.TOAST_POPUP); }
    public String getErrorMessageText() {
        return getText(SignInPageLocator.ErrorMessage_Text);
    }
    public boolean checkSignButton() {
        return checkIfEnabled(SignInPageLocator.SignIn_Button);
    }
    public String getInputPhoneNumberData(){
        return getText(SignInPageLocator.Input_PhoneNumber_Field);
    }
}
