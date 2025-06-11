package com.globant.pages;

import com.globant.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage {
    @FindBy(className = "inventoryItem")
    private List<WebElement> products;

    @FindBy(className = "shoppingCart")
    private WebElement cartIcon;

    @FindBy(id = "reactBurgerMenu")
    private WebElement menuButton;

    @FindBy(id = "logoutSidebarLink")
    private WebElement logoutLink;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart() {
        Random random = new Random();
        int randomIndex = random.nextInt(products.size());
        WebElement randomProduct = products.get(randomIndex);

        // Buscar el botón dentro del producto
        WebElement addToCartButton = randomProduct.findElement(
                By.xpath(".//button[contains(text(), 'Add to cart')]")
        );
        waitAndClick(addToCartButton);
    }

    public void addSpecificProductToCart(String productName) {
        for (WebElement product : products) {
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

    public List<WebElement> getProducts() {
        return products;
    }

    public void addRandomProductToCart() {
        if (products.isEmpty()) {
            throw new IllegalStateException("No products available to add to cart.");
        }
        addProductToCart();
    }
}
