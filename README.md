# Diplom_3
Project Overview
This project is a comprehensive test suite for the web application Stellar Burgers. It includes automated tests covering various functionalities of the application.

Technologies and Tools
Java: Primary programming language.
Selenium WebDriver: Used for automating web application testing.
Rest-Assured: Utilized for testing web services.
JUnit 4.13.2: The testing framework for Java.
Allure Framework: For generating test reports.
Webdriver Manager 5.5.2: To manage browser drivers easily.
Java Faker 1.0.2: For generating fake data for tests.
AspectJ 1.9.7: For advanced Java programming features.
Maven: Dependency management and project build.
Project Structure
The project employs the Page Object Model (POM) design pattern to describe and interact with the elements used in tests.

Cross-browser Testing
Tests are conducted on both Google Chrome and Yandex Browser to ensure cross-browser compatibility.

Allure Reports
Allure Framework is integrated for comprehensive test reporting. Test executions and results are captured in Allure reports, providing insights into the testing process.

Testing Scenarios
The project covers various testing scenarios including:

Successful user registration.
Error handling for incorrect password inputs (Minimum password length: 6 characters).
User login through different entry points:
"Login" button on the main page.
"Personal Account" button.
Registration form.
Password reset form.
Navigation to and from the "Personal Account".
Navigating to the "Constructor" from the personal account and by clicking the Stellar Burgers logo.
Logging out of the account.
Constructor Section
Test coverage includes navigation and functionality within the "Constructor" section of the application, specifically for:

Buns
Sauces
Fillings
Maven Configuration
The pom.xml file is configured with all necessary dependencies, plugins, and properties to support testing and reporting. It includes configurations for JUnit, Selenium WebDriver, Rest-Assured, Allure, and WebDriver Manager.