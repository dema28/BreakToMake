## TC_MMV_MODUL_021 — Display of error page (404) when navigating to a non-existent URL

### Description
    Web application is accessible to the user

### Preconditions
    User has access to the web application

### Test Steps
    1. Open browser and enter a non-existent URL in the address bar (https://not.modultest1.framer.website)
    2. Press Enter to navigate to the specified URL

### Expected Result
    1. Browser is open, address bar accepts the entered data
    2. Error page 404 is displayed with a message that the requested page was not found

### Actual Result
    1. Browser is open, address bar accepts the entered data
    2. Error page 404 is displayed with a message that the requested page was not found

### Severity
    Medium

### Priority
    Medium

### Version
    Google Chrome: version 134.0.6998.166 (Official Build) (64-bit)

### Test
    Manual/Automation

### PYTHON: [Check that non-existent page returns 404 status](https://github.com/dema28/CrashProof/blob/main/tests/test_not_found_page.py)
