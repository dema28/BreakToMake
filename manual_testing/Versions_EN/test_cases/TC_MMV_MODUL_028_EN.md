## TC_MMV_MODUL_028 — Checking special character input

## Description
    The form should correctly process special characters entered in fields.

## Preconditions
    User is on the feedback form page (https://modultest1.framer.website/kontakty)

## Test Steps
    1. Enter a string with special characters in the "Zpráva" field
    2. Fill all fields with valid data from the table:
    3. Click the "Odeslat" button

## Expected Result
    1. The "Zpráva" field accepts special characters without errors.
    2. Entered data is displayed
    3. Button changes name to "Dekujeme". Message is sent

## Actual Result
    1. The "Zpráva" field accepts special characters without errors.
    2. Entered data is displayed
    3. Button changes name to "Dekujeme". Message is sent

## Severity
    Minor

## Priority
    Low

## Version
    Google Chrome: version 134.0.6998.166 (Official Build) (64-bit)

## Test
    Manual

### Table
---
| Křestní jméno | Příjmení | E-mailová adresa | Telefon | Zpráva      |
|---------------|----------|------------------|---------|-------------|
|Danny          | Bellham  | dbellham0@mozilla.org | (808)419169312 | !"№;%:?*()_+"{}">|[]'\@#$^& |
---
