package ui.android;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.NavigationUIPageObject;

public class AndroidNavigationUIPageObject extends NavigationUIPageObject {
    static {
    EXIT_FROM_ARTICLE_NAVIGATE_BUTTON =  "xpath://ui.android.widget.ImageButton[@content-desc='Navigate up']";
    GO_TO_SAVED_FOLDERS_NAVIGATE_BUTTON = "xpath://ui.android.widget.FrameLayout[@content-desc='My lists']";
    }

    public AndroidNavigationUIPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
