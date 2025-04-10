
package com.breaktomake.enums;

import com.breaktomake.config.Environment;
import org.openqa.selenium.By;

public enum MenuItem {
    KATALOG("Katalog",
            By.xpath("//h2[text()='Katalog']"), "Katalog",
            Environment.KATALOG_PAGE),

    PROJEKT("kontakty",
            By.xpath("//h2[text()='Projekty']"), "Projekty",
            Environment.PROJEKT_PAGE),

    O_NAS("O nas",
            By.xpath("//h2[text()='O nás']"), "O nás",
            Environment.O_NAS_PAGE),

    REALIZACE("Realizace",
            By.xpath("//h2[text()='Realizace']"), "Realizace",
            Environment.REALIZACE_PAGE),

    KARIERA("Kariéra",
            By.xpath("//h2[text()='Kariéra']"),"Kariéra",
            Environment.KARIERA_PAGE),

    GALERIE("Galerie",
            By.xpath("//h2[text()='Galerie']"),"Galerie",
            Environment.GALERIE_PAGE),

    KONTAKTY("Kontakty",
            By.xpath("//a[.//p[text()='Kontakty']]"),"Kontakty",
            Environment.KONTAKTY_PAGE);

    private final String name;
    private final By locator;
    private final String expectedHeader;
    private final String expectedFullUrl;

    MenuItem(String name, By locator, String expectedHeader, String expectedFullUrl) {
        this.name = name;
        this.locator = locator;
        this.expectedHeader = expectedHeader;
        this.expectedFullUrl = expectedFullUrl;
    }

    public String getName() {
        return name;
    }

    public By getLocator() {
        return locator;
    }

    public String getExpectedHeader() {
        return expectedHeader;
    }

    public String getExpectedFullUrl() {
        return expectedFullUrl;
    }
}

