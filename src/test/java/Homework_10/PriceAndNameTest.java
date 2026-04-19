package Homework_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

/*
Создать отдельный Java-класс с тестом, сценарий:
a. Залогиниться
b. Добавить товар в корзину
c. Перейти в корзину
d. Проверить (assertEquals) стоимость товара и его имя в корзине
*/

public class PriceAndNameTest {

    @Test
    public void checkLocator() {
        // объявляю настройки для тестового браузера
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--headless");
        // объявляю тестовый браузер
        WebDriver driver = new ChromeDriver(options);
        // неявное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // открытие страницы по указанному урлу
        driver.get("https://www.saucedemo.com/");
        // залогин
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        // добавление товара в корзину
        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        // переход в корзину
        driver.findElement(By.className("shopping_cart_link")).click();
        // проверка стоимости товара в корзине
        String priceInsideClass = driver.findElement(By.className("inventory_item_price")).getText();
        String price = priceInsideClass.trim(); // убираю из полученного текста разделитель в виде переноса на новую строку
        Assert.assertEquals(price, "$15.99");
        // проверка наименования товара в корзине
        String nameInsideClass = driver.findElement(By.className("inventory_item_name")).getText();
        Assert.assertEquals(nameInsideClass, "Test.allTheThings() T-Shirt (Red)");
        // закрываю браузер
        driver.quit();
    }
}
