package com.globant.tests;

import com.globant.pages.ProductsPage;
import com.globant.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveItemsTest extends  BaseTest {
    @Test
    public void testRemoveAllItemsFromCart() {
        ProductsPage productsPage = new ProductsPage(driver);

        // Add 3 specific products to make the test more reliable
        productsPage.addSpecificProductToCart("Sauce Labs Backpack");
        productsPage.addSpecificProductToCart("Sauce Labs Bike Light");
        productsPage.addSpecificProductToCart("Sauce Labs Bolt T-Shirt");

        productsPage.goToCart();

        StorePage storePage = new StorePage(driver, productsPage.getProducts());
        Assert.assertEquals(storePage.getStoreItemsCount(), 3, "Cart should have 3 items initially");

        storePage.removeAllItemsFromCart();
        Assert.assertTrue(storePage.isStoreEmpty(), "Cart should be empty after removing all items");
    }
}
