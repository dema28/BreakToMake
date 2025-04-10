package com.breaktomake.pages;

import com.breaktomake.BasePage;
import com.breaktomake.enums.MenuItem;
import com.breaktomake.utils.LoggerTag;
import com.breaktomake.utils.LoggerUtil;
import com.breaktomake.utils.ScrollUtil;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.breaktomake.config.Environment;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class MainPage extends BasePage {

    private final By houseCards = By.xpath("//li[starts-with(@class, 'framer-')]");
    private final By facebookIcon = By.cssSelector("a[href*='facebook.com']");
    private final By instagramIcon = By.cssSelector("a[href*='instagram.com']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы: {url}")
    public void open(String url) {
        driver.get(url);
    }

    @Step("Получение заголовка страницы")
    public String getTitle() {
        return driver.getTitle();
    }

    @Step("Переход во вкладку 'Katalog' и ожидание загрузки страницы")
    public void goToCatalogPage() {
        By katalogLocator = MenuItem.KATALOG.getLocator();
        By katalogPageHeader = By.xpath("//h2[contains(text(),'Katalog')]");

        waitForElementToBeVisible(katalogLocator);
        clickOnMenu(MenuItem.KATALOG);
        waitForElementToBeVisible(katalogPageHeader);
    }

    @Step("Клик по карточке дома 'Modul 4'")
    public void clickOnHouseCard() {
        By modul4Card = By.xpath("//a[contains(@href, 'zdeny-modul-4')]");
        click(modul4Card);
    }

    @Step("Получение количества карточек домов")
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

    @Step("Клик по пункту меню: {menuItem.name}")
    public void clickOnMenu(MenuItem menuItem) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(Environment.getTimeout()))
                .until(ExpectedConditions.elementToBeClickable(menuItem.getLocator()));
        element.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Step("Проверка отображения заголовка: {expectedHeader}")
    public boolean isHeaderVisible(String expectedHeader) {
        By headerLocator = By.xpath("//*[contains(@class, 'framer-text') and contains(normalize-space(text()), '" + expectedHeader + "')]");
        int attempts = 0;
        while (attempts < 3) {
            try {
                WebElement header = new WebDriverWait(driver, Duration.ofSeconds(Environment.getTimeout() + 5))
                        .until(ExpectedConditions.visibilityOfElementLocated(headerLocator));
                return header.isDisplayed();
            } catch (Exception e) {
                attempts++;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ignored) {}
            }
        }
        return false;
    }

    @Step("Получение текущего URL")
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Step("Клик по иконке Facebook")
    public void clickFacebookIcon() {
        WebElement element = driver.findElement(facebookIcon);
        ScrollUtil.scrollToElement(driver, element);
        LoggerUtil.info(LoggerTag.PAGE, "🖱 Клик по иконке Facebook");
        element.click();
    }

    @Step("Получение URL иконки Instagram")
    public String getInstagramUrl() {
        WebElement element = driver.findElement(instagramIcon);
        ScrollUtil.scrollToElement(driver, element);
        String instagramUrl = element.getAttribute("href");
        LoggerUtil.info(LoggerTag.PAGE, "🔗 Получен URL Instagram: " + instagramUrl);
        return instagramUrl;
    }




    @Step("Переключение на новую вкладку и получение URL")
    public String switchToNewTabAndGetUrl() {
        String originalWindow = driver.getWindowHandle();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.getWindowHandles().size() > 1);

        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                LoggerUtil.info(LoggerTag.PAGE, "🔀 Переключение на новую вкладку");
                String newUrl = driver.getCurrentUrl();
                LoggerUtil.info(LoggerTag.PAGE, "🔗 Получен URL: " + newUrl);
                return newUrl;
            }
        }
        return null;
    }

    @Step("Заполнение и отправка контактной формы")
    public void fillAndSubmitContactForm(String firstName, String lastName, String email, String phone, String message, String topic) {
        scrollToElement(By.tagName("form"));

        // Заполнение полей
        type(By.xpath("//input[@name='Křestní jméno']"), firstName);
        type(By.xpath("//*[@name='Příjmení']"), lastName);
        type(By.xpath("//*[@name='E-mailová adresa']"), email);
        type(By.xpath("//*[@name='Telefon']"), phone);
        type(By.xpath("//*[@name='Zpráva']"), message);

        // Выбор из выпадашки
        selectTopicFromDropdown(topic);

        // 🔄 Ждём появления успешного сообщения и кликаем только один раз
        clickSubmitButton();

        // Ждём, что сообщение об успешной отправке появится
        assertTrue(isSuccessMessageDisplayed(), "Сообщение 'Děkujeme' не отображается после отправки формы.");
    }



    @Step("Выбор темы из выпадающего списка: {topic}")
    public void selectTopicFromDropdown(String topic) {
        By dropdown = By.xpath("//select[@name='Předmět']");
        click(dropdown);  // Открыть выпадашку

        By wrapper = By.xpath("//div[contains(@class, 'framer-form-select-wrapper')]");
        WebElement container = waitForElementToBeVisible(wrapper);
        List<WebElement> options = container.findElements(By.tagName("option"));

        LoggerUtil.info(LoggerTag.PAGE, "📋 Все найденные значения в выпадашке:");
        boolean found = false;
        for (WebElement option : options) {
            String text = option.getText().trim();
            LoggerUtil.debug(LoggerTag.PAGE, "🔹 " + text);
            if (text.equals(topic)) {
                option.click(); // Выбор нужного
                found = true;
                break;
            }
        }

        if (!found) {
            LoggerUtil.error(LoggerTag.PAGE, "❌ Вариант '" + topic + "' не найден среди доступных");
            throw new RuntimeException("Значение '" + topic + "' не найдено в выпадающем списке.");
        }

        // 🧹 Попытка закрыть выпадашку несколькими способами
        try {
            LoggerUtil.debug(LoggerTag.PAGE, "🧪 Попытка закрыть выпадашку через ESC");
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.ESCAPE).perform();
            Thread.sleep(500); // Подождать, чтобы всё закрылись
        } catch (Exception e) {
            LoggerUtil.warn(LoggerTag.PAGE, "⚠️ Не удалось закрыть через ESC: " + e.getMessage());
        }

        LoggerUtil.debug(LoggerTag.PAGE, "📌 Выпадашка закрыта (по ESC)");
    }

    @Step("Нажатие на кнопку 'Odeslat'")
    public void clickSubmitButton() {
        By submitButton = By.xpath("//button[@type='submit' and contains(., 'Odeslat')]");

        // Прокрутка к кнопке
        WebElement button = waitForElementToBeVisible(submitButton);
        ScrollUtil.scrollToElement(driver, button);

        // Убедиться, что кнопка активна
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(submitButton));

        LoggerUtil.info(LoggerTag.PAGE, "🖱 Нажимаем кнопку 'Odeslat'");
        button.click();
    }












    @Step("Проверка появления сообщения об успешной отправке")
    public boolean isSuccessMessageDisplayed() {
        By successMessage = By.xpath("//p[contains(@class, 'framer-text') and contains(text(), 'Děkujeme')]");
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
        } catch (TimeoutException e) {
            LoggerUtil.warn(LoggerTag.PAGE, "⚠️ Сообщение об успешной отправке не появилось");
            return false;
        }
    }


    @Step("Прокрутка к контактной форме")
    public void scrollToContactForm() {
        WebElement form = driver.findElement(By.xpath("//*[@id='formulář']")); // при необходимости уточним локатор
        ScrollUtil.scrollToElement(driver, form);
    }







}
