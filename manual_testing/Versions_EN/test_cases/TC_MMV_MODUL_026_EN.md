## TC_MMV_MODUL_026 — Checking responsive design – no element overlap when resizing window

### Description
-

### Preconditions
    Access to the web application.
    Browser installed and supports window resizing mode
    (or use emulator).

### Test Steps
    1. Open browser and navigate to the application's home page.
    2. Gradually change the browser window size from maximum to minimum.
    3. Check the layout of main blocks (header, navigation, content, footer).

### Expected Result
    1. Page loaded and content is displayed
    2. Page elements (texts, images, buttons, menu) do not overlap,
        remain visible and readable at all stages of window resizing.
    3. Block layout is adaptive, there is no element overlap or distortion,
        content does not "jump" outside of containers.

### Actual Result
    1. Page loaded and content is displayed
    2. Page elements (texts, images, buttons, menu) do not overlap,     
        remain visible and readable at all stages of window resizing.
    3. Block layout is adaptive, there is no element overlap or distortion,
        content does not "jump" outside of containers.

### Severity
    Minor

### Priority
    Medium

### Version
    Google Chrome: version 134.0.6998.166 (Official Build) (64-bit)

### Test
    Manual
