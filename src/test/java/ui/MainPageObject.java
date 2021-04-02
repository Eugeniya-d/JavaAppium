package ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Attachment;
import lib.Platform;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

public class MainPageObject {
    protected RemoteWebDriver driver;

    public MainPageObject(RemoteWebDriver driver) {
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

    public void tryClickElementsWithFewAttempts(String locator, String errorMessage ,int amountOfAttempts) throws IllegalAccessException {
        int currentAttempts = 0;
        boolean needMoreAttempts = true;

        while (needMoreAttempts)
        {
            try{
                this.waitForElementAndClick(locator, errorMessage, 1);
                needMoreAttempts = false;
            } catch (Exception e){
                if (currentAttempts > amountOfAttempts){
                    this.waitForElementAndClick(locator, errorMessage, 1);
                }
            }
            ++ currentAttempts;
        }
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

    public boolean isElementPresent(String locator) throws IllegalAccessException {
        return getAmountOfElements(locator)>0;
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
        if (driver instanceof AppiumDriver){
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

        TouchAction action = new TouchAction((AppiumDriver) driver);
            TouchAction press = action.press(PointOption.point(rightX, middleY));
            press.
                    waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                    .moveTo(PointOption.point(offsetX, 0)).
                    release().perform();
        }else {
            System.out.println("Method swipeElementToLeft() do nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void clickElementToTheRightUpperCorner(String locator, String error_message) throws IllegalAccessException {
        if (driver instanceof AppiumDriver){
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

            TouchAction action = new TouchAction((AppiumDriver)driver);
            action.tap(PointOption.point(pointToClickX, pointToClickY)).perform();
        } else {
            System.out.println("Method clickElementToTheRightUpperCorner() do nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    private By getLocatorByString(String locatorWithType) throws IllegalAccessException {

        String[] explodedLocator = locatorWithType.split(Pattern.quote(":"), 2);
        String byType = explodedLocator[0];
        String locator = explodedLocator[1];

        if (byType.equals("xpath")) {
            return By.xpath(locator);
        } else if (byType.equals("id")) {
            return By.id(locator);
        }  else if (byType.equals("css")) {
            return By.cssSelector(locator);
        }else {
            throw new IllegalAccessException("Cannot det type of locator. Locator :"+ locatorWithType);
        }
    }
    public String takeScreenshot(String name){
        TakesScreenshot ts = (TakesScreenshot)this.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/" + name + "_screenshot.png";
        try{
            FileUtils.copyFile(source, new File(path));
            System.out.println("The screenshot was taken: " + path);
        } catch (Exception e) {
            System.out.println("Cannot take screenshot. Error: " + e.getMessage());
        }
        return path;
    }

    @Attachment
    public static byte[] screensshot(String path){
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            System.out.println("Cannot get bytes from screenshot. Error: "+ e.getMessage());
        }
        return bytes;
    }
}
