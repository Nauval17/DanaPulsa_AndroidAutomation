package demo.pages;

import demo.locator.LetsPayPageLocator;
import pageobjects.AndroidPageObject;

public class LetsPayPage extends AndroidPageObject {
    public void isOnPage() {
        waitUntilDisplayed(LetsPayPageLocator.Total_Price);
    }
    public void clickBackButton() {
        clickOn(LetsPayPageLocator.Back_Button);
    }
    public void checkIfDialogBoxIsDisplayed() {
        waitUntilDisplayed(LetsPayPageLocator.Yes_Button);
    }
    public void clickYesButton() {
        clickOn(LetsPayPageLocator.Yes_Button);
    }
    public String getTotalPrice() {
        return getText(LetsPayPageLocator.Total_Price);
    }
    public void clickPayButton() {
        clickOn(LetsPayPageLocator.Pay_Button);
    }
}
