package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import ui.WelcomePageObject;

public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;



    @Override
    protected void setUp() throws Exception {
        super.setUp();
        driver = Platform.getInstance().getDriver();
        driver.rotate(ScreenOrientation.PORTRAIT);
        this.skipWelcomePageForIOSApp();
    }


    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }

    private void skipWelcomePageForIOSApp() throws IllegalAccessException {
        if (Platform.getInstance().isIOS()){
            WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
            WelcomePageObject.clickSkip();
        }
    }
}
