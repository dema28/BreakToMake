package com.breaktomake.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@Listeners({TestListener.class})
public class BaseTest {

    protected WebDriver driver;
    protected Properties properties = new Properties();

    @BeforeSuite
    public void cleanEnvironmentBeforeSuite() {
        ProjectSetup.cleanProjectFolders();
    }


    @BeforeClass
    public void setup() throws IOException {
        // 🔇 Подавление лишних логов
        System.setProperty("webdriver.chrome.silentOutput", "true"); // ChromeDriver
        System.setProperty("wdm.logLevel", "ERROR");                 // WebDriverManager
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
        Logger.getLogger("org.testng").setLevel(Level.SEVERE);

        // 📦 Загрузка настроек из local.properties
        FileInputStream fis = new FileInputStream("src/main/resources/config/local.properties");
        properties.load(fis);

        String browser = properties.getProperty("browser", "chrome");
        String chromeOptionsRaw = properties.getProperty("local.chrome_options", "");
        boolean maximize = Boolean.parseBoolean(properties.getProperty("maximize", "true"));

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            // 🛠 Применяем опции из local.chrome_options
            if (!chromeOptionsRaw.isEmpty()) {
                String[] optionList = chromeOptionsRaw.split(",");
                Arrays.stream(optionList).map(String::trim).forEach(options::addArguments);
            }

            // 🌐 Headless режим в CI
            if ("true".equalsIgnoreCase(System.getenv("CI"))) {
                options.addArguments("--headless=new");
            }

            options.addArguments("--window-size=1920,1080");

            driver = new ChromeDriver(options);

        } else {
            throw new RuntimeException("Browser not supported: " + browser);
        }

        // 🖥️ Максимизация окна, если задана
        if (maximize) {
            driver.manage().window().maximize();
        }

        // ⏱️ Имплицитное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
