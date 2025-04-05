package com.breaktomake;

import com.breaktomake.pages.MainPage;
import com.breaktomake.utils.BaseTest;
import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners({AllureTestNg.class})
@Epic("Навигация")
@Feature("Переход в каталог и проверка карточек домов")
public class CatalogPageTest extends BaseTest {

    @Test(description = "Smoke-тест: переход на вкладку Каталог и проверка карточек домов")
    @Story("Каталог домов")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Переход в каталог с главной страницы, проверка и подсчёт карточек домов")
    public void testCatalogHouseCardsAreVisibleAndCounted() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);

        openMainPage(mainPage);
        Thread.sleep(500);
        goToCatalog(mainPage);
        List<WebElement> cards = getCards(mainPage);

        Assert.assertFalse(cards.isEmpty(), "В каталоге не найдены карточки домов!");

        for (WebElement card : cards) {
            Assert.assertTrue(card.isDisplayed(), "Карточка в каталоге не отображается");
        }

        int count = cards.size();
        logCardCount(count);
        System.out.println("Найдено карточек домов: " + count);
    }

    @Step("Открываем главную страницу")
    private void openMainPage(MainPage page) {
        String baseUrl = properties.getProperty("base.url", "https://modultest1.framer.website");
        page.open(baseUrl);
    }

    @Step("Переходим во вкладку Каталог")
    private void goToCatalog(MainPage page) {
        page.goToCatalog();
    }

    @Step("Получаем все карточки домов в каталоге")
    private List<WebElement> getCards(MainPage page) {
        return page.getHouseCards();
    }

    @Step("Количество карточек домов в каталоге: {count}")
    private void logCardCount(int count) {
        // Вывод для Allure
    }
}
