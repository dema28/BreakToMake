package com.breaktomake;


import com.breaktomake.pages.LoginPage;
import com.breaktomake.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        // Инициализация драйвера
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://example.com/login");

        // Инициализация страницы
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testSuccessfulLogin() {
        // Выполняем вход в систему
        HomePage homePage = loginPage.login("username", "password");

        // Проверяем, что мы на главной странице
        Assert.assertTrue(homePage.getWelcomeMessage().contains("Welcome"));
    }

    @AfterMethod
    public void tearDown() {
        // Закрываем браузер после теста
        driver.quit();
    }
}
