package ui.ios;

import io.appium.java_client.AppiumDriver;
import ui.NavigationUIPageObject;

public class IOSNavigationUIPageObject extends NavigationUIPageObject {
 static {
     EXIT_FROM_ARTICLE_NAVIGATE_BUTTON =  "xpath://XCUIElementTypeButton[@name='Back']";
     GO_TO_SAVED_FOLDERS_NAVIGATE_BUTTON = "xpath://XCUIElementTypeButton[@name='Saved']";
 }

    public IOSNavigationUIPageObject(AppiumDriver driver) {
        super(driver);
    }
}
