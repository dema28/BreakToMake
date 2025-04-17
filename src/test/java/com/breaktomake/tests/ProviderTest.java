package com.breaktomake.tests;

import com.breaktomake.pages.MainPage;
import com.breaktomake.config.Environment;
import com.breaktomake.utils.CsvDataProvider;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static org.testng.Assert.assertTrue;

@Epic("UI Tests")
@Feature("Contact Form")
public class ProviderTest extends BaseTest {

    @Test(dataProvider = "contactFormData", dataProviderClass = CsvDataProvider.class,
            description = "Проверка отправки формы с валидными данными из CSV")
    @Story("Контактная форма")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Denis Novicov")
    @Description("TC_AUTO_J_003. Форма обратной связи успешно отправляется с корректными данными из CSV-файла")
    public void testSubmitContactFormWithCsvData(String firstName,
                                                 String lastName,
                                                 String email,
                                                 String phone,
                                                 String message,
                                                 String topic
    ) {
        MainPage mainPage = new MainPage(driver);

        step("Открытие главной страницы");
        mainPage.open(Environment.BASE_URL);

        step("Переход на вкладку 'Kontakty'");
        mainPage.clickOnMenu(com.breaktomake.enums.MenuItem.KONTAKTY);

        step("Прокрутка к форме обратной связи");
        mainPage.scrollToContactForm();

        step("Заполнение и отправка формы обратной связи");
        mainPage.fillAndSubmitContactForm(firstName, lastName, email, phone, message, topic);

        step("Проверка появления сообщения об успешной отправке");
        assertTrue(mainPage.isSuccessMessageDisplayed(), "Сообщение 'Děkujeme' не отображается после отправки формы.");
    }

    @Test(dataProvider = "validLoginData", dataProviderClass = CsvDataProvider.class)
    public void testValidLogin(String username, String password) {
        System.out.println("Логин: " + username + ", пароль: " + password);
    }
}
