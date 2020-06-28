package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface ForgotPinPageLocator {
    By PIN_OTP_LABEL = MobileBy.id("tvOtpConfirmLabel");
    By PHONENUMBER_OTP_LABEL = MobileBy.id("tvOtpConfirmPhone");
    By OTP_INPUT = MobileBy.id("otpPIN"); //INPUT OTP
    By RESEND_LABEL = MobileBy.id("tvResendOtpLabel");
    By RESEND_BUTTON = MobileBy.id("btnResendOtp");
    By NEXT_BUTTON = MobileBy.id("btnChangePinNext"); //berubah
    By PIN_TITLE = MobileBy.id("tvActivityTitle");


    By NEW_PIN_LABEL = MobileBy.id("tvChangePinLabel"); //berubah
    By NEW_PIN_INPUT = MobileBy.id("pinEntryNewPin"); //INPUT NEW PIN
    By BACK_BUTTON = MobileBy.AccessibilityId("Navigate up");
    By NEW_PIN_WARNING = MobileBy.id(""); //KOSONG

    By CONFIRM_PIN_LABEL = MobileBy.id("tvChangePinConfirmLabel"); //berubah
    By CONFIRM_PIN_INPUT = MobileBy.id("pinEntryConfirmPin"); //INPUT CONFIRM
    By FINISH_CONFIRM_BUTTON = MobileBy.id("btnChangePinFinish"); //berubah
    By CONFIRM_PIN_WARNING = MobileBy.id(""); //KOSONG

}
