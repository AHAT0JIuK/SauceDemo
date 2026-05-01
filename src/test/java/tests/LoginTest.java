package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void checkLoginWithPositiveCred() {
        // открытие страницы
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        assertEquals(productsPage.getTitle(), "Products");
    }

    @Test
    public void checkLoginWithEmptyPassword() {
        // открытие страницы
        loginPage.open();
        // залогин c валидным логином и пустым паролем
        loginPage.login("standard_user", "");
        // проверка появления информационного сообщения об обязательности ввода пароля
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }

    @Test
    public void checkLoginWithEmptyUser() {
        // открытие страницы
        loginPage.open();
        // залогин c пустым логином и валидным паролем
        loginPage.login("", "secret_sauce");
        // проверка появления информационного сообщения об обязательности ввода логина
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test
    public void checkLoginNegativeCred() {
        // открытие страницы
        loginPage.open();
        // залогин c невалидным логином и паролем
        loginPage.login("test", "test");
        /*
        проверка появления информационного сообщения о том,
        что в БД нет зарегистрированного пользователя с введенными данными
         */
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any " +
                "user in this service");
    }
}
