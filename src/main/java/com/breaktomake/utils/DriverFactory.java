package com.breaktomake.utils;

import com.breaktomake.config.Environment;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

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

                    // ✅ Применяем дополнительные Chrome-аргументы из config
                    List<String> chromeArgs = Environment.getChromeOptions();
                    if (!chromeArgs.isEmpty()) {
                        for (String arg : chromeArgs) {
                            options.addArguments(arg);
                        }
                        LoggerUtil.info("⚙️ Доп. Chrome аргументы: " + chromeArgs);
                    }

                    // ✅ Применяем размер окна из config
                    String windowSize = Environment.getWindowSize();
                    if (windowSize != null && !windowSize.isBlank()) {
                        options.addArguments("--window-size=" + windowSize);
                        LoggerUtil.info("🪟 Размер окна: " + windowSize);
                    }

                    // ✅ Headless режим по флагу
                    if (Environment.isHeadless()) {
                        options.addArguments("--headless=new");
                        LoggerUtil.info("🔒 Headless режим включен");
                    } else {
                        LoggerUtil.info("🖥️ Headless режим отключен (GUI)");
                    }

                    driver.set(new ChromeDriver(options));
                    LoggerUtil.info("✅ ChromeDriver запущен");
                    break;

                default:
                    LoggerUtil.error("❌ Неподдерживаемый браузер: " + browser, null);
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

//            driver.get().manage().window().maximize(); // по умолчанию
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
