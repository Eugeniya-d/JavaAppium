package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePageObject extends MainPageObject{
    private static final String LEARN_MORE_LINK = "xpath://*[@name='Learn more about Wikipedia']";
    private static final String NEXT_BUTTON = "id:Next";
    private static final String NEW_WAVES_EXPLORE_LINK = "id:New ways to explore";
    private static final String SEARCH_IN_NEARLY_300_LANG_LINK = "id:Search in nearly 300 languages";
    private static final String LEARN_MORE_ABOUT_DATA_COLLECT_LINK = "id:Learn more about data collected";
    private static final String GET_STARTED_BUTTON = "xpath://XCUIElementTypeStaticText[@name='Get started']";
    private static final String SKIP_BUTTON = "xpath://*[@name='Skip']";


    public WelcomePageObject(AppiumDriver driver) {
        super(driver);
    }

    public void clickSkip() throws IllegalAccessException {
        this.waitForElementAndClick(SKIP_BUTTON,
                "Cannot find and click skip button",
                10   );
    }

    public void waitForLearnMoreLink() throws IllegalAccessException {
        this.waitForElementPresent(LEARN_MORE_LINK,
                "Cannot find 'Learn more about Wikipedia' link",
                10    );
    }

    public void waitAndClickNextButton() throws IllegalAccessException {
        this.waitForElementAndClick(NEXT_BUTTON,
                "Cannot find 'Next' button",
                10    );
    }

    public void waitForNewWaysToExplore() throws IllegalAccessException {
        this.waitForElementPresent(NEW_WAVES_EXPLORE_LINK,
                "Cannot find 'New ways to explore' link",
                10    );
    }

    public void waitForSearchInNearly300Languagese() throws IllegalAccessException {
        this.waitForElementPresent(SEARCH_IN_NEARLY_300_LANG_LINK,
                "Cannot find 'Search in nearly 300 languages' link",
                10    );
    }

    public void waitForLearnMoreAboutDataCollected() throws IllegalAccessException {
        this.waitForElementPresent(LEARN_MORE_ABOUT_DATA_COLLECT_LINK,
                "Cannot find 'Learn more about data collected' link",
                10    );
    }

    public void waitAndClickForGetStarted() throws IllegalAccessException {
        this.waitForElementPresent(GET_STARTED_BUTTON,
                "Cannot find 'Get started' button",
                10    );
    }
}
