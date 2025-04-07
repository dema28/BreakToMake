package com.breaktomake.pages;

import com.breaktomake.BasePage;
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




}

