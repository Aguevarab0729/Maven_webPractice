package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "username")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void login(String username, String password) {
        waitAndSendKeys(userNameInput, username);
        waitAndSendKeys(passwordInput, password);
        waitAndClick(loginButton);
    }

    public boolean isLoginPageDisplayed() {
        return isElementPresent(loginButton);
    }
}
