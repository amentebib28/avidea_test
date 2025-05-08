@allLogin
Feature: Login to my account as a user
  As a registered user, I want to log into my account

  Background:
    Given I open the login page

  @loginAssurance
  Scenario: Login with valid credentials - Assurance
    When I enter my email address "amenallah.assurance@yopmail.com" and my password "Test123*"
    Then I am redirected to the home page

  @loginBuat
  Scenario: Login with valid credentials - AdminBuat
    When I enter my email address "ahmed.buat@yopmail.com" and my password "Conan.conan77"
    Then I am redirected to the home page

  @loginAgency
  Scenario: Login with valid credentials - Agency
    When I enter my email address "agenceamen@yopmail.com" and my password "Amenallah.28"
    Then I am redirected to the home page

  # Examples:
  #   | email          | password   | errorMessage                        |
  #   |                | Test123*   | Incorrect login parameters!         |
  #   | amen@gmail.com |            | Incorrect login parameters!         |
  #   | user.com       | Test123*   | Incorrect login parameters!         |
  #   | user@gmail.com | 123        | Incorrect login parameters!  