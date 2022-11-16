package org.tms.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.services.LoginPageService;

public class LoginPageTest extends BaseTest {

    private LoginPageService loginPageService;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
    }

    @Test(description = "Log In Test")
    public void verifyLoginTest() {
        User user = new User();
        String actualTextOfInventoryPage = loginPageService.login(user)
                .getNameOfMainPageSectionText();
        String expectedTextOfInventoryPage = "PRODUCTS";
        Assert.assertEquals(actualTextOfInventoryPage, expectedTextOfInventoryPage,
                "The actual text of the page does not match expected!");
    }
}
