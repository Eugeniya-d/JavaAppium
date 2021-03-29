package ui.mobile_web;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.NavigationUIPageObject;

public class MWNavigationUIPageObject extends NavigationUIPageObject {
    static {
        MY_LISTS_LINK = "css:a[data-event-name='watchlist']";
        OPEN_NAVIGATION = "css:#mw-mf-main-menu-button";
    }

    public MWNavigationUIPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
