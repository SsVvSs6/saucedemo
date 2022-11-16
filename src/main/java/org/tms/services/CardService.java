package org.tms.services;

import io.qameta.allure.Step;
import org.tms.pages.CardPage;
import org.tms.pages.InventoryPage;

public class CardService {

    CardPage cardPage = new CardPage();

    @Step("Return to Inventory Page")
    public InventoryPage returnToInventoryPage() {
        cardPage.clickContinueShoppingButton().waitPageIsLoaded();
        return new InventoryPage();
    }
}
