package com.breaktomake.tests;

import com.breaktomake.config.Environment;
import com.breaktomake.enums.MenuItem;
import com.breaktomake.pages.MainPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;


import static io.qameta.allure.Allure.step;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Epic("UI Tests")
@Feature("Main Page")
public class MainPageTest extends BaseTest {

    @Test(description = "Smoke: Loading the Main Page")
    @Story("Smoke Test")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Denis Novicov")
    @Description("TC_AUTO_J_004. Verifies that the main page loads correctly and contains the expected title.")
    public void testMainPageLoadsSuccessfully() {
        MainPage mainPage = new MainPage(driver);

        step("Открытие главной страницы");
        mainPage.open(Environment.BASE_URL);

        step("Получение заголовка страницы и проверка");
        String expectedTitle = "Modulconstruct - Líšnice";
        String actualTitle = mainPage.getTitle();

        assertTrue(actualTitle.contains(expectedTitle),
                "The page title does not contain the expected text: '" + expectedTitle + "'");
    }

    @Test(description = "Smoke: Проверка отображения и количества карточек домов")
    @Story("Smoke-тест главного UI-блока")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Denis Novicov")
    @Description("TC_AUTO_J_006. Проверка, что карточки домов отображаются на главной странице и их количество соответствует ожиданиям.")
    public void testHouseCardsDisplayedAndCounted() {
        MainPage mainPage = new MainPage(driver);

        step("Открытие главной страницы");
        mainPage.open(Environment.BASE_URL);

        step("Получение количества карточек домов");
        int cardCount = mainPage.getHouseCardCount();

        step("Проверка, что карточки отображаются и их 7");
        assertTrue(cardCount > 0, "Карточки домов не найдены на главной странице.");
        assertEquals(cardCount, 7, "Количество карточек домов не совпадает с ожидаемым.");
    }


    @Test(description = "Проверка переходов по основным пунктам меню")
    @Story("Навигация по сайту")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Denis Novicov")
    @Description("TC_AUTO_J_005. Навигация по главным разделам через меню: проверка переходов и соответствия заголовков страниц")
    public void testMenuNavigation() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open(Environment.BASE_URL);

        for (MenuItem item : new MenuItem[]{MenuItem.KATALOG, MenuItem.PROJEKT, MenuItem.O_NAS, MenuItem.REALIZACE, MenuItem.KARIERA, MenuItem.GALERIE}) {
            mainPage.clickOnMenu(item);

            assertTrue(mainPage.isHeaderVisible(item.getExpectedHeader()), "Заголовок '" + item.getExpectedHeader() + "' не найден");
            assertEquals(mainPage.getCurrentUrl(), item.getExpectedFullUrl(),"URL для '" + item.getName() + "' не совпадает");

        }
    }

    @Test(description = "Проверка перехода по ссылке Instagram")
    @Story("Переход по ссылке Instagram")
    @Description("TC_AUTO_J_007. Проверка, что ссылка в футере корректно ведёт на Instagram-профиль компании")
    public void testInstagramLinkOpensCorrectProfile() {
        MainPage mainPage = new MainPage(driver);

        step("Получение URL иконки Instagram");
        String actualUrl = mainPage.getInstagramUrl();

        step("Проверка, что ссылка ведет на правильный Instagram профиль");
        String expectedUrl = "https://www.instagram.com/modul.construct/";
        assertTrue(actualUrl.contains(expectedUrl), "Ожидался переход на: " + expectedUrl + " но перешли на: " + actualUrl);
    }


    @Test(description = "Проверка перехода по ссылке Facebook")
    @Story("Переход по ссылке Facebook")
    @Description("TC_AUTO_J_008. Проверка, что ссылка в футере корректно ведёт на Facebook-профиль компании")
    public void testFacebookLinkOpensCorrectProfile() {
        MainPage mainPage = new MainPage(driver);

        step("Клик по иконке Facebook");
        mainPage.clickFacebookIcon();

        step("Переключение на новую вкладку и получение URL");
        String fbUrl = mainPage.switchToNewTabAndGetUrl();

        step("Проверка URL Facebook");
        assertUrlContains(fbUrl, "facebook.com/people/Modul-Construct/61552282003531/");

    }

    @Step("Проверка, что URL содержит: {expected}")
    private void assertUrlContains(String actualUrl, String expected) {
        assertTrue(actualUrl != null && actualUrl.contains(expected),
                "Открыт не тот URL или вкладка не открылась. Текущий: " + actualUrl);
    }
}
