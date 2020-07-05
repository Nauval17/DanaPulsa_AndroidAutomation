package demo.pages;

import demo.locator.HomePageLocator;
import pageobjects.AndroidPageObject;

import static demo.locator.HomePageLocator.Promotion_Title;

public class HomePage {

    AndroidPageObject pageObject = new AndroidPageObject();

    public boolean onHomePage(){
        return pageObject.checkIfDisplayed(HomePageLocator.DANA_Balance);
    }

    public void chooseMobileRecharge() {
        pageObject.clickOn(HomePageLocator.MobileRecharge_Button);
    }

    public void clickHistoryButton() {
        pageObject.clickOn(HomePageLocator.History_Button);
    }

    public void clickPromotionItem(String titles) {
        pageObject.waitUntilDisplayed(Promotion_Title);
        pageObject.multipleID(titles, Promotion_Title);
    }

    public void clickViewAll(){
        pageObject.clickOn(HomePageLocator.ViewAll_Button);
    }
}
