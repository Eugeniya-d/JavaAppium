package ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.regex.Pattern;

public class MainPageObject {
    protected AppiumDriver driver;

    public MainPageObject(AppiumDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementPresent(String locator, String errorTextMessage, long timeoutInSeconds) throws IllegalAccessException {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorTextMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public Boolean waitForElementNotPresent(String locator, String errorTextMessage, long timeoutInSeconds) throws IllegalAccessException {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorTextMessage + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public String assertElementHasText(String locator, String expectedText, String errorTextMessage) throws Exception {
        WebElement element = waitForElementPresent(locator, errorTextMessage, 5);
        String actualText = element.getAttribute("text");
        if (actualText.equals(expectedText)) {
            return actualText;
        } else
            throw new Exception(errorTextMessage);
    }

    public boolean assertElementContainsText(String locator, String expectedText, String errorTextMessage) throws Exception {
        By by = this.getLocatorByString(locator);
        WebElement element = waitForElementPresent(locator, errorTextMessage, 5);
        String actualText = element.getAttribute("text");
        if (actualText.contains(expectedText)) {
            return true;
        } else
            throw new Exception(errorTextMessage);
    }

    public void assertElementPresent(String locator, String errorTextMessage) throws Exception {
        By by = this.getLocatorByString(locator);
        int amountOfElements = getAmountOfElements(locator);
        if (amountOfElements <= 0) {
            String defaultMessage = "'An element'" + by.toString() + "'supposed to be present";
            throw new AssertionError(defaultMessage + " " + errorTextMessage);
        }
    }

    public int getAmountOfElements(String locator) throws IllegalAccessException {
        By by = this.getLocatorByString(locator);
        List elements = driver.findElements(by);
        return elements.size();
    }


    public WebElement waitForElementAndClick(String locator, String errorTextMessage, long timeoutInSeconds) throws IllegalAccessException {
        WebElement element = waitForElementPresent(locator, errorTextMessage, timeoutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(String locator, String errorTextMessage, long timeoutInSeconds, String value) throws IllegalAccessException {
        WebElement element = waitForElementPresent(locator, errorTextMessage, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    public WebElement waitForElementAndClear(String locator, String errorTextMessage, long timeoutInSeconds) throws IllegalAccessException {
        WebElement element = waitForElementPresent(locator, errorTextMessage, timeoutInSeconds);
        element.clear();
        return element;
    }

    public void swipeElementToLeft(String locator,String errorTextMessage) throws IllegalAccessException {
        WebElement element =  waitForElementPresent(
                locator,
                errorTextMessage,
                10);
        int leftX = element.getLocation().getX();
        int rightX = leftX + element.getSize().getWidth();
        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();
        int middleY = (upperY + lowerY)/ 2;
        int offsetX = (-1 * element.getSize().getWidth());

        TouchAction action = new TouchAction(driver);
                action.press(rightX, middleY);
                action.waitAction(300)
                .moveTo(offsetX, 0).
                release().perform();
    }

    public void clickElementToTheRightUpperCorner(String locator, String error_message) throws IllegalAccessException {
            WebElement element = this.waitForElementPresent(locator + "/..",
                    error_message,
                    10);
            int rightX = element.getLocation().getX();
            int upperY = element.getLocation().getY();
            int lowerY = upperY + element.getSize().getHeight();
            int middleY = (upperY + lowerY) / 2;
            int width = element.getSize().getWidth();

            int pointToClickX = (rightX + width) - 3;
            int pointToClickY = middleY;

            TouchAction action = new TouchAction(driver);
            action.tap(pointToClickX, pointToClickY).perform();
        }

    private By getLocatorByString(String locatorWithType) throws IllegalAccessException {

        String[] explodedLocator = locatorWithType.split(Pattern.quote(":"), 2);
        String byType = explodedLocator[0];
        String locator = explodedLocator[1];

        if (byType.equals("xpath")) {
            return By.xpath(locator);
        } else if (byType.equals("id")) {
            return By.id(locator);
        } else {
            throw new IllegalAccessException("Cannot det type of locator. Locator :"+ locatorWithType);
        }
    }


}
