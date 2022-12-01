package org.tms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tms.utils.MessageLogger;

public class CardPage extends BasePage {

    private static final String CLICK_REMOVE_BUTTON_PROCESS_NAME = "Click Remote button";
    private static final String CLICK_CONTINUE_BUTTON_PROCESS_NAME = "Click Continue button";
    private static final String CLICK_CHECKOUT_BUTTON_PROCESS_NAME = "Click Checkout button";
    private static final String WAIT_PAGE_OPEN_PROCESS_NAME = "Card Page loading";
    private static final String CARD_ITEM_XPATH = "//a[@id='%s']//div[@class='%s']";
    private static final String CARD_ITEM_XPATH_WITH_ANCESTOR =
            "//a[@id='%s']/ancestor::div[@class='cart_item']//div[@class='%s']";
    private static final String REMOVE_BUTTON_XPATH = "//a[@id='%s']/ancestor::div[@class='cart_item']//button";
    private WebElement cartItemRemoveButton;

    @FindBy(xpath = "//button[@id='continue-shopping']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutButton;

    public CardPage findCartItemName(String itemTitleLink) {
        driver.findElement(By.xpath(String.format(CARD_ITEM_XPATH, itemTitleLink, "inventory_item_name")));
        return this;
    }

    public CardPage findCartItemQuantity(String itemTitleLink) {
        driver.findElement(By.xpath(String.format(CARD_ITEM_XPATH_WITH_ANCESTOR, itemTitleLink, "cart_quantity")));
        return this;
    }

    public CardPage findCartItemDescription(String itemTitleLink) {
        driver.findElement(By.xpath(String.format(CARD_ITEM_XPATH_WITH_ANCESTOR, itemTitleLink, "inventory_item_desc")));
        return this;
    }
    public CardPage findCartItemPrice(String itemTitleLink) {
        driver.findElement(By.xpath(String.format(CARD_ITEM_XPATH_WITH_ANCESTOR, itemTitleLink, "inventory_item_price")));
        return this;
    }

    public CardPage clickRemoveButton(String itemTitleLink) {
        MessageLogger.logStartProcessInfo(CLICK_REMOVE_BUTTON_PROCESS_NAME);
        cartItemRemoveButton.findElement(By.xpath(String.format(REMOVE_BUTTON_XPATH, itemTitleLink))).click();
        MessageLogger.logEndProcessInfo(CLICK_REMOVE_BUTTON_PROCESS_NAME);
        return this;
    }

    public InventoryPage clickContinueShoppingButton() {
        MessageLogger.logStartProcessInfo(CLICK_CONTINUE_BUTTON_PROCESS_NAME);
        continueShoppingButton.click();
        MessageLogger.logEndProcessInfo(CLICK_CONTINUE_BUTTON_PROCESS_NAME);
        return new InventoryPage();
    }

    public CardPage waitPageIsLoaded() {
        waitVisibilityOf(continueShoppingButton);
        MessageLogger.logEndProcessInfo(WAIT_PAGE_OPEN_PROCESS_NAME);
        return this;
    }

    public void clickCheckoutButton() {
        MessageLogger.logStartProcessInfo(CLICK_CHECKOUT_BUTTON_PROCESS_NAME);
        checkoutButton.click();
        MessageLogger.logEndProcessInfo(CLICK_CHECKOUT_BUTTON_PROCESS_NAME);
    }
}
