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
            LoggerUtil.info(com.breaktomake.utils.LoggerTag.DRIVER, "🌐 Инициализация драйвера: " + browser);

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();

                    List<String> chromeArgs = Environment.getChromeOptions();
                    if (!chromeArgs.isEmpty()) {
                        for (String arg : chromeArgs) {
                            options.addArguments(arg);
                        }
                        LoggerUtil.debug(com.breaktomake.utils.LoggerTag.DRIVER, "⚙️ Доп. Chrome аргументы: " + chromeArgs);
                    }

                    String windowSize = Environment.getWindowSize();
                    if (windowSize != null && !windowSize.isBlank()) {
                        options.addArguments("--window-size=" + windowSize);
                        LoggerUtil.info(com.breaktomake.utils.LoggerTag.DRIVER, "🪟 Размер окна: " + windowSize);
                    }

                    if (Environment.isHeadless()) {
                        options.addArguments("--headless=new");
                        LoggerUtil.info(com.breaktomake.utils.LoggerTag.DRIVER, "🔒 Headless режим включен");
                    } else {
                        LoggerUtil.info(com.breaktomake.utils.LoggerTag.DRIVER, "🖥️ Headless режим отключен (GUI)");
                    }

                    driver.set(new ChromeDriver(options));
                    LoggerUtil.info(com.breaktomake.utils.LoggerTag.DRIVER, "✅ ChromeDriver запущен");
                    break;

                default:
                    LoggerUtil.error(com.breaktomake.utils.LoggerTag.DRIVER, "❌ Неподдерживаемый браузер: " + browser, null);
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver(boolean testFailed) {
        if (driver.get() != null) {
            if (!testFailed || Environment.isCloseBrowserOnError()) {
                LoggerUtil.info(com.breaktomake.utils.LoggerTag.DRIVER, "🚪 Закрытие WebDriver. Тест упал: " + testFailed);
                driver.get().quit();
            } else {
                LoggerUtil.info(com.breaktomake.utils.LoggerTag.DRIVER, "🚫 WebDriver НЕ закрыт (оставлен для отладки после падения теста)");
            }
            driver.remove();
        }
    }
}
