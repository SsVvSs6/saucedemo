package org.tms.services;

import org.tms.model.User;
import org.tms.pages.InventoryPage;
import org.tms.pages.LoginPage;

public class LoginPageService {

    private static final String LOGIN_PAGE_URL = "https://www.saucedemo.com/";
    protected LoginPage loginPage = new LoginPage();
    protected InventoryPage inventoryPage = new InventoryPage();

    public InventoryPage login(User user) {
        loginPage.openPage(LOGIN_PAGE_URL)
                .waitPageIsLoaded()
                .fillInUsername(user.getLogin())
                .fillInPassword(user.getPassword())
                .clickLoginButton();
        inventoryPage.waitPageIsLoaded();
        return new InventoryPage();
    }
}
