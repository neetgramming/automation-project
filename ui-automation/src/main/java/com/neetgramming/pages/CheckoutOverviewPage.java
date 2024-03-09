package com.neetgramming.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CheckoutOverviewPage extends BasePage<CheckoutOverviewPage> {
    private final By labelCartItem = By.className("cart_item_label");
    private final By labelPaymentInfo = By.xpath("//*[@class='summary_info_label'][1]");
    private final By labelPaymentInfoSourceCard = By.xpath("//*[@class='summary_value_label'][1]");
    private final By labelShippingInfo = By.xpath("//*[@class='summary_info_label'][2]");
    private final By labelShippingInfoContent = By.xpath("//*[@class='summary_value_label'][2]");
    private final By labelPriceTotal = By.xpath("//*[@class='summary_info_label'][3]");
    private final By labelItemTotal = By.className("summary_subtotal_label");
    private final By labelTax = By.className("summary_tax_label");
    private final By labelSubTotal = By.xpath("//*[@class='summary_info_label summary_total_label']");
    private final By btnFinish = By.id("finish");
    private final String PAGE_TITLE = "Checkout: Overview";

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageLoaded() {
        return isPageLoaded(PAGE_TITLE);
    }

    public List<String> getCartItems() {
        List<String> listCartItems = new ArrayList<>();
        for (WebElement element: driver.findElements(labelCartItem)) {
            listCartItems.add(element.findElement(By.xpath("./a/div[@class='inventory_item_name']")).getText());
        }
        return listCartItems;
    }

    public double getCalculatedTotal() {
        double calculatedTotal = 0.00;
        for (WebElement element: getElementsList(labelCartItem)) {
            String mainString = element.findElement(By.xpath("./div[@class='item_pricebar']/div[@class='inventory_item_price']")).getText();
            calculatedTotal = calculatedTotal + Double.parseDouble(mainString.substring(mainString.indexOf("$")+1));
        }
        return calculatedTotal;
    }

    public String getPaymentInfoLabel() {
        return getTextValue(labelPaymentInfo);
    }

    public String getPaymentInfoContent() {
        return getTextValue(labelPaymentInfoSourceCard);
    }

    public String getShippingInfoLabel() { return getTextValue(labelShippingInfo); }

    public String getShippingInfoContent() {
        return getTextValue(labelShippingInfoContent);
    }

    public String getPriceTotalLabel() {
        return getTextValue(labelPriceTotal);
    }

    public String getItemTotal() {
        return getTextValue(labelItemTotal);
    }

    public String getTax() {
        return getTextValue(labelTax);
    }

    public String getSubTotal() {
        return getTextValue(labelSubTotal);
    }

    public void finishPayment() { clickElement(btnFinish); }
}