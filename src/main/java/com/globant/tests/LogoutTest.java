package com.globant.tests;

import com.globant.pages.LoginPage;
import com.globant.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogout() {
        // Navigate to the menu and click on the logout option
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.logout();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Deberia mostrar la página de inicio de sesión después de cerrar sesión.");
    }
}
