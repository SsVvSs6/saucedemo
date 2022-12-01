package org.tms.services;

import io.qameta.allure.Step;
import org.tms.pages.CardPage;
import org.tms.pages.InventoryPage;
import org.tms.utils.MessageLogger;

public class CardService {

    private static final String OPEN_INVENTORY_PAGE_STEP = "Return to Inventory Page";
    CardPage cardPage = new CardPage();

    @Step(OPEN_INVENTORY_PAGE_STEP)
    public InventoryPage returnToInventoryPage() {
        MessageLogger.logStartProcessInfo(OPEN_INVENTORY_PAGE_STEP);
        cardPage.clickContinueShoppingButton().waitPageIsLoaded();
        MessageLogger.logEndProcessInfo(OPEN_INVENTORY_PAGE_STEP);
        return new InventoryPage();
    }
}
