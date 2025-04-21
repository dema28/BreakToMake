## TC_MMV_MODUL_024 — UI check for custom 404 page

### Description
    -

### Preconditions
    User is on the home page https://modultest1.framer.website/

### Test Steps
    1. User adds a non-existent page to the site URL in the search bar (/kotalog)
    2. Press ENTER

### Expected Result
    1. Address bar accepts the entered data
    2. Custom 404 error page is displayed

### Actual Result
    1. Address bar accepts the entered data
    2. Custom 404 error page is displayed

### Severity
    Medium

### Priority
    Medium

### Version
    Google Chrome: version 134.0.6998.166 (Official Build) (64-bit)

### Test
    Automation

### PYTHON: [UI check for custom 404 page](https://github.com/dema28/CrashProof/blob/main/tests/test_not_found_page.py)
