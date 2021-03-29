package ui.android;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject {
    static {
    SEARCH_INIT_ELEMENT = "xpath://*[contains(@text, 'Search Wikipedia')]";
    SEARCH_INPUT = "xpath://*[contains(@text, 'Search…')]";
    SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id ='org.wikipedia:id/page_list_item_container']//*[@text ='{SUBSTRING}']";
    SEARCH_CANCEL_BUTTON = "xpath://*[@resource-id ='org.wikipedia:id/search_close_btn']";
    SEARCH_CLEAR_STRING_BUTTON = "xpath://*[@resource-id ='org.wikipedia:id/search_src_text']";
    FIND_TITLE_OF_ARTICLE_TPL = "xpath://*[contains(@text, '{ARTICLE_TITLE}')]";
    FIND_DESCRIPTION_OF_ARTICLE_TPL = "xpath://*[contains(@text, '{ARTICLE_DESCRIPTION}')]";
    }

    public AndroidSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
