package com.globant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage{
    @FindBy(className = "inventory_item")
    private List<WebElement> productItems;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addRandomProductToCart() {
        Random random = new Random();
        int randomIndex = random.nextInt(productItems.size());
        WebElement randomProduct = productItems.get(randomIndex);

        // Buscar el botón "Add to cart" dentro del producto específico
        WebElement addToCartButton = randomProduct.findElement(
                By.xpath(".//button[contains(text(), 'Add to cart')]")
        );
        waitAndClick(addToCartButton);
    }

    public void addSpecificProductToCart(String productName) {
        for (WebElement product : productItems) {
            String actualProductName = product.findElement(
                    By.className("inventory_item_name")
            ).getText();

            if (actualProductName.equals(productName)) {
                WebElement addToCartButton = product.findElement(
                        By.xpath(".//button[contains(text(), 'Add to cart')]")
                );
                waitAndClick(addToCartButton);
                break;
            }
        }
    }

    public void goToCart() {
        waitAndClick(cartIcon);
    }

    public void logout() {
        waitAndClick(menuButton);
        waitAndClick(logoutLink);
    }

    public int getCartItemCount() {
        String countText = cartIcon.getText();
        return countText.isEmpty() ? 0 : Integer.parseInt(countText);
    }

    // Nuevo método para obtener nombres de productos disponibles
    public String[] getAvailableProductNames() {
        return new String[]{
                "Sauce Labs Backpack",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Onesie",
                "Sauce Labs Bike Light",
                "Sauce Labs Fleece Jacket",
                "Test.allTheThings() T-Shirt (Red)"
        };
    }
}
