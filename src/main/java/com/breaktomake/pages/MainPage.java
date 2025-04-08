package com.breaktomake.pages;

import com.breaktomake.BasePage;
import com.breaktomake.enums.MenuItem;
import com.breaktomake.utils.ScrollUtil;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    @Step("Открытие страницы: {url}")
    public void open(String url) {
        driver.get(url);
    }

    @Step("Получение заголовка страницы")
    public String getTitle() {
        return driver.getTitle();
    }

    @Step("Переход во вкладку 'Katalog' и ожидание загрузки страницы")
    public void goToCatalogPage() {
        By katalogLocator = MenuItem.KATALOG.getLocator();
        By katalogPageHeader = By.xpath("//h2[contains(text(),'Katalog')]"); // или любой надёжный элемент на странице

        // Шаг 1: Ждём появления пункта меню
        waitForElementToBeVisible(katalogLocator);

        // Шаг 2: Кликаем по меню
        clickOnMenu(MenuItem.KATALOG);

        // Шаг 3: Ждём, пока страница каталога прогрузится
        waitForElementToBeVisible(katalogPageHeader);
    }

    @Step("Клик по карточке дома 'Modul 4'")
    public void clickOnHouseCard() {
        By modul4Card = By.xpath("//a[contains(@href, 'zdeny-modul-4')]");
        click(modul4Card);
    }

    @Step("Получение количества карточек домов")
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

    @Step("Клик по пункту меню: {menuItem.name}")
    public void clickOnMenu(MenuItem menuItem) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(Environment.getTimeout()))
                .until(ExpectedConditions.elementToBeClickable(menuItem.getLocator()));
        element.click();

        // Задержка для прогрузки страницы
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Step("Проверка отображения заголовка: {expectedHeader}")
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
                    Thread.sleep(500);
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
