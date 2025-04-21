## TC_MMV_MODUL_011 — Menu clickability in mobile version

### Description
    -

### Preconditions
    User is on https://modultest1.framer.website
    Browser is open in mobile version

### Test Steps
    1. Click on the menu icon in the upper right corner
    2. Hover the cursor over any menu and click
    3. Click on the menu again

### Expected Result
    1. The dropdown menu is displayed
    2. Navigated to the selected tab
    3. The dropdown list is displayed, there is no visual indication of which tab 
    the user is on

### Actual Result
    1. The dropdown menu is displayed
    2. Navigated to the selected tab
    3. The dropdown list is displayed, there is no visual indication of which tab 
    the user is on

### Severity
    Medium

### Priority
    Medium

### Version
    Google Chrome Mobile

### Test
    Manual/Automation

### PYTHON: [Menu items are clickable and lead to correct sections (mobile)](https://github.com/dema28/CrashProof/blob/main/tests/test_main_page_mobile.py)
### [BUG_MMSRO_004_RU – Lack of feedback on tab buttons](../../bug_reports/BUG_MMSRO_004_RU.md)
