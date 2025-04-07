package com.breaktomake.tests;

import com.breaktomake.config.Environment;
import com.breaktomake.pages.MainPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("UI Tests")
@Feature("Main Page")
public class MainPageTest extends BaseTest {

    @Test(description = "Smoke: Loading the Main Page")
    @Story("Smoke Test")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Denis Novicov")
    @Description("Verifies that the main page loads correctly and contains the expected title.")
    public void testMainPageLoadsSuccessfully() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open(Environment.BASE_URL);

        String expectedTitle = "Modulconstruct - Líšnice";
        String actualTitle = mainPage.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle),
                "The page title does not contain the expected text: '" + expectedTitle + "'");
    }

    @Test(description = "Smoke: Проверка отображения и количества карточек домов")
    @Story("Smoke-тест главного UI-блока")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Denis Novicov")
    @Description("Проверка, что карточки домов отображаются на главной странице и их количество соответствует ожиданиям.")
    public void testHouseCardsDisplayedAndCounted() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open(Environment.BASE_URL);

        int cardCount = mainPage.getHouseCardCount();

        Assert.assertTrue(cardCount > 0, "Карточки домов не найдены на главной странице.");
        Assert.assertEquals(cardCount, 7, "Количество карточек домов не совпадает с ожидаемым.");
    }
}
