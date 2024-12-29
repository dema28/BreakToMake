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

# Примеры файлов с шаблонами
$fileTemplates = @{
    "user_stories\authentication\login.md" = @"
# User Story: Login
## Description
As a [role], I want to [goal], so that [benefit].

## Acceptance Criteria
1. [Criterion 1]
2. [Criterion 2]
3. [Criterion 3]

## Notes
- [Additional Notes]
"@

    "test_cases\smoke_tests\login_smoke_test.xlsx" = @"
Тестовые кейсы для Smoke Test
"@

    "bug_reports\UI_issues\button_alignment_issue.md" = @"
# Bug Report: Button Alignment Issue
## Description
[Describe the issue]

## Steps to Reproduce
1. [Step 1]
2. [Step 2]
3. [Step 3]

## Expected Result
[What should happen]

## Actual Result
[What actually happens]

## Environment
- Browser: [Browser Name and Version]
- OS: [Operating System]
"@

    "supporting_documents\requirements\functional_requirements.md" = @"
# Functional Requirements
## Overview
[List the functional requirements of the project]
1. [Requirement 1]
2. [Requirement 2]

## Assumptions
[List any assumptions]
"@

    "supporting_documents\diagrams\use_case_diagram.png" = "PNG-файл будет добавлен вручную."
}

# Создание файлов и добавление шаблонов
foreach ($filePath in $fileTemplates.Keys) {
    $fullPath = "manual_testing\$filePath"
    $content = $fileTemplates[$filePath]

    # Создаем файл и добавляем шаблон
    $folderPath = Split-Path $fullPath
    if (!(Test-Path $folderPath)) {
        New-Item -ItemType Directory -Path $folderPath | Out-Null
    }
    Set-Content -Path $fullPath -Value $content
}

Write-Host "Структура с файлами и шаблонами создана успешно!"
