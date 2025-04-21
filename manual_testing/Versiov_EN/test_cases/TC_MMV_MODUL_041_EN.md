## TC_MMV_MODUL_041 — Anchor links and scrolling functionality

## Description
    Verification of correct page navigation

## Preconditions
    Navigate to page: https://modultest1.framer.website/katalog-dom%C5%AF/zdeny-modul-1

## Test Steps
    1. Find a clickable element leading to another section ("Specifikace rozsahu dodávky: ZDE").
    2. Click and verify that the page smoothly scrolls to the desired block.
    3. Check that the URL changes

## Expected Result
    1. Element is found
    2. Navigation to the expected page occurred and scrolling works
    3. URL changed to: https://modultest1.framer.website/rozsah-realizace#tabulka

## Actual Result
    1. Element is found
    2. Navigation to the expected page occurred and scrolling works
    3. URL changed to: https://modultest1.framer.website/rozsah-realizace#tabulka

## Severity
    Medium

## Priority
    High

## Version
    Google Chrome: version 134.0.6998.166 (Official Build) (64-bit)

## Automated Test
    Manual