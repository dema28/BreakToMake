package com.breaktomake.pages;

import com.breaktomake.BasePage;
import com.breaktomake.enums.MenuItem;
import com.breaktomake.utils.ScrollUtil;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.breaktomake.config.Environment;



import java.time.Duration;
import java.util.List;


public class MainPage extends BasePage {

    private final By houseCards = By.xpath("//li[starts-with(@class, 'framer-')]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get page title")
    public String getTitle() {
        return driver.getTitle();
    }

    @Step("Open Main Page")
    public void open(String url) {
        driver.get(url);
    }

    public int getHouseCardCount() {
        return Allure.step("Получение количества карточек домов на главной", () -> {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Environment.getTimeout()));

            List<WebElement> cards = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(houseCards));

            if (!cards.isEmpty()) {
                ScrollUtil.scrollToElement(driver, cards.get(0));
            }

            Allure.step("Найдено карточек: " + cards.size());
            return cards.size();
        });
    }

    @Step("Кликаем по пункту меню: {menuItem.name}")
    public void clickOnMenu(MenuItem menuItem) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(Environment.getTimeout()))
                .until(ExpectedConditions.elementToBeClickable(menuItem.getLocator()));
        element.click();

        // Задержка после клика
        try {
            Thread.sleep(500); // 1.5 секунды
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


    @Step("Проверка заголовка страницы: {expectedHeader} с повторной попыткой")
    public boolean isHeaderVisible(String expectedHeader) {
        By headerLocator = By.xpath("//*[contains(@class, 'framer-text') and contains(normalize-space(text()), '" + expectedHeader + "')]");
        int attempts = 0;
        while (attempts < 3) {
            try {
                WebElement header = new WebDriverWait(driver, Duration.ofSeconds(Environment.getTimeout() + 5))
                        .until(ExpectedConditions.visibilityOfElementLocated(headerLocator));
                return header.isDisplayed();
            } catch (Exception e) {
                attempts++;
                try {
                    Thread.sleep(500); // подождать перед следующей попыткой
                } catch (InterruptedException ignored) {}
            }
        }
        return false;
    }


    @Step("Получение текущего URL")
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }







}

