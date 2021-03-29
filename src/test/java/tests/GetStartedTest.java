package tests;
import io.appium.java_client.AppiumDriver;
import lib.CoreTestCase;
import lib.Platform;
import org.junit.Test;
import ui.WelcomePageObject;

public class GetStartedTest extends CoreTestCase {

    @Test
    public void testPassThroughWelcome() throws IllegalAccessException {

        if (Platform.getInstance().isIOS()){

        WelcomePageObject WelcomePage = new WelcomePageObject((AppiumDriver) driver);

        WelcomePage.waitForLearnMoreLink();
        WelcomePage.waitAndClickNextButton();
        WelcomePage.waitForNewWaysToExplore();
        WelcomePage.waitAndClickNextButton();
        WelcomePage.waitForSearchInNearly300Languagese();
        WelcomePage.waitAndClickNextButton();
        WelcomePage.waitForLearnMoreAboutDataCollected();
        WelcomePage.waitAndClickForGetStarted();

    } else {
        return;
        }
    }
}
