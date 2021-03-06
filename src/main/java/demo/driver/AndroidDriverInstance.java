package demo.driver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidDriverInstance {

    public static AndroidDriver<AndroidElement> androidDriver;

    public static void initialize() {
        String appiumUrl = "http://127.0.0.1:4723/wd/hub/";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.0");
        caps.setCapability("deviceName", "device");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("newCommandTimeout", 120);
        caps.setCapability("app",
                System.getProperty("user.dir") + File.separator + "APK" + File.separator + "DANA-Pulsa-1.0.5.apk");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appWaitActivity", "id.dana.apprentech.danapulsa.ui.login." +
                "LoginActivity");
        try {
            androidDriver = new AndroidDriver<>(new URL(appiumUrl), caps);
            androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static AndroidDriver<AndroidElement> getWebDriver() {
        if (androidDriver == null) {
            initialize();
        }
        return androidDriver;
    }

    public static void quit() {
        androidDriver.quit();
    }

}
