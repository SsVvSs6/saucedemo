package org.tms.services;

import io.qameta.allure.Step;
import org.tms.model.User;
import org.tms.pages.InventoryPage;
import org.tms.pages.LoginPage;

public class LoginPageService {

    private static final String LOGIN_PAGE_URL = "https://www.saucedemo.com/";
    protected LoginPage loginPage = new LoginPage();

    @Step("Authorization")
    public InventoryPage login(User user) {
        loginPage.openPage(LOGIN_PAGE_URL)
                .waitPageIsLoaded()
                .fillInUsername(user.getLogin())
                .fillInPassword(user.getPassword())
                .clickLoginButton()
                .waitPageIsLoaded();
        return new InventoryPage();
    }
}
