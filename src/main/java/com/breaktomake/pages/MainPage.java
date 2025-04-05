package com.breaktomake.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Локаторы
    private final By katalogButton = By.xpath("//*[text()='Katalog']");
    private final By houseCards = By.cssSelector("div.framer-1tgy7wc-container");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open(String baseUrl) {
        driver.get(baseUrl);
    }

    public void goToCatalog() {
        // Явное ожидание пока кнопка кликабельна
        WebElement catalogButton = wait.until(ExpectedConditions.elementToBeClickable(katalogButton));
        catalogButton.click();

        // Дожидаемся появления houseCards после клика — важно!
        wait.until(ExpectedConditions.visibilityOfElementLocated(houseCards));
    }


    public List<WebElement> getHouseCards() {
        return driver.findElements(houseCards);
    }
}
