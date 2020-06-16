package demo.steps;

import demo.pages.nauval.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MobileRechargeDefinition {
    HomePage homePage;
    RechargeInputNumberPage inputNumber;
    RechargeChooseTopUpPage topUpPage;
    RechargePaymentDetailPage detailPage;
    RechargePaymentStatusPage statusPage;
    RechargeChooseVoucherPage chooseVoucher;

    @Given("User is on homepage")
    public void userIsOnHomepage() {
        boolean on_page = homePage.onHomePage();
        Assert.assertTrue(on_page);
    }

    @When("User click mobile recharge icon")
    public void userClickMobileRechargeIcon() {
        homePage.chooseMobileRecharge();
    }

    @And("User input {string}")
    public void userInputPhoneNumber(String phoneNumber) {
        inputNumber.inputNumber(phoneNumber);
    }

    @And("User choose {string} nominal")
    public void userChooseTopUpNominalBasedOn(String topUp) {
        topUpPage.chooseTopUpNominal(topUp);
    }

    @And("User see payment detail page")
    public void userSeePaymentDetailPage() {
        detailPage.isOnPage();
    }

    @And("User pay the bill")
    public void userPayTheBill() {
        detailPage.payButton();
    }

    @Then("User see payment success page")
    public void userSeePaymentSuccessPage() {
        statusPage.isOnPage();
    }

    @And("User see payment status {string}")
    public void userSeePaymentStatus(String status) {
        String status_page = statusPage.statusPayment();
        Assert.assertTrue(status_page.contains(status));
    }

    @And("User check status voucher availability {string}")
    public void userCheckStatusVoucherAvailability(String statusVoucher) {
        detailPage.selectVoucher(statusVoucher);
    }

    @And("User choose voucher value {string}")
    public void userChooseVoucherValueChooseVoucher(String voucherValue) {
        if (voucherValue.contains("cashback")){
            chooseVoucher.chooseCashback(voucherValue);
        }
        if (voucherValue.contains("discount")){
            chooseVoucher.chooseDiscount(voucherValue);
        }
        else {
            chooseVoucher.noVoucher();
        }
    }

    @Then("User see top up page")
    public void userSeeTopUpPage() {
    }

    @And("User click back to home button")
    public void userClickBackToHomeButton() {
        statusPage.backToHome();
    }
}
