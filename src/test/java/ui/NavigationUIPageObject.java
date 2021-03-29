package ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUIPageObject extends MainPageObject{


    public NavigationUIPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    protected static String EXIT_FROM_ARTICLE_NAVIGATE_BUTTON;
    protected static String GO_TO_SAVED_FOLDERS_NAVIGATE_BUTTON;
    protected static String OPEN_NAVIGATION;
    protected static String MY_LISTS_LINK;

    public void exitFromArticlePage() throws IllegalAccessException {
        this.waitForElementAndClick(EXIT_FROM_ARTICLE_NAVIGATE_BUTTON,
                "Cannot close the article",
                15);
    }

    public void goToSavedFolders() throws IllegalAccessException {
        this.waitForElementAndClick(GO_TO_SAVED_FOLDERS_NAVIGATE_BUTTON,
                "Cannot go to favorites folders",
                15);
    }

    public void openNavigation() throws IllegalAccessException {
        if (Platform.getInstance().isMW()) {
            this.waitForElementAndClick(OPEN_NAVIGATION,
                    "Cannot find and click open navigation button",
                    5);
        } else {
            System.out.println("Method openNavigation() do nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

        public void clickMyLists() throws IllegalAccessException {
            if (Platform.getInstance().isMW()) {
                this.tryClickElementsWithFewAttempts(
                        MY_LISTS_LINK,
                        "Cannot find navigation button to My list",
                        5
                );
            } else {
                this.waitForElementAndClick(
                        MY_LISTS_LINK,
                        "Cannot find navigation button to My list",
                        5
                );
            }
    }
}
