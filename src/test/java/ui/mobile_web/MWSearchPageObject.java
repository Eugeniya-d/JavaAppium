package ui.mobile_web;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.SearchPageObject;

public class MWSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class,'wikidata-description')][contains(text(),{SUBSTRING}')]";
        SEARCH_CANCEL_BUTTON = "id:clear mini";
        SEARCH_CLEAR_STRING_BUTTON = "css:button.cancel";
        FIND_TITLE_OF_ARTICLE_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{ARTICLE_TITLE}')]";
        FIND_DESCRIPTION_OF_ARTICLE_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{ARTICLE_DESCRIPTION}')]";
    }

    public MWSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
