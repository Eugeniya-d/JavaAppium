package ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import ui.NavigationUIPageObject;
import ui.android.AndroidNavigationUIPageObject;
import ui.ios.IOSNavigationUIPageObject;

public class NavigationUIPageObjectFactory {

    public static NavigationUIPageObject get(AppiumDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidNavigationUIPageObject(driver);
        } else {
            return new IOSNavigationUIPageObject(driver);
        }
    }
}
