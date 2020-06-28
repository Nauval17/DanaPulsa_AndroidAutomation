package demo.pages;

import demo.locator.GeneralLocator;
import demo.locator.TransactionDetailPageLocator;
import pageobjects.AndroidPageObject;

public class TransactionDetailPage extends AndroidPageObject {
    public boolean isOnPage(){
        return checkIfDisplayed(TransactionDetailPageLocator.TransactionDetail_Header);
    }
    public boolean waitUntilTotalPriceDisplayed(){
        return checkIfDisplayed(TransactionDetailPageLocator.Transaction_Price);
    }
    public String getTransactionPrice(){
        return getText(TransactionDetailPageLocator.Transaction_Price);
    }
    public String getTransactionId(){
        return getText(TransactionDetailPageLocator.Transaction_ID);
    }
    public String getTransactionProduct(){
        return getText(TransactionDetailPageLocator.Transaction_Product);
    }
    public String getTransactionStatus(){
        return getText(TransactionDetailPageLocator.Transaction_Status);
    }
    public String getTransactionPhone(){
        return getText(TransactionDetailPageLocator.Transaction_Phone);
    }
    public String getTransactionDate(){ return getText(TransactionDetailPageLocator.Transaction_Date);
    }

    public String getWarningMessage() {
        return getText(GeneralLocator.ErrorDialog_Text);
    }
}
