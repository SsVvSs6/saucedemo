package org.tms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CardPage extends BasePage {

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
        cartItemRemoveButton.findElement(By.xpath(String.format(REMOVE_BUTTON_XPATH, itemTitleLink))).click();
        return this;
    }

    public InventoryPage clickContinueShoppingButton() {
        continueShoppingButton.click();
        return new InventoryPage();
    }

    public CardPage waitPageIsLoaded() {
        waitVisibilityOf(continueShoppingButton);
        return new CardPage();
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }
}
