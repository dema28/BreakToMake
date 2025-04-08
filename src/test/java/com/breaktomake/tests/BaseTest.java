package com.breaktomake.tests;

import com.breaktomake.config.Environment;
import com.breaktomake.listeners.AllureListener;
import com.breaktomake.utils.DriverFactory;
import com.breaktomake.utils.LoggerUtil;
import com.breaktomake.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(AllureListener.class)
public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        LoggerUtil.info("🔧 Запуск WebDriver перед тестом");
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        LoggerUtil.info("✅ WebDriver инициализирован");

        driver.get(Environment.BASE_URL);
        LoggerUtil.info("🌐 Открыта стартовая страница: " + Environment.BASE_URL);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        boolean testFailed = result.getStatus() == ITestResult.FAILURE;

        if (testFailed && Environment.isScreenshotOnFail()) {
            LoggerUtil.info("\uD83D\uDCF8 Тест упал, делаем скриншот");
            ScreenshotUtil.captureScreenshot(driver, result.getName());
        }

        LoggerUtil.info("\uD83E\uDEBF Завершение теста: " + result.getName() + ". Успешность: " + !testFailed);
        DriverFactory.quitDriver(testFailed);
        LoggerUtil.logEnd("\uD83D\uDEB0 [tearDown] Драйвер закрыт");
    }
}
