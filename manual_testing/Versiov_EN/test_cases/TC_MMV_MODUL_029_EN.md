## TC_MMV_MODUL_029 — Checking boundary values for the "Zpráva" field

### Description
    When entering minimum and maximum number of characters in the "Zpráva" field, the system should correctly process the data.

### Preconditions
    User is on the feedback form page (https://modultest1.framer.website/kontakty). The permissible limits for characters in the "Zpráva" field are known (minimum 10, maximum 500).

### Test Steps
    1. Enter the minimum allowed number of characters in the "Zpráva" field (10 characters)
    2. Enter a valid email
    3. Enter a valid "Křestní jméno"
    4. Click the "Odeslat" button
    5. Enter the maximum allowed number of characters (500 characters)
    6. Click the "Odeslat" button

### Expected Result
    1. Field accepts 10 characters without errors.
    2. Email is accepted without errors.
    3. Entered data is displayed in the "Křestní jméno" field
    4. Form is successfully submitted (with valid email and "Křestní jméno").
    5. Field accepts 500 characters without errors.
    6. Form is successfully submitted

### Actual Result
    1. Field accepts 10 characters without errors.
    2. Email is accepted without errors.
    3. Entered data is displayed in the "Křestní jméno" field
    4. Form is successfully submitted (with valid email and "Křestní jméno").
    5. Field accepts 500 characters without errors.
    6. Form is successfully submitted

### Severity
    Medium

### Priority
    Medium

### Version
    Google Chrome: version 134.0.6998.166 (Official Build) (64-bit)

### Test
    Manual
