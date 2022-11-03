package org.tms.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.pages.CardPage;
import org.tms.services.LoginPageService;

public class CardPageTest extends BaseTest {

    private LoginPageService loginPageService;
    private CardPage cardPage;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
        cardPage = new CardPage();
        User user = new User();
        loginPageService.login(user).clickCardButton();
        cardPage.waitPageIsLoaded();
    }

    @Test
    public void verifyReturnToInventoryPageTest() {
        String actualTextOfInventoryPage = cardPage.clickContinueShoppingButton().getNameOfMainPageSectionText();
        String expectedTextOfInventoryPage = "PRODUCTS";
        Assert.assertEquals(actualTextOfInventoryPage, expectedTextOfInventoryPage,
                "The actual text of the page does not match expected!");
    }
}
