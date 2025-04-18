package com.breaktomake.tests;

import com.breaktomake.pages.HouseDetailsPage;
import com.breaktomake.pages.MainPage;
import com.breaktomake.utils.LoggerUtil;
import com.breaktomake.utils.ScreenshotUtil;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.qameta.allure.Allure.step;

@Epic("UI Tests")
@Feature("House Project Details")
@Owner("Denis Novicov")
public class HouseDetailsPageTest extends BaseTest {

    @Test(description = "Проверка заголовка, характеристик и цен")
    @Story("Детальная информация о проекте дома")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC_AUTO_J_001. Проверяется заголовок проекта, основные характеристики и таблица с ценами")
    public void testHouseDetailsInfo() {
        try {
            LoggerUtil.logStart("testHouseDetailsInfo");

            step("Открываем главную страницу и переходим в каталог домов");
            MainPage mainPage = new MainPage(driver);
            mainPage.goToCatalogPage();

            step("Кликаем на карточку первого дома");
            mainPage.clickOnHouseCard();

            HouseDetailsPage housePage = new HouseDetailsPage(driver);

            step("Проверяем заголовок карточки проекта");
            Assert.assertTrue(housePage.getHouseTitle().contains("Modul 4"), "Заголовок не содержит 'Modul 4'");

            step("Проверяем характеристики проекта");
            List<String> specs = housePage.getSpecsList();
            Assert.assertTrue(specs.contains("2 + KK"), "Нет характеристики '2 + KK'");
            Assert.assertTrue(specs.contains("45,0 m²"), "Нет площади '45,0 m²'");
            Assert.assertTrue(specs.contains("90 dní"), "Нет срока '90 dní'");

            step("Проверяем цены по состояниям готовности");
            Map<String, String> prices = housePage.getPricesMap();
            Assert.assertEquals(prices.get("Hrubá stavba"), "400 200,-", "Цена Hrubá stavba неверна");
            Assert.assertEquals(prices.get("Před dokončením"), "739 500,-", "Цена Před dokončením неверна");

        } catch (Exception e) {
            ScreenshotUtil.captureScreenshot(driver, "testHouseDetailsInfo");
            LoggerUtil.logError("Ошибка в testHouseDetailsInfo", e);
            Assert.fail("Тест упал: " + e.getMessage());
        } finally {
            LoggerUtil.logEnd("testHouseDetailsInfo");
        }
    }


    @Test(description = "Проверка контактного лица на странице проекта")
    @Story("Контактная информация на карточке дома")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Denis Novicov")
    @Description("TC_AUTO_J_002. Проверяется имя, должность, email и номер телефона контактного представителя")
    public void testContactPersonDetails() {
        try {
            LoggerUtil.logStart("testContactPersonDetails");

            step("Открываем главную страницу и переходим в каталог домов");
            MainPage mainPage = new MainPage(driver);
            mainPage.goToCatalogPage();

            step("Кликаем на карточку первого дома");
            mainPage.clickOnHouseCard();

            HouseDetailsPage housePage = new HouseDetailsPage(driver);

            step("Проверяем имя контактного лица");
            Assert.assertEquals(housePage.getContactName(), "Pavel Vostárek", "Имя контакта неверно");

            step("Проверяем должность контактного лица");
            Assert.assertTrue(housePage.getContactPosition().contains("Obchodní zastoupení"), "Неверная должность");

            step("Проверяем email контактного лица");
            Assert.assertEquals(housePage.getContactEmail(), "obchod@modulconstruct.eu", "Email контакта неверен");

            step("Проверяем номер телефона контактного лица");
            Assert.assertEquals(housePage.getContactPhone(), "+420 607 354 180", "Телефон контакта неверен");

        } catch (Exception e) {
            ScreenshotUtil.captureScreenshot(driver, "testContactPersonDetails");
            LoggerUtil.logError("Ошибка в testContactPersonDetails", e);
            Assert.fail("Тест упал: " + e.getMessage());
        } finally {
            LoggerUtil.logEnd("testContactPersonDetails");
        }
    }
}
