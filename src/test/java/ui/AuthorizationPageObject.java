package ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject  extends MainPageObject {

    private static final String
            LOGIN_BUTTON = "xpath://body/div/a[text()='Log in']",
            LOGIN_INPUT = "css:input[name='wpName']",
            PASSWORD_INPUT = "css:input[name='wpPassword']",
            SUBMIT = "css:button#wpLoginAttempt";

    public AuthorizationPageObject (RemoteWebDriver driver){
        super(driver);
    }

    public void clickAuthButton() throws IllegalAccessException {
        this.waitForElementPresent(LOGIN_BUTTON, "Cannot find auth button", 5);
        this.waitForElementAndClick(LOGIN_BUTTON, "Cannot find auth button", 5);
    }

    public void enterLoginData(String login, String password) throws IllegalAccessException {
        this.waitForElementAndSendKeys(LOGIN_INPUT, login, 5,"Cannot find and put a login to the login input");
        this.waitForElementAndSendKeys(PASSWORD_INPUT, password, 5,"Cannot find and put a password to the password input");
    }

    public void submitForm() throws IllegalAccessException {
        this.waitForElementAndClick(SUBMIT, "Cannot find and click submit auth button", 5);
    }
}

