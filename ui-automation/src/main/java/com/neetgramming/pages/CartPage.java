package com.neetgramming.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage<CartPage> {
    private final By btnContinue = By.id("checkout");
    private final String PAGE_TITLE = "Your Cart";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageLoaded() {
        return isPageLoaded(PAGE_TITLE);
    }

    public void checkoutCart() {
        clickElement(btnContinue);
    }
}