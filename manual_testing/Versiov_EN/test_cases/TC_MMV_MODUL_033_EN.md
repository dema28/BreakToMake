## TC_MMV_MODUL_033 — Required Fields Validation

### Description
    If required fields are not filled in, the system should notify about the error.

### Preconditions
    User is on the feedback page: https://modultest1.framer.website/kontakty

### Test Steps
    1. Fill in the fields (without phone)
    2. Select "Předmět" from the list
    3. Click the "Odeslat" button
    4. Fill in the fields (without Křestní jméno, Příjmení)
    5. Select "Předmět" from the list
    6. Click the "Odeslat" button
    7. Fill in the fields (without Příjmení)
    8. Select "Předmět" from the list
    9. Click the "Odeslat" button

### Expected Result
    1. Entered data is displayed
    2. Selected data is displayed
    3. Button changes name to "Dekujeme". Message is sent
    4. Entered data is displayed
    5. Selected data is displayed
    6. Field (Křestní jméno) is identified as unfilled.
    7. Entered data is displayed
    8. Selected data is displayed
    9. Button changes name to "Dekujeme". Message is sent

### Actual Result
    1. Entered data is displayed
    2. Selected data is displayed
    3. Button changes name to "Dekujeme". Message is sent
    4. Entered data is displayed
    5. Selected data is displayed
    6. Field (Křestní jméno) is identified as unfilled.
    7. Entered data is displayed
    8. Selected data is displayed
    9. Button changes name to "Dekujeme". Message is sent

### Severity
    Medium

### Priority
    Medium

### Version
    Google Chrome: version 134.0.6998.166 (Official Build) (64-bit)

### Test
    Manual
