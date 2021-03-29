package ui;

import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListsPageObject extends MainPageObject{
    protected static String SECOND_ELEMENT_IN_FAVORITE_LIST_XPATH;
    protected static String TYPE_IMAGE_OF_ARTICLE;
    protected static String GO_TO_SELECTED_FOLDER;
    protected static String FIND_TITLE_OF_ARTICLE_NAME_TPL;
    protected static String FIRST_ARTICLE_TITLE_XPATH;

    /* TEMPLATES METHODS */
    public static String getArticleTitle(String articleTitle) {
        return FIND_TITLE_OF_ARTICLE_NAME_TPL.replace("{ARTICLE_TITLE}", articleTitle);
    }
    /* TEMPLATES METHODS */

    public MyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void goToSelectedFolder() throws IllegalAccessException {
        this.waitForElementAndClick(GO_TO_SELECTED_FOLDER,
                "Cannot find folder",
                15);
    }

    public void waitForTitle(String articleTitle) throws IllegalAccessException {
        String getArticleTitle = getArticleTitle(articleTitle);
        this.waitForElementPresent(getArticleTitle,
                "Cannot find title with name " + articleTitle,
                10);
    }

    public void deleteArticle(String articleTitle) throws IllegalAccessException {
        String getArticleTitle = getArticleTitle(articleTitle);
        this.swipeElementToLeft(getArticleTitle,
                "Cannot find title with name " + articleTitle);
    }

    public void waitNotForTitle(String articleTitle) throws IllegalAccessException {
        String getArticleTitle = getArticleTitle(articleTitle);
        this.waitForElementNotPresent(getArticleTitle,
                "Cannot delete the saved article" + articleTitle,
                10);
    }
    public void waitForArticleToDisappearByTitleForMW() throws IllegalAccessException {
        String article_xpath = SECOND_ELEMENT_IN_FAVORITE_LIST_XPATH;
        this.waitForElementNotPresent((article_xpath), "Saved article still present with title ", 15);
    }

    public void waitNotForTypeImage() throws IllegalAccessException {
        this.waitForElementNotPresent(TYPE_IMAGE_OF_ARTICLE, 
                "Type Image of element is present on screen",
                15);
    }

    public void swipeToDeleteArticleForIOS() throws IllegalAccessException {
        this.waitForElementPresent(
                FIRST_ARTICLE_TITLE_XPATH,
                "Cannot find the article",
                5
        );
        this.swipeElementToLeft(
                FIRST_ARTICLE_TITLE_XPATH,
                "Cannot delete article"
        );
        clickElementToTheRightUpperCorner(FIRST_ARTICLE_TITLE_XPATH,
                "Cannot find the element");
    }

    public void swipeByArticleToDeleteForMW() throws IllegalAccessException {
        this.waitForElementPresent(
                SECOND_ELEMENT_IN_FAVORITE_LIST_XPATH,
                "Cannot find the second element in MW list",
                30
        );
        this.waitForElementAndClick(
                SECOND_ELEMENT_IN_FAVORITE_LIST_XPATH,
                "Cannot find the second element in MW list",
                30
        );
        driver.navigate().refresh();
        this.waitForArticleToDisappearByTitleForMW();
    }
}


