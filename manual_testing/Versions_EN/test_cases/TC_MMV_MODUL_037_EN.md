## TC_MMV_MODUL_037 — Checking Website Behavior with Slow Connection (Slow 3G)

### Description
    -

### Preconditions
    Network throttling enabled through DevTools (mode 'Slow 3G')
    Website is available at https://modultest1.framer.website

### Test Steps
    1. Open Chrome DevTools and enable network emulation: F12->Network -> Throttling -> Slow 3G
    2. Navigate to the website https://modultest1.framer.website
    3. Wait for the main page to fully load 
    4. Navigate to the "Galerie" tab
    5. Evaluate how images, texts, and interactive elements load gradually

### Expected Result
    1. DevTools active
    2. Waiting for page to load
    3. Page fully loaded
    4. Page fully loaded
    5. Page fully loaded, with delays as expected

### Actual Result
    1. DevTools active
    2. Waiting for page to load
    3. Page fully loaded
    4. Page fully loaded
    5. Page fully loaded, with delays as expected

### Severity
    Medium

### Priority
    Medium

### Version
    Google Chrome: version 134.0.6998.166 (Official Build) (64-bit)

### Test
    Manual
