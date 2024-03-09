package com.neetgramming.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomeInventoryPage extends BasePage<HomeInventoryPage> {
    private final By btnAddToCart = By.xpath("//*[contains(@id, 'add-to-cart')]");
    private final By btnShoppingCart = By.id("shopping_cart_container");
    private final String PAGE_TITLE = "Products";

    public HomeInventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageLoaded() {
        return isPageLoaded(PAGE_TITLE);
    }

    public List<String>  getSelectedRandomItems(int noOfItems){
        List<WebElement> listElements = getElementsList(btnAddToCart);
        List<String> selectedItems = new ArrayList<>();
        Random random = new Random();
        for (int i=0; i<noOfItems; i++) {
            int randomIndex = random.nextInt(listElements.size());
            selectedItems.add(listElements.get(randomIndex).findElement(By.xpath(".//parent::div/preceding-sibling::div/a/div")).getText());
            listElements.get(randomIndex).click();
            listElements.remove(randomIndex);
        }
        return  selectedItems;
    }

    public void goToShoppingCart() {
        clickElement(btnShoppingCart);
    }
}