package ui.mobile_web;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.ArticlePageObject;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        ARTICLE_TO_FAVORITE_LIST_BUTTON = "css:#page-actions-watch a#ca-watch";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "css:#page-actions-watch a#ca-watch";
        CONFIRM_ARTICLE_SELECTION_BUTTON = "xpath://XCUIElementTypeButton[@name='places auth close']";
    }

    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
