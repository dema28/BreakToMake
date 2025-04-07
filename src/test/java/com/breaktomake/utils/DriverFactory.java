package com.breaktomake.utils;

import com.breaktomake.config.Environment;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {
        if (driver.get() == null) {
            String browser = Environment.getBrowser().toLowerCase();
            LoggerUtil.info("🌐 Инициализация драйвера: " + browser);

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();

                    // Применяем опции из config
                    options.addArguments(Environment.getChromeOptions());
                    LoggerUtil.info("⚙️ Опции Chrome: " + Environment.getChromeOptions());

                    if (Environment.isHeadless()) {
                        options.addArguments("--headless=new");
                        LoggerUtil.info("🔒 Headless режим включен");
                    }

                    driver.set(new ChromeDriver(options));
                    LoggerUtil.info("✅ ChromeDriver запущен");
                    break;

                default:
                    LoggerUtil.error("❌ Неподдерживаемый браузер: " + browser, null);
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            driver.get().manage().window().maximize();
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver(boolean testFailed) {
        if (driver.get() != null) {
            if (!testFailed || Environment.isCloseBrowserOnError()) {
                LoggerUtil.info("🚪 Закрытие WebDriver. Тест упал: " + testFailed);
                driver.get().quit();
            } else {
                LoggerUtil.info("🚫 WebDriver НЕ закрыт (оставлен для отладки после падения теста)");
            }
            driver.remove();
        }
    }
}
