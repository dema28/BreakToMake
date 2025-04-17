## TC_MMV_MODUL_041 — Работа якорных ссылок и скроллинга

## Description / Описание
    Проверка корректности навигации по странице

## Preconditions / Предусловия
    Перейти на страницу: https://modultest1.framer.website/katalog-dom%C5%AF/zdeny-modul-1

## Test Steps / Шаги тестирования
    1. Найти кликабельный элемент, ведущий к другому разделу ("Specifikace rozsahu dodávky: ZDE").
    2. Кликнуть и проверить, что страница плавно прокручивается к нужному блоку.
    3. Проверить, что URL меняется

## Expected Result / Ожидаемый результат
    1. Элемент найден
    2. Осуществился переход на ожидаемую страницу скрол работает
    3. url поменялся: https://modultest1.framer.website/rozsah-realizace#tabulka


## Actual Result / Фактический результат
    1. Элемент найден
    2. Осуществился переход на ожидаемую страницу скрол работает
    3. url поменялся: https://modultest1.framer.website/rozsah-realizace#tabulka

## Severity / Серьезность
    Medium

## Priority / Приоритет
    High

## Version / Версия
    Google Chrome: version 134.0.6998.166 (Official Build) (64-bit)

## Automated Test
    Manual