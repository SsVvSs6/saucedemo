package org.tms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tms.driver.DriverSingleton;
import org.tms.utils.MessageLogger;

import java.time.Duration;

public abstract class BasePage {

    private static final int WAIT_TIMEOUT_SECONDS = 10;
    private static final String VISIBILITY_WAIT_NAME = "visibility";
    private static final String CLICK_ABILITY_WAIT_NAME = "click ability";
    protected WebDriver driver = DriverSingleton.getDriver();

    protected BasePage() {
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitVisibilityOf(WebElement element) {
        MessageLogger.logWaitingInfo(VISIBILITY_WAIT_NAME);
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitElementToBeClickable(WebElement element) {
        MessageLogger.logWaitingInfo(CLICK_ABILITY_WAIT_NAME);
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
