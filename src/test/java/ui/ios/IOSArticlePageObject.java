package ui.ios;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.ArticlePageObject;


public class IOSArticlePageObject extends ArticlePageObject {

    static {
        ARTICLE_TO_FAVORITE_LIST_BUTTON = "xpath://XCUIElementTypeButton[@name='save']";
        CONFIRM_ARTICLE_SELECTION_BUTTON = "xpath://XCUIElementTypeButton[@name='places auth close']";
        STRING_NAME_OF_FOLDER = "xpath://XCUIElementTypeButton[@name='Back']";
        CONFIRM_ARTICLE_ADDICTION = "xpath://*[contains(@text, 'OK')]";
        ADD_ARTICLE_TO_EXISTING_FOLDER_TPL = "xpath://*[contains(@text, '{NAME_OF_FOLDER}')]";
    }

    public IOSArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}

