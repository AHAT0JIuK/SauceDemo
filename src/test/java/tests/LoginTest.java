package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends BaseTest {

    @Test(enabled = true,
            description = "Проверка залогина с валидными кредами",
            testName = "Проверка залогина с валидными кредами")
    @Description("Проверка залогина с валидными кредами")
    @Feature("Логин на SauceDemo")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("QATASK-001")
    @Issue("SCDM-001")
    @Owner("Светлов А.А.")
    public void checkLoginWithPositiveCred() {
        // открытие страницы
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        assertEquals(productsPage.getTitle(), "Products");
    }

    @DataProvider(name = "Тестовые данные для негативного залогина")
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"test", "test", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(enabled = true,
            description = "Проверка залогина с невалидными кредами",
            testName = "Проверка залогина с невалидными кредами",
            dataProvider = "Тестовые данные для негативного залогина")
    @Description("Проверка залогина с невалидными кредами")
    @Feature("Логин на SauceDemo")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("QATASK-002")
    @Issue("SCDM-001")
    @Owner("Светлов А.А.")
    public void checkLoginNegativeCred(String user, String password, String errorMessage) {
        // открытие страницы
        loginPage.open();
        // залогин c невалидным логином и паролем
        loginPage.login(user, password);
        // проверка появления информационного сообщения
        assertEquals(loginPage.getErrorMessage(), errorMessage);
    }
}
