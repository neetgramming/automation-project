package com.neetgramming.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderCompletePage extends BasePage<OrderCompletePage> {
    private final By labelCompleteOrder = By.className("complete-header");
    private final String PAGE_TITLE = "Checkout: Complete!";

    public OrderCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageLoaded() {
        return isPageLoaded(PAGE_TITLE);
    }

    public String getCompleteLabel() {
        return getTextValue(labelCompleteOrder);
    }
 }
