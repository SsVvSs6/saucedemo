package org.tms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage {

    @FindBy(xpath = "//span[@class='title']")
    private WebElement nameOfMainPageSection;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cardButton;

    public String getNameOfMainPageSectionText() {
        return nameOfMainPageSection.getText();
    }

    public CardPage clickCardButton() {
        cardButton.click();
        return new CardPage();
    }

    public InventoryPage waitPageIsLoaded() {
        waitVisibilityOf(nameOfMainPageSection);
        return this;
    }
}
