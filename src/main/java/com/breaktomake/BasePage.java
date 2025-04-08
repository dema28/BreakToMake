package com.breaktomake;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    private final int TIMEOUT = 10; // seconds

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ожидание видимости элемента: {locator}")
    protected WebElement waitForElementToBeVisible(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Step("Ожидание видимости всех элементов: {locator}")
    protected List<WebElement> waitForElementsToBeVisible(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    @Step("Ожидание кликабельности и нажатие по элементу: {locator}")
    protected void click(By locator) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    @Step("Получение текста элемента: {locator}")
    protected String getText(By locator) {
        return waitForElementToBeVisible(locator).getText();
    }

    @Step("Ввод текста '{text}' в элемент: {locator}")
    protected void type(By locator, String text) {
        WebElement element = waitForElementToBeVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    @Step("Прокрутка до элемента: {locator}")
    protected void scrollToElement(By locator) {
        WebElement element = waitForElementToBeVisible(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Step("Проверка отображения элемента: {locator}")
    protected boolean isDisplayed(By locator) {
        try {
            return waitForElementToBeVisible(locator).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }
}
