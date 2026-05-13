package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.base.BaseTest;

public class CheckoutOverviewPageTest extends BaseTest {

    @Test(enabled = true,
            description = "Проверка перехода со страницы Checkout на страницу Checkout: Overview",
            testName = "Проверка перехода со страницы Checkout на страницу Checkout: Overview")
    @Description("Проверка перехода со страницы Checkout на страницу Checkout: Overview")
    @Feature("Checkout Overview Page")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("QATASK-012")
    @Issue("SCDM-006")
    @Owner("Светлов А.А.")
    public void checkOpenCheckoutOverviewPage() {
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
        softAssert.assertAll();
    }

    @Test(enabled = true,
            description = "Проверка перехода со страницы Checkout: Overview на страницу с продуктами",
            testName = "Проверка перехода со страницы Checkout: Overview на страницу с продуктами")
    @Description("Проверка перехода со страницы Checkout: Overview на страницу с продуктами")
    @Feature("Checkout Overview Page")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("QATASK-013")
    @Issue("SCDM-006")
    @Owner("Светлов А.А.")
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
        // заполнение поля First Name
        checkoutPage.inputsFill("userFirstName", "userLastName", "123456");
        // нажимаю на кнопку продолжить
        checkoutPage.continueButtonClick();
        // проверка открытия страницы checkout overview
        softAssert.assertEquals(checkoutOverviewPage.getTitleCheckoutOverviewPage(), "Checkout: Overview");
        // нажимаю на кнопку отмены
        checkoutOverviewPage.cancelButtonClick();
        // проверка возврата на страницу с продуктами
        softAssert.assertEquals(productsPage.getTitle(), "Products");
        softAssert.assertAll();
    }

    @Test(enabled = true,
            description = "Проверка перехода со страницы Checkout: Overview на страницу тележки",
            testName = "Проверка перехода со страницы Checkout: Overview на страницу тележки")
    @Description("Проверка перехода со страницы Checkout: Overview на страницу тележки")
    @Feature("Checkout Overview Page")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("QATASK-014")
    @Issue("SCDM-006")
    @Owner("Светлов А.А.")
    public void checkReturnToCartPage() {
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
        // заполнение поля First Name
        checkoutPage.inputsFill("userFirstName", "userLastName", "123456");
        // нажимаю на кнопку продолжить
        checkoutPage.continueButtonClick();
        // проверка открытия страницы checkout overview
        softAssert.assertEquals(checkoutOverviewPage.getTitleCheckoutOverviewPage(), "Checkout: Overview");
        // нажимаю на кнопку перехода на страницу тележки
        checkoutOverviewPage.goToCartPage();
        // проверка открытия страницы тележки
        softAssert.assertEquals(cartPage.getTitleCartPage(), "Your Cart");
        softAssert.assertAll();
    }
}
