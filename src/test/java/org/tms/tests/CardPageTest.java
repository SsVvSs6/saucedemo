package org.tms.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.services.CardService;
import org.tms.services.LoginPageService;

public class CardPageTest extends BaseTest {

    private LoginPageService loginPageService;
    private CardService cardService;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
        User user = new User();
        loginPageService.login(user).
                clickCardButton();
        cardService = new CardService();
    }

    @Test(description = "Return to Inventory Page Test")
    public void verifyReturnToInventoryPageTest() {
        String actualTextOfInventoryPage = cardService.returnToInventoryPage().
                getNameOfMainPageSectionText();
        String expectedTextOfInventoryPage = "PRODUCTS";
        Assert.assertEquals(actualTextOfInventoryPage, expectedTextOfInventoryPage,
                "The actual text of the page does not match expected!");
    }
}
