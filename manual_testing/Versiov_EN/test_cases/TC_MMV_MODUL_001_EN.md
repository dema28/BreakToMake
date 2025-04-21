## TC_MMV_MODUL_001 — Contact Form Submission (Invalid Data)

## Description
    User is not authenticated

## Preconditions
    User is on the main page: https://modultest1.framer.website

## Test Steps
    1. Click on Kontakty
    2. Enter invalid data without name and email
    3. Click the Odeslat button

## Expected Result
    1. Contact form page is displayed
    2. Data is entered
    3. Form is not submitted

## Actual Result
    1. Contact form page is displayed
    2. Data is entered
    3. Form is not submitted

## Severity
    Medium

## Priority
    Medium

## Version
    Google Chrome version 134.0.6998.166 (Official Build) (64-bit)

### Test:  [test_contact_form_negative.py](https://github.com/dema28/CrashProof/blob/main/tests/test_contact_form_negative.py)
    Automation
