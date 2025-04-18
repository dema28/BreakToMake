package com.breaktomake.pages;

import com.breaktomake.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HouseDetailsPage extends BasePage {

    private final By title = By.tagName("h1");
    private final By specs = By.cssSelector("ul.framer-uma6ox li h3.framer-text");

    private final By contactName = By.xpath("//*[contains(normalize-space(text()), 'Pavel Vostárek')]");
    private final By contactPosition = By.xpath("//*[contains(text(), 'Obchodní')]");
    private final By contactEmail = By.xpath("//*[contains(text(), 'obchod@modulconstruct.eu')]");
    private final By contactPhone = By.xpath("//*[contains(text(), '+420 607 354 180')]");
    private final By pricesContainer = By.xpath("//div[contains(@class,'framer-rd9xpe')]");

    public HouseDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получаем заголовок карточки дома")
    public String getHouseTitle() {
        return waitForElementToBeVisible(title).getText();
    }

    @Step("Получаем список характеристик дома")
    public List<String> getSpecsList() {
        return waitForElementsToBeVisible(specs)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @Step("Получаем цены из карточки дома")
    public Map<String, String> getPricesMap() {
        scrollToElement(pricesContainer);

        List<WebElement> allP = waitForElementsToBeVisible(
                By.xpath("//div[contains(@class,'framer-rd9xpe')]//p"));
        Map<String, String> prices = new HashMap<>();

        for (int i = 0; i < allP.size() - 1; i++) {
            String title = allP.get(i).getText().trim();
            String value = allP.get(i + 1).getText().trim();

            if (title.endsWith(":") && value.matches(".*\\d.*,-.*")) {
                prices.put(title.replace(":", ""), value);
                i++;
            }
        }
        return prices;
    }

    @Step("Получаем имя контактного лица")
    public String getContactName() {
        scrollToElement(contactName);
        return waitForElementToBeVisible(contactName).getText();
    }

    @Step("Получаем должность контактного лица")
    public String getContactPosition() {
        return waitForElementToBeVisible(contactPosition).getText();
    }

    @Step("Получаем email контактного лица")
    public String getContactEmail() {
        return waitForElementToBeVisible(contactEmail).getText().trim();
    }

    @Step("Получаем телефон контактного лица")
    public String getContactPhone() {
        return waitForElementToBeVisible(contactPhone).getText();
    }
}
