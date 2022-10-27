package org.tms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.tms.driver.DriverSingleton;

public abstract class BasePage {

    protected WebDriver driver = DriverSingleton.getDriver();

    protected BasePage() {
        PageFactory.initElements(driver, this);
    }
}
