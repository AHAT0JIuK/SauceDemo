package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.base.BaseTest;

/*
1. Создать новый проект SauceDemo
2. Расшарить на Github и пригласить ментора в коллабораторы
3. Создать новый Java-класс, в нем для ресурса
https://www.saucedemo.com/ составить список локаторов, можно искать на
ВСЕХ страницах приложения (driver.findElement(<локатор>)) для КАЖДОГО из
примеров локаторов ниже:
• id
• name
• classname
• tagname
• linktext
• partiallinktext
• xpath:
- поиск по атрибуту, например By.xpath("//tag[@attribute='value']");
- поиск по тексту, например By.xpath("//tag[text()='text']");
- поиск по частичному совпадению атрибута, например
By.xpath("//tag[contains(@attribute,'text')]");
- поиск по частичному совпадению текста, например
By.xpath("//tag[contains(text(),'text')]");
- ancestor, например //*[text()='Enterprise Testing']//ancestor::div
- descendant
- following
- parent
- preceding
- *поиск элемента с условием AND, например
//input[@class='_2zrpKA_1dBPDZ' and @type='text']
• css:
- .class
- .class1.class2
- .class1 .class2
- #id
- tagname
- tagname.class
- [attribute=value]
- [attribute~=value]
- [attribute|=value]
- [attribute^=value]
- [attribute$=value]
- [attribute*=value]
- Подсказка: https://www.w3schools.com/cssref/css_selectors.asp
*/

public class PracticeTest extends BaseTest {

    @Test(enabled = false,
            description = "Практика нахождения вэб-элементов по разным локаторам",
            testName = "Практика нахождения вэб-элементов по разным локаторам")
    public void checkLocator() {
        // открытие страницы залогина
        loginPage.open();
        // поиск элемента по id
        driver.findElement(By.id("root"));
        // поиск элемента по name
        driver.findElement(By.name("robots"));
        // поиск элемента по classname
        driver.findElement(By.className("login_container"));
        // поиск элемента по tagname
        driver.findElement(By.tagName("noscript"));
        // поиск элемента по linktext
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        driver.findElement(By.linkText("Sauce Labs Backpack"));
        // поиск элемента по partiallinktext
        driver.findElement(By.partialLinkText("Bike Light"));
        // поиск элемента по xpath
        driver.findElement(By.xpath("/html/head/title"));
        // поиск по атрибуту, например By.xpath("//tag[@attribute='value']")
        driver.findElement(By.xpath("//script[@defer='defer']"));
        // поиск по тексту, например By.xpath("//tag[text()='text']")
        driver.findElement(By.xpath("//span[text()='Products']"));
        // поиск по частичному совпадению атрибута, например By.xpath("//tag[contains(@attribute,'text')]");
        driver.findElement(By.xpath("//select[contains(@class,'sort')]"));
        // поиск по частичному совпадению текста, например By.xpath("//tag[contains(text(),'text')]");
        driver.findElement(By.xpath("//div[contains(text(),'Sly')]"));
        // ancestor, например //*[text()='Enterprise Testing']//ancestor::div
        driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']//ancestor::div[@id='root']"));
        // descendant
        driver.findElement(By.xpath("//div[@id='page_wrapper']//descendant::div[@data-test='inventory-item-price']"));
        // following
        driver.findElement(By.xpath("//a[@id='inventory_sidebar_link']//following::a[@id='about_sidebar_link']"));
        // parent
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']//parent::nav"));
        // preceding
        driver.findElement(By.xpath("//a[@id='item_4_img_link']//preceding::div[1]"));
        // поиск элемента с условием AND, например //input[@class='_2zrpKA_1dBPDZ'and@type='text']
        driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack'and@src='/static/media/sauce-backpack-1200x1500.0a0b85a385945026062b.jpg']"));
        // .class
        driver.findElement(By.cssSelector(".bm-cross"));
        // .class1.class2
        productsPage.openSidebar();
        productsPage.clickLogoutButton();
        driver.findElement(By.cssSelector(".submit-button.btn_action"));
        // .class1 .class2
        driver.findElement(By.cssSelector(".login_container .login_logo"));
        // #id
        driver.findElement(By.cssSelector("#login_credentials"));
        // tagname
        driver.findElement(By.cssSelector("form"));
        // tagname.class
        driver.findElement(By.cssSelector("div.login_password"));
        // [attribute=value]
        driver.findElement(By.cssSelector("[data-test='login-credentials']"));
        // [attribute~=value]
        driver.findElement(By.cssSelector("[class~='btn_action']"));
        // [attribute|=value]
        driver.findElement(By.cssSelector("[class|='error']"));
        // [attribute^=value]
        driver.findElement(By.cssSelector("[class^='login-bo']"));
        // [attribute*=value]
        driver.findElement(By.cssSelector("[class*='r-inner']"));
        // закрываю браузер
        driver.quit();
    }
}
