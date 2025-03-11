package com.breaktomake.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    // Локаторы элементов на странице
    private By welcomeMessage = By.id("welcome-message");
    private By logoutButton = By.id("logout-button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для проверки отображения сообщения
    public String getWelcomeMessage() {
        return driver.findElement(welcomeMessage).getText();
    }

    // Метод для выхода из системы
    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }
}
