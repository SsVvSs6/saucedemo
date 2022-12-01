package org.tms.services;

import io.qameta.allure.Step;
import org.tms.model.User;
import org.tms.pages.InventoryPage;
import org.tms.pages.LoginPage;
import org.tms.utils.MessageLogger;

public class LoginPageService {

    private static final String LOGIN_PAGE_URL = "https://www.saucedemo.com/";
    private static final String LOGIN_STEP_NAME = "Authorization";
    protected LoginPage loginPage = new LoginPage();

    @Step(LOGIN_STEP_NAME)
    public InventoryPage login(User user) {
        MessageLogger.logStartProcessInfo(LOGIN_STEP_NAME);
        loginPage.openPage(LOGIN_PAGE_URL)
                .waitPageIsLoaded()
                .fillInUsername(user.getLogin())
                .fillInPassword(user.getPassword())
                .clickLoginButton()
                .waitPageIsLoaded();
        MessageLogger.logEndProcessInfo(LOGIN_STEP_NAME);
        return new InventoryPage();
    }
}
