package com.breaktomake.tests;

import com.breaktomake.listeners.AllureListener;
import com.breaktomake.utils.DriverFactory;
import com.breaktomake.utils.LoggerUtil;
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
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        boolean testFailed = result.getStatus() == ITestResult.FAILURE;
        LoggerUtil.info("🧹 Завершение работы WebDriver после теста. Тест упал? " + testFailed);
        DriverFactory.quitDriver(testFailed);
        LoggerUtil.info("✅ WebDriver закрыт");
    }
}
