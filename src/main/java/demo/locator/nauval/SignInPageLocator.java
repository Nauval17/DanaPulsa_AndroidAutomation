package demo.locator.nauval;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface SignInPageLocator {
    By DANA_LOGO = MobileBy.id("ivLoginLogo");
    By LOGIN_LABEL = MobileBy.id("tvLoginLabelPhone");
    By PIN_LABEL = MobileBy.id("tvLoginLabelPin");
    By INPUT_NUMBER = MobileBy.id("edtLoginPhone");
    By SIGN_IN_BUTTON = MobileBy.id("btnLoginSignIn");
    By INPUT_PIN = MobileBy.id("pinEntryLogin");
}
