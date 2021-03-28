package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

abstract public class SearchPageObject extends MainPageObject {

    protected static String SEARCH_INIT_ELEMENT;
    protected static String SEARCH_INPUT;
    protected static String SEARCH_RESULT_BY_SUBSTRING_TPL;
    protected static String SEARCH_CANCEL_BUTTON;
    protected static String SEARCH_CLEAR_STRING_BUTTON;
    protected static String FIND_TITLE_OF_ARTICLE_TPL;
    protected static String FIND_DESCRIPTION_OF_ARTICLE_TPL;


    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getArticleTitle(String title) {
        return FIND_TITLE_OF_ARTICLE_TPL.replace("{ARTICLE_TITLE}", title);
    }

    private static String getArticleDescription(String description) {
        return FIND_DESCRIPTION_OF_ARTICLE_TPL.replace("{ARTICLE_DESCRIPTION}", description);
    }

    /* TEMPLATES METHODS */


    public void initSearchInput() throws IllegalAccessException {
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT,
                "Cannot find element with text 'Search Wikipedia'",
                5);
        this.waitForElementPresent(SEARCH_INIT_ELEMENT,
                "Cannot search the element input after click",
                5);
    }

    public void typeSearchLine(String searchLine) throws IllegalAccessException {
        this.waitForElementAndSendKeys(SEARCH_INPUT,
                "Cannot find search input",
                5,
                searchLine);
    }

    public void waitForSearchResult(String substring) throws IllegalAccessException {
        String searchResultXpath = getSearchElement(substring);
        this.waitForElementPresent(searchResultXpath,
                "Cannot find search result with substring" + substring,
                5);
    }

    public void waitForCancelButtonToAppear() throws IllegalAccessException {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON,
                "Cannot find search field",
                5);
    }

    public void clearStringSearch() throws IllegalAccessException {
        this.waitForElementAndClear(SEARCH_CLEAR_STRING_BUTTON,
                "Cannot find search field",
                5);
    }

    public void waitForCancelButtonToDisappear() throws IllegalAccessException {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON,
                "Search cancel button is stiil present",
                5);
    }

    public void clickCancelSearch() throws IllegalAccessException {
        this.waitForElementAndClear(SEARCH_CANCEL_BUTTON,
                "Cannot find search and click cancel button",
                5);
    }

    public void goToTitle(String articleTitle) throws IllegalAccessException {
        String getArticleTitle = getArticleTitle(articleTitle);
        this.waitForElementAndClick(getArticleTitle,
                "Cannot find title with name " + articleTitle,
                10);
    }

    public void waitForTitlePresent(String articleTitle) throws IllegalAccessException {
        String getArticleTitle = getArticleTitle(articleTitle);
        this.waitForElementPresent(getArticleTitle,
                "Article " + articleTitle + " not presented",
                0);
    }

    public void waitForElementByTitleAndDescription(String title, String description) throws IllegalAccessException {
        String getArticleTitle = getArticleTitle(title);
        String getArticleDescription = getArticleDescription(description);
        this.waitForElementPresent(getArticleTitle,
                "Article with title " + title + " and description " + description + " not presented",
                15);
        this.waitForElementPresent(getArticleDescription,
                "Article with title " + title + " and description " + description + " not presented",
                15);
    }

}

