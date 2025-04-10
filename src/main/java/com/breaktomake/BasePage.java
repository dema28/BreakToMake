package com.breaktomake;

import com.breaktomake.config.Environment;
import com.breaktomake.utils.LoggerTag;
import com.breaktomake.utils.LoggerUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    private final int TIMEOUT = Environment.getTimeout(); // теперь через конфиг

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ожидание видимости элемента: {locator}")
    protected WebElement waitForElementToBeVisible(By locator) {
        LoggerUtil.debug(LoggerTag.PAGE, "⌛ Ждём видимость элемента: " + locator);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Step("Ожидание видимости всех элементов: {locator}")
    protected List<WebElement> waitForElementsToBeVisible(By locator) {
        LoggerUtil.debug(LoggerTag.PAGE, "⌛ Ждём видимость всех элементов: " + locator);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    @Step("Ожидание кликабельности и нажатие по элементу: {locator}")
    protected void click(By locator) {
        LoggerUtil.info(LoggerTag.PAGE, "🖱 Клик по элементу: " + locator);
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    @Step("Получение текста элемента: {locator}")
    protected String getText(By locator) {
        LoggerUtil.debug(LoggerTag.PAGE, "🔍 Получение текста элемента: " + locator);
        return waitForElementToBeVisible(locator).getText();
    }

    @Step("Получение текста из WebElement")
    protected String getText(WebElement element) {
        LoggerUtil.debug(LoggerTag.PAGE, "🔍 Получение текста из элемента: " + element);
        return element.getText();
    }

    @Step("Ввод текста '{text}' в элемент: {locator}")
    protected void type(By locator, String text) {
        LoggerUtil.info(LoggerTag.PAGE, "⌨️ Ввод текста: '" + text + "' в элемент: " + locator);
        WebElement element = waitForElementToBeVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    @Step("Прокрутка до элемента: {locator}")
    protected void scrollToElement(By locator) {
        LoggerUtil.debug(LoggerTag.PAGE, "📜 Прокрутка до элемента: " + locator);
        WebElement element = waitForElementToBeVisible(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Step("Проверка отображения элемента: {locator}")
    protected boolean isDisplayed(By locator) {
        try {
            boolean visible = waitForElementToBeVisible(locator).isDisplayed();
            LoggerUtil.debug(LoggerTag.PAGE, "✅ Элемент отображается: " + locator);
            return visible;
        } catch (TimeoutException | NoSuchElementException e) {
            LoggerUtil.warn(LoggerTag.PAGE, "⚠️ Элемент не найден или не отображается: " + locator);
            return false;
        }
    }
}
