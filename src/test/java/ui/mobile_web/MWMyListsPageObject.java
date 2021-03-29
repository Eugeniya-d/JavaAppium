package ui.mobile_web;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.MyListsPageObject;

public class MWMyListsPageObject extends MyListsPageObject {
    static {
        FIRST_ARTICLE_TITLE_XPATH = "xpath://XCUIElementTypeStaticText[@name='Java (programming language)']";
        TYPE_IMAGE_OF_ARTICLE = "xpath://XCUIElementTypeApplication[@name='Wikipedia']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther[2]/XCUIElementTypeImage";
    }

    public MWMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
