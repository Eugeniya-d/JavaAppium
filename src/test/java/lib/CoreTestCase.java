package lib;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.WelcomePageObject;

import java.io.FileOutputStream;
import java.util.Properties;

public class CoreTestCase {

    protected RemoteWebDriver driver;


    @Before
    @Step("Запуск сессии и драйвера")
    public void setUp() throws Exception {
        driver = Platform.getInstance().getDriver();
        this.createAllurePropertyFile();
        this.skipWelcomePageForIOSApp();
        this.openWikiwebPageForMW();
    }


    @After
    @Step("Окончание сессии и остановка драйвера")
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

    @Step("Пропуск WelcomePage для запуска на IOS")
    private void skipWelcomePageForIOSApp() throws IllegalAccessException {
        if (Platform.getInstance().isIOS()){
            AppiumDriver driver = (AppiumDriver) this.driver;
            WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
            WelcomePageObject.clickSkip();
        }
    }

    private void createAllurePropertyFile(){
        String path = System.getProperty("allure.results.directory");
        try {
            Properties props = new Properties();
            FileOutputStream fos = new FileOutputStream(path+ "/environment.properties");
            props.setProperty("Environment", Platform.getInstance().getPlatformVar());
            props.store(fos, "See https://github.com/allure-framework/allure-app/wiki/Environment");
            fos.close();
        } catch (Exception e){
            System.err.println("IO problem from Allure Properties file");
            e.printStackTrace();
        }
    }
}
