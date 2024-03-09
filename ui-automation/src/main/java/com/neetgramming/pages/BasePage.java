package com.neetgramming.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage<T> {
    protected final WebDriver driver;
    protected WebDriverWait wait;
    protected By labelPageTitle = By.className("title");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void explicitWaitForElementVisibility(By element, long durationSeconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(durationSeconds));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
    }

    public void clickElement(By element) {
        driver.findElement(element).click();
    }

    public void fillTextBox(By element, String value) {
        driver.findElement(element).sendKeys(value);
    }

    public String getTextValue(By element) {
        return driver.findElement(element).getText();
    }

    public List<WebElement> getElementsList(By element) {
        return driver.findElements(element);
    }

    public boolean isPageLoaded(String pageTitle) {
        return getTextValue(labelPageTitle).equals(pageTitle);
    }
}