# WebDriver Cucumber Project

This project is generated from an archetype. It exists out of Cucumber, Selenium WebDriver, Allure and OWNER as the main dependencies.


## Run tests (defaults to Chrome)

`mvn clean test`

## Run tests in specific browser

`mvn clean test -Dbrowser=firefox`

`mvn clean test -Dbrowser=edge`

`mvn clean test -Dbrowser=chrome_headless`

`mvn clean test -Dbrowser=firefox_headless`

## Generate report

`mvn allure:report`

## Serve report

`mvn allure:serve`

## Check for dependency updates

`mvn versions:display-dependency-updates`

## Update to the latest release version

`mvn versions:update-properties`