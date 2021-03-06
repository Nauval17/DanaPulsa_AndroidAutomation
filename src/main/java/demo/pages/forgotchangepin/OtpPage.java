package demo.pages.forgotchangepin;


import demo.driver.AndroidDriverInstance;
import demo.imagecontroller.ImageController;
import demo.locator.ForgotPinPageLocator;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.AndroidPageObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;

public class OtpPage extends AndroidPageObject {
    public boolean isOnPage() {
        return checkIfDisplayed(ForgotPinPageLocator.OTP_INPUT);
    }

    public void inputOTP(String otp) {
        typeON(ForgotPinPageLocator.OTP_INPUT, otp);
    }

    public void clickNextOtp() {
        clickOn(ForgotPinPageLocator.NEXT_BUTTON);
    }

    public boolean checkIfNextEnabled() {
        WebDriverWait wait = new WebDriverWait(AndroidDriverInstance.androidDriver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(ForgotPinPageLocator.NEXT_BUTTON));
        return checkIfEnabled(ForgotPinPageLocator.NEXT_BUTTON);
    }

    public void waitForResend(){
        WebDriverWait wait = new WebDriverWait(AndroidDriverInstance.androidDriver, 190);
        wait.until(ExpectedConditions.elementToBeClickable(ForgotPinPageLocator.RESEND_BUTTON));
    }

    public void clickResendOtp() {
        clickOn(ForgotPinPageLocator.RESEND_BUTTON);
    }

    public void setForPaste(String otp){
        AndroidDriverInstance.androidDriver.setClipboardText(otp);
    }

    public boolean tryToPaste(String deviceType) {
        AndroidElement element = AndroidDriverInstance.androidDriver.findElement(ForgotPinPageLocator.OTP_INPUT);
        TouchAction action = new TouchAction(AndroidDriverInstance.androidDriver)
                .longPress(new LongPressOptions()
                        .withElement(ElementOption.element(element))
                        .withDuration(Duration.ofMillis(4000)))
                .release()
                .perform();
        System.out.println("LongPressed Tapped");
        ImageController imageController = new ImageController();
        try {
            return imageController.checkIfWarningDisplayed("paste-"+deviceType +".png");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkIfResendEnabled(){
        try {
            System.out.println(checkIfEnabled(ForgotPinPageLocator.RESEND_BUTTON));
            return AndroidDriverInstance.androidDriver.findElements(ForgotPinPageLocator.RESEND_BUTTON).size() > 0;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }






}
