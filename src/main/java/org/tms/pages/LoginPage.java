package org.tms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tms.utils.MessageLogger;

public class LoginPage extends BasePage {

    private static final String FILL_IN_USERNAME_PROCESS_NAME = "Fill in Username";
    private static final String FILL_IN_PASSWORD_PROCESS_NAME = "Fill in Password";
    private static final String CLICK_LOGIN_BUTTON_PROCESS_NAME = "Click Login button";
    private static final String LOADING_PAGE_PROCESS_NAME = "Login Page loading";
    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    public LoginPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public LoginPage fillInUsername(String userName) {
        MessageLogger.logStartProcessInfo(FILL_IN_USERNAME_PROCESS_NAME);
        username.clear();
        username.sendKeys(userName);
        MessageLogger.logEndProcessInfo(FILL_IN_USERNAME_PROCESS_NAME);
        return this;
    }

    public LoginPage fillInPassword(String keyPassword) {
        MessageLogger.logStartProcessInfo(FILL_IN_PASSWORD_PROCESS_NAME);
        password.clear();
        password.sendKeys(keyPassword);
        MessageLogger.logEndProcessInfo(FILL_IN_PASSWORD_PROCESS_NAME);
        return  this;
    }

    public InventoryPage clickLoginButton() {
        MessageLogger.logStartProcessInfo(CLICK_LOGIN_BUTTON_PROCESS_NAME);
        loginButton.click();
        MessageLogger.logEndProcessInfo(CLICK_LOGIN_BUTTON_PROCESS_NAME);
        return new InventoryPage();
    }

    public LoginPage waitPageIsLoaded() {
        waitVisibilityOf(loginButton);
        MessageLogger.logEndProcessInfo(LOADING_PAGE_PROCESS_NAME);
        return this;
    }
}
