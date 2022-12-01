package org.tms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tms.utils.MessageLogger;

public class InventoryPage extends BasePage {

    private static final String CLICK_CARD_BUTTON_PROCESS_NAME = "Click Card button";
    private static final String LOADING_PAGE_PROCESS_NAME = "Card Page loading";
    @FindBy(xpath = "//span[@class='title']")
    private WebElement nameOfMainPageSection;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cardButton;

    public String getNameOfMainPageSectionText() {
        return nameOfMainPageSection.getText();
    }

    public CardPage clickCardButton() {
        MessageLogger.logStartProcessInfo(CLICK_CARD_BUTTON_PROCESS_NAME);
        cardButton.click();
        MessageLogger.logEndProcessInfo(CLICK_CARD_BUTTON_PROCESS_NAME);
        return new CardPage();
    }

    public InventoryPage waitPageIsLoaded() {
        waitVisibilityOf(nameOfMainPageSection);
        MessageLogger.logEndProcessInfo(LOADING_PAGE_PROCESS_NAME);
        return this;
    }
}
