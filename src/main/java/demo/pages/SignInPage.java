package demo.pages;

import demo.locator.SignInPageLocator;
import pageobjects.AndroidPageObject;

public class SignInPage implements SignInPageLocator {
    AndroidPageObject pageObject = new AndroidPageObject();

    public boolean isOnPage(){
        return pageObject.checkIfDisplayed(DANA_LOGO);
    }

    public void inputNumber(String number){
        pageObject.typeON(INPUT_NUMBER, number);
    }

    public void inputPIN(String pin){
        pageObject.typeON(INPUT_PIN, pin);
    }

    public void signInButton(){
        pageObject.clickOn(SIGN_IN_BUTTON);
    }
}