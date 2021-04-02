package lib;

import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.WelcomePageObject;

public class CoreTestCase {

    protected RemoteWebDriver driver;


    @Before
    public void setUp() throws Exception {
        driver = Platform.getInstance().getDriver();
        this.skipWelcomePageForIOSApp();
        this.openWikiwebPageForMW();
    }


    @After
    public void tearDown(){
        driver.quit();
    }

    protected void openWikiwebPageForMW(){
        if (Platform.getInstance().isMW()){
            driver.get("https://en.m.wikipedia.org");
        } else {
            System.out.println("Method openWikiwebPageForMW() do nothing for platform " +  Platform.getInstance().getPlatformVar());
        }
    }

    private void skipWelcomePageForIOSApp() throws IllegalAccessException {
        if (Platform.getInstance().isIOS()){
            AppiumDriver driver = (AppiumDriver) this.driver;
            WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
            WelcomePageObject.clickSkip();
        }
    }
}
