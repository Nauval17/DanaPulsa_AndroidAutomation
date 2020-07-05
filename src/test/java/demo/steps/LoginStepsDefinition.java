package demo.steps;

import demo.pages.nauval.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepsDefinition {
    SignInPage signIn = new SignInPage();

    @Given("User is on sign in page")
    public void userIsOnSignInPage() throws InterruptedException {
        boolean status_1 = signIn.isOnPage();
        Assert.assertTrue(status_1);
        Thread.sleep(5000);
    }

    @When("User input phone number {string}")
    public void userInputPhoneNumber(String number) {
        signIn.inputNumber(number);
        signIn.signInButton();
    }

    @And("User input pin number {string}")
    public void userInputPinNumber(String pin) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        signIn.waitPIN();
        signIn.inputPIN(pin);
    }
}
