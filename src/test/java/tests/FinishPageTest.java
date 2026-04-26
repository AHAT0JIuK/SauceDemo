package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FinishPageTest extends BaseTest {

    @Test
    public void checkOpenFinishPage() {
        SoftAssert softAssert = new SoftAssert();
        // открытие страницы залогина
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        softAssert.assertEquals(productsPage.getTitle(), "Products");
        // нажимаю на кнопку перехода на страницу тележки
        productsPage.goToCartPage();
        // проверка открытия страницы тележки
        softAssert.assertEquals(cartPage.getTitleCartPage(), "Your Cart");
        // нажимаю на кнопку перехода на страницу checkout
        cartPage.goToCheckoutPage();
        // проверка открытия страницы checkout
        softAssert.assertEquals(checkoutPage.getTitleCheckoutPage(), "Checkout: Your Information");
        // заполнение всех полей
        checkoutPage.inputsFill("userFirstName", "userLastName", "123456");
        // нажимаю на кнопку продолжить
        checkoutPage.continueButtonClick();
        // проверка открытия страницы checkout overview
        softAssert.assertEquals(checkoutOverviewPage.getTitleCheckoutOverviewPage(), "Checkout: Overview");
        // нажимаю на кнопку Finish
        checkoutOverviewPage.finishButtonClick();
        // проверка открытия последней страницы
        softAssert.assertEquals(finishPage.getTitleFinishPage(), "Checkout: Complete!");
    }

    @Test
    public void checkReturnToProductsPage() {
        SoftAssert softAssert = new SoftAssert();
        // открытие страницы залогина
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        softAssert.assertEquals(productsPage.getTitle(), "Products");
        // нажимаю на кнопку перехода на страницу тележки
        productsPage.goToCartPage();
        // проверка открытия страницы тележки
        softAssert.assertEquals(cartPage.getTitleCartPage(), "Your Cart");
        // нажимаю на кнопку перехода на страницу checkout
        cartPage.goToCheckoutPage();
        // проверка открытия страницы checkout
        softAssert.assertEquals(checkoutPage.getTitleCheckoutPage(), "Checkout: Your Information");
        // заполнение всех полей
        checkoutPage.inputsFill("userFirstName", "userLastName", "123456");
        // нажимаю на кнопку продолжить
        checkoutPage.continueButtonClick();
        // проверка открытия страницы checkout overview
        softAssert.assertEquals(checkoutOverviewPage.getTitleCheckoutOverviewPage(), "Checkout: Overview");
        // нажимаю на кнопку Finish
        checkoutOverviewPage.finishButtonClick();
        // проверка открытия последней страницы
        softAssert.assertEquals(finishPage.getTitleFinishPage(), "Checkout: Complete!");
        // нажимаю на кнопку Back Home
        finishPage.backHomeButtonClick();
        // проверка возврата на страницу с продуктами
        softAssert.assertEquals(productsPage.getTitle(), "Products");
    }

    @Test
    public void checkGoToCartPage() {
        SoftAssert softAssert = new SoftAssert();
        // открытие страницы залогина
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        softAssert.assertEquals(productsPage.getTitle(), "Products");
        // нажимаю на кнопку перехода на страницу тележки
        productsPage.goToCartPage();
        // проверка открытия страницы тележки
        softAssert.assertEquals(cartPage.getTitleCartPage(), "Your Cart");
        // нажимаю на кнопку перехода на страницу checkout
        cartPage.goToCheckoutPage();
        // проверка открытия страницы checkout
        softAssert.assertEquals(checkoutPage.getTitleCheckoutPage(), "Checkout: Your Information");
        // заполнение всех полей
        checkoutPage.inputsFill("userFirstName", "userLastName", "123456");
        // нажимаю на кнопку продолжить
        checkoutPage.continueButtonClick();
        // проверка открытия страницы checkout overview
        softAssert.assertEquals(checkoutOverviewPage.getTitleCheckoutOverviewPage(), "Checkout: Overview");
        // нажимаю на кнопку Finish
        checkoutOverviewPage.finishButtonClick();
        // проверка открытия последней страницы
        softAssert.assertEquals(finishPage.getTitleFinishPage(), "Checkout: Complete!");
        // нажимаю на кнопку перехода на страницу тележки
        finishPage.goToCartPage();
        // проверка открытия страницы тележки
        softAssert.assertEquals(cartPage.getTitleCartPage(), "Your Cart");
    }

}
