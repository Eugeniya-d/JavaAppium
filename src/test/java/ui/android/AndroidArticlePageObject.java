package ui.android;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject{
    static {
        ARTICLE_TO_FAVORITE_LIST_BUTTON = "xpath://ui.android.widget.LinearLayout/ui.android.support.v7.app.ActionBar.Tab/ui.android.widget.ImageView[@content-desc='Add this article to a reading list']";
        CONFIRM_ARTICLE_SELECTION_BUTTON = "xpath://*[contains(@text, 'GOT IT')]";
        STRING_NAME_OF_FOLDER = "id:org.wikipedia:id/text_input";
        CONFIRM_ARTICLE_ADDICTION = "xpath://*[contains(@text, 'OK')]";
        ADD_ARTICLE_TO_EXISTING_FOLDER_TPL = "xpath://*[contains(@text, '{NAME_OF_FOLDER}')]";
    }
    public AndroidArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
