package com.breaktomake.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Локаторы элементов на странице
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для ввода логина
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    // Метод для ввода пароля
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Метод для нажатия кнопки входа
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    // Метод для выполнения полного входа в систему
    public HomePage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        return new HomePage(driver);
    }
}