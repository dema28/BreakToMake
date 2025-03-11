package com.breaktomake;

import com.breaktomake.pages.HomePage;
import com.breaktomake.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        // Инициализация драйвера
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://example.com/login");

        // Выполняем вход в систему
        LoginPage loginPage = new LoginPage(driver);
        homePage = loginPage.login("username", "password");
    }

    @Test
    public void testLogout() {
        // Выполняем выход из системы
        homePage.clickLogout();

        // Проверяем, что мы вернулись на страницу входа
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @AfterMethod
    public void tearDown() {
        // Закрываем браузер после теста
        driver.quit();
    }
}