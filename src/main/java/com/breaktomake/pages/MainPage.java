package com.breaktomake.pages;

import com.breaktomake.BasePage;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;

public class MainPage extends BasePage {

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
}

