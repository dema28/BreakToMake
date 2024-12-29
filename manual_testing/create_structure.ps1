# Главная папка
New-Item -ItemType Directory -Path "manual_testing" | Out-Null

# Подпапки
$folders = @(
    "user_stories\authentication",
    "user_stories\shopping_cart",
    "user_stories\product_page",
    "test_cases\smoke_tests",
    "test_cases\regression_tests",
    "test_cases\feature_tests",
    "bug_reports\UI_issues",
    "bug_reports\functionality",
    "bug_reports\performance",
    "supporting_documents\requirements",
    "supporting_documents\checklists",
    "supporting_documents\diagrams"
)

foreach ($folder in $folders) {
    New-Item -ItemType Directory -Path "manual_testing\$folder" | Out-Null
}

# Примеры файлов
$files = @{
    "user_stories\authentication" = @("login.md", "registration.md", "forgot_password.md")
    "user_stories\shopping_cart" = @("add_to_cart.md", "remove_from_cart.md", "checkout.md")
    "user_stories\product_page" = @("view_product_details.md", "filter_and_search.md")
    "test_cases\smoke_tests" = @("login_smoke_test.xlsx", "registration_smoke_test.xlsx")
    "test_cases\regression_tests" = @("cart_regression.xlsx", "search_regression.xlsx")
    "test_cases\feature_tests" = @("product_details.xlsx", "checkout.xlsx")
    "bug_reports\UI_issues" = @("button_alignment_issue.md", "incorrect_error_messages.md")
    "bug_reports\functionality" = @("login_fails_on_valid_credentials.md", "cart_does_not_update.md")
    "bug_reports\performance" = @("slow_response_on_checkout.md", "search_query_timeout.md")
    "supporting_documents\requirements" = @("functional_requirements.md", "non_functional_requirements.md")
    "supporting_documents\checklists" = @("smoke_test_checklist.xlsx", "UI_checklist.xlsx")
    "supporting_documents\diagrams" = @("use_case_diagram.png", "flowchart_authentication.png")
}

foreach ($folder in $files.Keys) {
    foreach ($file in $files[$folder]) {
        New-Item -ItemType File -Path "manual_testing\$folder\$file" | Out-Null
    }
}

Write-Host "Структура создана успешно!"
