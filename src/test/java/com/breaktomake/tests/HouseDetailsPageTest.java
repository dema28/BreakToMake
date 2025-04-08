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

@Epic("UI Tests")
@Feature("House Project Details")
@Owner("Denis Novicov")
public class HouseDetailsPageTest extends BaseTest {

    @Test(description = "Проверка заголовка, характеристик и цен")
    @Story("Детальная информация о проекте дома")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяется заголовок проекта, основные характеристики и таблица с ценами")
    public void testHouseDetailsInfo() {
        try {
            LoggerUtil.logStart("testHouseDetailsInfo");

            MainPage mainPage = new MainPage(driver);
            mainPage.goToCatalogPage();
            mainPage.clickOnHouseCard();

            HouseDetailsPage housePage = new HouseDetailsPage(driver);
            Assert.assertTrue(housePage.getHouseTitle().contains("Modul 4"), "Заголовок не содержит 'Modul 4'");

            List<String> specs = housePage.getSpecsList();
            Assert.assertTrue(specs.contains("2 + KK"), "Нет характеристики '2 + KK'");
            Assert.assertTrue(specs.contains("45,0 m²"), "Нет площади '45,0 m²'");
            Assert.assertTrue(specs.contains("90 dní"), "Нет срока '90 dní'");

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
    @Description("Проверяется имя, должность, email и номер телефона контактного представителя")
    public void testContactPersonDetails() {
        try {
            LoggerUtil.logStart("testContactPersonDetails");

            MainPage mainPage = new MainPage(driver);
            mainPage.goToCatalogPage();
            mainPage.clickOnHouseCard();


            HouseDetailsPage housePage = new HouseDetailsPage(driver);

            Assert.assertEquals(housePage.getContactName(), "Pavel Vostárek", "Имя контакта неверно");
            Assert.assertTrue(housePage.getContactPosition().contains("Obchodní zastoupení"), "Неверная должность");
            Assert.assertEquals(housePage.getContactEmail(), "obchod@modulconstruct.eu", "Email контакта неверен");
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
