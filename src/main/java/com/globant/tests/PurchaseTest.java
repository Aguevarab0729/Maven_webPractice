package com.globant.tests;

import com.globant.pages.*;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {
    @Test
    public void testCompletePurchaseFlow() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addRandomProductToCart();
        productsPage.goToCart();
        StorePage storePage = new StorePage(driver, productsPage.getProducts());
        StorePage.proceedToCheckout();

        // Falta completar los pasos de checkout
    }
}
