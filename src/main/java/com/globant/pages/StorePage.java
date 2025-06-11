package com.globant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StorePage extends BasePage {
    @FindBy(className = "StoreItem")
    private List<WebElement> storeItems;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public StorePage(WebDriver driver, List<WebElement> storeItems) {
        super(driver);
        this.storeItems = storeItems;
    }

    public void removeAllItemsFromCart(){
        for (WebElement item : storeItems) {
            waitAndClick(item.findElement(By.tagName("button")));
        }
    }

    public int getStoreItemsCount() {
        return storeItems.size();
    }

    public void proceedToCheckout() {
        waitAndClick(checkoutButton);
    }

    public boolean isStoreEmpty() {
        return  storeItems.isEmpty();
    }
}
