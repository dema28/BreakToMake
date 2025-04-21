## TC_MMV_MODUL_048 — Checking form submission with valid data from CSV

### Description
    Form is submitted with valid data from a CSV file (dataProvider).
    Sending data from files and user groups

### Preconditions
    User is on the homepage https://modultest1.framer.website

### Test Steps
    1. Go to the Kontakty section
    2. Fill the form with data from CSV
    3. Click the submit button
    4. Check the display of a successful submission message

### Expected Result
    The form is successfully submitted and the message 'Děkujeme' appears

### Actual Result
    The form is successfully submitted and the message 'Děkujeme' appears

### Severity
    Medium

### Priority
    Medium

### Version
    Google Chrome: version 134.0.6998.166 (Official Build) (64-bit)

### Test
    Automation

### JAVA: [TC_AUTO_J_003](https://github.com/dema28/BreakToMake/blob/main/src/test/java/com/breaktomake/tests/ProviderTest.java)