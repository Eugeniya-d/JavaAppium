package ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.NavigationUIPageObject;
import ui.android.AndroidNavigationUIPageObject;
import ui.ios.IOSNavigationUIPageObject;

public class NavigationUIPageObjectFactory {

    public static NavigationUIPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidNavigationUIPageObject(driver);
        } else {
            return new IOSNavigationUIPageObject(driver);
        }
    }
}
