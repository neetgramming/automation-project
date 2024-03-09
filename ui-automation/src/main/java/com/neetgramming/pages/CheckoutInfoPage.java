package com.neetgramming.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage extends BasePage<CheckoutInfoPage> {
    private final By txtFirstName = By.id("first-name");
    private final By txtLastName = By.id("last-name");
    private final By txtZipCode = By.id("postal-code");
    private final By btnContinue = By.id("continue");
    private final String PAGE_TITLE = "Checkout: Your Information";

    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageLoaded() {
        return isPageLoaded(PAGE_TITLE);
    }

    public void continueCheckout(String firstName, String lastName, String zipCode) {
        fillTextBox(txtFirstName, firstName);
        fillTextBox(txtLastName, lastName);
        fillTextBox(txtZipCode, zipCode);
        clickElement(btnContinue);
    }
}
