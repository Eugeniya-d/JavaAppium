package ui.factories;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.NavigationUIPageObject;
import ui.android.AndroidNavigationUIPageObject;
import ui.ios.IOSNavigationUIPageObject;
import ui.mobile_web.MWNavigationUIPageObject;

public class NavigationUIPageObjectFactory {

    public static NavigationUIPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidNavigationUIPageObject(driver);
        } else if (Platform.getInstance().isMW()) {
            return new MWNavigationUIPageObject(driver);
        }else {
            return new IOSNavigationUIPageObject(driver);
        }
    }
}
