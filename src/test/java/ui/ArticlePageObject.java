package ui;

import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;


abstract public class ArticlePageObject extends MainPageObject {
    protected static String ARTICLE_TO_FAVORITE_LIST_BUTTON;
    protected static String CONFIRM_ARTICLE_SELECTION_BUTTON;
    protected static String STRING_NAME_OF_FOLDER;
    protected static String CONFIRM_ARTICLE_ADDICTION;
    protected static String ADD_ARTICLE_TO_EXISTING_FOLDER_TPL;
    protected static String OPTIONS_REMOVE_FROM_MY_LIST_BUTTON;
    protected static String TITLE_ELEMENT;

    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getFolderName(String folderName) {
        return ADD_ARTICLE_TO_EXISTING_FOLDER_TPL.replace("{NAME_OF_FOLDER}", folderName);
    }
    /* TEMPLATES METHODS */

    public void addArticleToFavoriteList() throws IllegalAccessException {
        this.waitForElementAndClick(ARTICLE_TO_FAVORITE_LIST_BUTTON,
                "Cannot find 'Add this article to favorites' button",
                5);
    }

    public void confirmArticleSelection() throws IllegalAccessException {
        this.waitForElementAndClick(CONFIRM_ARTICLE_SELECTION_BUTTON,
                "Cannot find button with text 'GOT IT'",
                5);
    }

    public void clearDefaultNameOfFolder() throws IllegalAccessException {
        this.waitForElementAndClear(STRING_NAME_OF_FOLDER,
                "Cannot clear default folder name",
                15);
    }


    public void giveArticleNewName(String name) throws IllegalAccessException {
        this.waitForElementAndSendKeys(STRING_NAME_OF_FOLDER,
                "Cannot give new name for article",
                15,
                name);
    }

    public void confirmArticleAddiction() throws IllegalAccessException {
        this.waitForElementAndClick(CONFIRM_ARTICLE_ADDICTION,
                "Cannot add new folder",
                5);
    }

    public void addArticleToExistingFolder(String folderName) throws IllegalAccessException {
        if (Platform.getInstance().isMW()) {
            removeArticleFromSavedIfItAdded();
        }
        String getFolderName = getFolderName(folderName);
        this.waitForElementAndClick(getFolderName,
                "Cannot find folder with name " + folderName,
                5);
    }

    public void removeArticleFromSavedIfItAdded() throws IllegalAccessException {
        if (this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)) {
            this.waitForElementAndClick(
                    OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                    "Cannot click button to remove an article from saved",
                    1
            );
            this.waitForElementPresent(
                    ARTICLE_TO_FAVORITE_LIST_BUTTON,
                    "Cannot find button to add an article to saved list after removing it from this list before",
                    5
            );
        }
    }

    public WebElement waitForTitleElement() throws IllegalAccessException {
        return this.waitForElementPresent(TITLE_ELEMENT,
                "Cannot find this article title",
                15);
    }

    public String getArticleTitle() throws IllegalAccessException {
        WebElement title_element = waitForTitleElement();
        return title_element.getText();
    }
}
