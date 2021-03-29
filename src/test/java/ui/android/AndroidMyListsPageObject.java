package ui.android;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.MyListsPageObject;

public class AndroidMyListsPageObject extends MyListsPageObject {

    static {
        GO_TO_SELECTED_FOLDER  =  "id:org.wikipedia:id/item_title";
        FIND_TITLE_OF_ARTICLE_NAME_TPL = "xpath://*[contains(@text, '{ARTICLE_TITLE}')]";
    }

    public AndroidMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
