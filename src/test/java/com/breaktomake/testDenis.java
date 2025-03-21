package com.breaktomake;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class testDenis {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testWebForm() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        driver.findElement(By.xpath("//*[@id='my-text-id']")).sendKeys("Denis N");
        driver.findElement(By.xpath("//*[@name='my-password']")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@name='my-textarea']")).sendKeys("This is a text");
        driver.findElement(By.xpath("//*[@id='my-radio-2']")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-outline-primary mt-3']")).click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotNull(currentUrl);
        Assert.assertTrue(currentUrl.contains("submitted"), "Форма не была отправлена");
    }

    @Test
    public void testButtonClick() {
        driver.get("https://demoqa.com/buttons");

        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        actions.doubleClick(driver.findElement(By.xpath("//*[@id='doubleClickBtn']")))
                .contextClick(driver.findElement(By.xpath("//*[@id='rightClickBtn']")))
                .click(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Click Me']"))))
                .perform();

        Assert.assertTrue(
                driver.findElement(By.xpath("//*[@id='doubleClickMessage']")).isDisplayed(),
                "Кнопка была не нажата");
        Assert.assertTrue(
                driver.findElement(By.xpath("//*[@id='rightClickMessage']")).isDisplayed(),
                "Кнопка была не правым кликом");
        Assert.assertTrue(
                driver.findElement(By.xpath("//*[@id='dynamicClickMessage']")).isDisplayed(),
                "Кнопка была не нажата");
    }

    @Test
    public void radioButton() {
        driver.get("https://demoqa.com/radio-button");

        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement buttonYes = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='yesRadio']"))
        );
        actions.click(buttonYes).perform();

        WebElement buttonImpressive = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='impressiveRadio']"))
        );
        actions.click(buttonImpressive).perform();

        WebElement buttonNo = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='noRadio']"))
        );
        actions.click(buttonNo).perform();


        Assert.assertEquals(buttonYes.getText(), "Yes", "Текст элемента не совпадает с 'Yes'");
        Assert.assertEquals(buttonImpressive.getText(), "Impressive", "Текст элемента не совпадает с 'Impressive'");
        Assert.assertEquals(buttonNo.getText(), "No", "Текст элемента не совпадает с 'No'");
    }


    @Test
    public void testFormPractice() {

        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demoqa.com/automation-practice-form");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstName"))).sendKeys("Denis");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastName"))).sendKeys("Novicov");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("userEmail"))).sendKeys("denisnovicov@example.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("userNumber"))).sendKeys("7999999999");

        WebElement dobInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='dateOfBirthInput']")));
        actions.moveToElement(dobInput).click().perform();
        WebElement yearSelect = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@class='react-datepicker__year-select']")));

        Select yearDropdown = new Select(yearSelect);
        yearDropdown.selectByVisibleText("2000");
        WebElement monthSelect = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@class='react-datepicker__month-select']")));

        Select monthDropdown = new Select(monthSelect);
        monthDropdown.selectByVisibleText("December");
        WebElement dateElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--012']")));
        actions.moveToElement(dateElement).click().perform();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Male')]"))).click();

        WebElement subjectInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='subjectsInput']")));
        subjectInput.sendKeys("English");
        actions.sendKeys(Keys.ENTER).perform();
        subjectInput.sendKeys("Commerce");
        actions.sendKeys(Keys.ENTER).perform();

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//label[@for='hobbies-checkbox-1']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//label[contains(text(),'Reading')]"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//label[contains(text(),'Music')]"))).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='state']/div/div[2]"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='NCR']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("city"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Delhi']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("currentAddress"))).sendKeys("Prague, Vodickova 123/34");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='state']/div/div[2]"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='NCR']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("city"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Delhi']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit"))).click();

        WebElement modalTitle = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@class='modal-title h4' and text()='Thanks for submitting the form']")));
        Assert.assertTrue(modalTitle.isDisplayed(), "Модальное окно не отображается");

        WebElement table = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']")));

        Assert.assertTrue(table.isDisplayed(), "Таблица не отображается");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Student Name']/following-sibling::td")).getText(), "Denis Novicov", "Неверное имя студента");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Student Email']/following-sibling::td")).getText(), "denisnovicov@example.com", "Неверный email");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td")).getText(), "Male", "Неверный пол");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile']/following-sibling::td")).getText(), "7999999999", "Неверный номер телефона");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Date of Birth']/following-sibling::td")).getText(), "12 December,2000", "Неверная дата рождения");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Subjects']/following-sibling::td")).getText(), "English, Commerce", "Неверные предметы");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Hobbies']/following-sibling::td")).getText(), "Sports, Reading, Music", "Неверные хобби");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), "Prague, Vodickova 123/34", "Неверный адрес");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State and City']/following-sibling::td")).getText(), "NCR Delhi", "Неверный штат и город");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='closeLargeModal']"))).click();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}