package pageobjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.Setting;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Base64;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class AndroidPageObject {
    private By id;

    /**
     * Perform action to click button or clickable element,
     * will wait until the element is enabled.
     * @param id locator of element
     */
    public void clickOn(By id) {
        if (waitUntilEnabled(id)) {
            AndroidElement button = androidDriver.findElement(id);
            button.click();
        }
    }

    /**
     * Perform type action of input field elements,
     * will wait until element is displayed.
     * @param id locator of element
     * @param text user input text
     */
    public void typeOn(By id, String text) {
        AndroidElement field = androidDriver.findElement(id);
        field.clear();
        field.sendKeys(text);
    }

    /**
     * Perform wait condition until the element is presented.
     * @param id locator of element
     */
    public boolean waitUntilDisplayed(By id) {
        WebDriverWait wait = new WebDriverWait(androidDriver, 10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(id)).isDisplayed();
    }

    /**
     * Perform waiting condition untill the element is available.
     * @param id locator of element
     */
    public boolean waitUntilEnabled(By id) {
        WebDriverWait wait = new WebDriverWait(androidDriver, 5);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(id));
        return element.isEnabled();
    }

    /**
     * Perform checking if element status is displayed and returning true condition
     * @param id locator of element
     * @return return condition
     */
    public boolean checkIfDisplayed(By id) {
        WebElement element = androidDriver.findElement(id);
        return element.isDisplayed();
    }

    /**
     * Perform checking if element status is enabled and returning true condition
     * @param id locator of element
     * @return return condition
     */
    public boolean checkIfEnabled(By id) {
        WebElement element = androidDriver.findElement(id);
        return element.isEnabled();
    }

    /**
     * Perform checking if toast is appeared and returning true condition
     * @param id locator of element
     * @return return condition
     */
    public String checkToast(By id) {
        WebElement toast = androidDriver.findElement(id);
        return toast.getAttribute("name");
    }

    public Path getResource(String fileName) throws URISyntaxException {
        URL refImgUrl = getClass().getClassLoader().getResource(fileName);
        return Paths.get(refImgUrl.toURI()).toFile().toPath();
    }

    public String getResourceB64(String fileName) throws URISyntaxException, IOException {
        Path refImgPath = getResource(fileName);
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgPath));
    }

    public String getReferenceImageB64(String fileName) throws URISyntaxException, IOException {
        return getResourceB64("images/" + fileName);
    }

    /**
     * Perform checking an element by image and returning true if found
     * @param imageFileName image file name on src > test > resources > images
     * @return return condition
     */
    public boolean elementByImageFound(String imageFileName) throws IOException, URISyntaxException {
        androidDriver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.95);
        String imageReference = getReferenceImageB64(imageFileName);
        boolean visible = false;
        int count = 0, maxCount = 1;
        while (!visible && count < maxCount) {
            count += 1;
            try {
                androidDriver.findElement(MobileBy.image(imageReference));
                visible = true;
            } catch (NoSuchElementException ign) {
                System.out.println("element by image not found");
            }
        }
        return visible;
    }

    /**
     * Perform press and hold on specified web element
     * @param element EditText element
     */
    public void pressHoldOnElement(WebElement element) {
        int holdX = (int) (element.getLocation().x + element.getSize().getWidth() * 0.5 - 10);
        int holdY = (int) (element.getLocation().y + element.getSize().getHeight() * 0.5);
        TouchAction action = new TouchAction(androidDriver);
        action.longPress(PointOption.point(holdX, holdY))
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .release()
                .perform();
    }

    /**
     * Perform tap on selected element that found by image
     * @param imageFileName file name on src > test > resources > images
     */
    public void tapOnImage(String imageFileName) throws IOException, URISyntaxException {
        androidDriver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.9);
        String imageReference = getReferenceImageB64(imageFileName);
        boolean visible = false;
        int count = 0, maxCount = 2;
        while (!visible && count < maxCount) {
            count += 1;
            try {
                androidDriver.findElement(MobileBy.image(imageReference)).click();
                visible = true;
            } catch (NoSuchElementException ign) {
                System.out.println("element by image not found");
            }
        }
    }
}
