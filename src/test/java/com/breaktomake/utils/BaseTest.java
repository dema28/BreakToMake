package com.breaktomake.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@Listeners({AllureTestNg.class, TestListener.class}) // Подключаем Allure и кастомный TestListener
public class BaseTest {

    protected WebDriver driver;
    protected Properties properties = new Properties();

    @BeforeClass
    public void setup() throws IOException {
        // Подавление лишних логов
        System.setProperty("webdriver.chrome.silentOutput", "true");
        System.setProperty("wdm.logLevel", "ERROR");
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
        Logger.getLogger("org.testng").setLevel(Level.SEVERE);

        // Загружаем конфигурацию
        FileInputStream fis = new FileInputStream("src/main/resources/config/local.properties");
        properties.load(fis);

        // Настройки браузера
        String browser = properties.getProperty("browser", "chrome");
        String chromeOptionsRaw = properties.getProperty("local.chrome_options", "");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            if (!chromeOptionsRaw.isEmpty()) {
                String[] optionList = chromeOptionsRaw.split(",");
                for (String option : optionList) {
                    options.addArguments(option.trim());
                }
            }

            driver = new ChromeDriver(options);
        } else {
            throw new RuntimeException("Browser not supported: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
