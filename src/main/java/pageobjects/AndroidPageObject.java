package pageobjects;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class AndroidPageObject {
    private By id;

    /**
     * Perform action to click button or clickable element,
     * will wait until the element is enabled.
     * @param id locator of element
     */
    public void clickOn(By id) {
        waitUntilEnabled(id);
        AndroidElement button = androidDriver.findElement(id);
        button.click();
    }

    /**
     * Perform type action of input field elements,
     * will wait until element is displayed.
     * @param id locator of element
     * @param text user input text
     */
    public void typeON(By id, String text) {
        waitUntilDisplayed(id);
        AndroidElement field = androidDriver.findElement(id);
        field.clear();
        field.sendKeys(text);
    }

    /**
     * Perform wait condition until the element is presented.
     * @param id locator of element
     */
    public void waitUntilDisplayed(By id) {
        WebDriverWait wait = new WebDriverWait(androidDriver, 20);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(id));
        element.isDisplayed();
    }

    /**
     * Perform waiting condition until the element is available.
     * @param id locator of element
     */
    public void waitUntilEnabled(By id) {
        WebDriverWait wait = new WebDriverWait(androidDriver, 10);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(id));
        element.isEnabled();
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

    public void multipleID(String name, By locator){
        List<AndroidElement> filters = androidDriver.findElements(locator);
        for (AndroidElement filter : filters) {
            if (filter.getText().equalsIgnoreCase(name)) {
                filter.click();
                break;
            }
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean checkElement(By locator){
        List<AndroidElement> providerIcon = androidDriver. findElements (locator);
        return providerIcon.size()> 0;
    }
    /**
     * Perform getting text from pop up dialog box
     * @param id locator of element
     * @return return condition
     */
    public String getText(By id) {
        WebElement text = androidDriver.findElement(id);
        return text.getText();
    }

//    public boolean checkIfToastDisplayed(By id) {
//        WebElement toast = androidDriver.findElement(id);
//        return toast.isDisplayed();
//    }
}
