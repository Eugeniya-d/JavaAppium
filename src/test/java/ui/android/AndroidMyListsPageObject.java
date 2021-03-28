package ui.android;

import io.appium.java_client.AppiumDriver;
import ui.MyListsPageObject;

public class AndroidMyListsPageObject extends MyListsPageObject {

    static {
        GO_TO_SELECTED_FOLDER  =  "id:org.wikipedia:id/item_title";
        FIND_TITLE_OF_ARTICLE_NAME_TPL = "xpath://*[contains(@text, '{ARTICLE_TITLE}')]";
    }

    public AndroidMyListsPageObject(AppiumDriver driver) {
        super(driver);
    }
}
