# Common Issues When Running Autotests with Allure and Their Solutions

Below are the most common issues encountered when running autotests using Allure, along with recommendations for resolving them.

| Error | Possible Cause | Solution |
|-------|----------------|----------|
| `allure: command not found` | Allure CLI is not installed or not added to `PATH` | Install Allure CLI: `scoop install allure` (Windows) or `brew install allure` (macOS) |
| `allure-results not found` | Tests didn’t generate results | Ensure that the tests actually ran and did not fail in `@Before*` methods or in `BaseTest`. Also check that Allure annotations such as `@Listeners(AllureListener.class)` or similar are used. |
| `Could not find or load main class` | Incorrect command syntax | Make sure you use the format `mvn -Dtest=ClassName#MethodName test` without typos or extra characters. |
| `DISPLAY not set` on Linux/CI | No virtual display for headless browser | Add `export DISPLAY=:99` before launching the browser and configure Xvfb as shown in the CI configuration. |
| Allure report is empty / won’t open | Results weren’t saved or path is incorrect | Ensure the results are in `target/allure-results` and generate the report with: `allure generate target/allure-results --clean -o target/allure-report`. Open with `allure open target/allure-report`. |
| No steps, descriptions, or labels in report | Allure annotations not used in tests | Add annotations like `@Epic`, `@Feature`, `@Severity`, `@Description`, `@Step`, `@Owner`, etc. to the tests for full reporting. |
| `WebDriverException: unknown error: cannot find Chrome binary` | Chrome is not installed on CI | Ensure that Google Chrome is installed and available in the system. On Ubuntu, install it via `apt install google-chrome-stable`. |

---

If you encounter a different error — add it to this list. The more complete this reference becomes, the faster you'll solve problems in the future.
