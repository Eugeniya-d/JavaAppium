package tests;
import lib.CoreTestCase;
import lib.Platform;
import org.junit.Test;
import ui.WelcomePageObject;

public class GetStartedTest extends CoreTestCase {

    @Test
    public void testPassThroughWelcome() throws IllegalAccessException {

        if (Platform.getInstance().isAndroid()){
            return;
        }
        WelcomePageObject WelcomePage = new WelcomePageObject(driver);

        WelcomePage.waitForLearnMoreLink();
        WelcomePage.waitAndClickNextButton();
        WelcomePage.waitForNewWaysToExplore();
        WelcomePage.waitAndClickNextButton();
        WelcomePage.waitForSearchInNearly300Languagese();
        WelcomePage.waitAndClickNextButton();
        WelcomePage.waitForLearnMoreAboutDataCollected();
        WelcomePage.waitAndClickForGetStarted();

    }
}
