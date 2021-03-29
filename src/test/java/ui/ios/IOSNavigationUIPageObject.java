package ui.ios;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.NavigationUIPageObject;

public class IOSNavigationUIPageObject extends NavigationUIPageObject {
 static {
     EXIT_FROM_ARTICLE_NAVIGATE_BUTTON =  "xpath://XCUIElementTypeButton[@name='Back']";
     GO_TO_SAVED_FOLDERS_NAVIGATE_BUTTON = "xpath://XCUIElementTypeButton[@name='Saved']";
 }

    public IOSNavigationUIPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
