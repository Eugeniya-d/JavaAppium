package ui;

import io.appium.java_client.AppiumDriver;

abstract public class NavigationUIPageObject extends MainPageObject{
    public NavigationUIPageObject(AppiumDriver driver) {
        super(driver);
    }

    protected static String EXIT_FROM_ARTICLE_NAVIGATE_BUTTON;
    protected static String GO_TO_SAVED_FOLDERS_NAVIGATE_BUTTON;


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
}
