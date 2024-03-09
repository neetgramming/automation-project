package com.neetgramming.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage<LoginPage> {
    private final By labelLogo = By.className("login_logo");
    private final By txtUsername = By.id("user-name");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.id("login-button");
    private final By txtStandardUsername = By.id("login_credentials");
    private final By txtStandardPassword = By.xpath("//*[@class='login_password']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login() {
        explicitWaitForElementVisibility(labelLogo, 5);
        fillTextBox(txtUsername, getTextValue(txtStandardUsername).split("\n")[1]);
        fillTextBox(txtPassword, getTextValue(txtStandardPassword).split("\n")[1]);
        clickElement(btnLogin);
    }
}