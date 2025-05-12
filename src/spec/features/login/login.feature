@allLogin
Feature: Login to my account as a user
  As a registered user, I want to log into my account

  @loginAssurance
  Scenario: Login with valid credentials - Assurance
    Given I enter my email address "amenallah.assurance@yopmail.com" and my password "Test123*"
    When I am redirected to the home page

  @loginBuat
  Scenario: Login with valid credentials - AdminBuat
    Given I enter my email address "ahmed.buat@yopmail.com" and my password "Conan.conan77"
    When I am redirected to the home page

  @loginAgency
  Scenario: Login with valid credentials - Agency
    Given I enter my email address "agenceamen@yopmail.com" and my password "Amenallah.28"
    When I am redirected to the home page
  @loginWithInvalid
  Scenario Outline: 
    Given I enter my "<email>" and "<password>" invalid
    When I see a "<errorMessage>"

    Examples: 
      | email          | password | errorMessage                      |
      |                | Test123* | Paramètres de connexion erronés ! |
      | amen@gmail.com |          | Paramètres de connexion erronés ! |
      | user.com       | Test123* | Paramètres de connexion erronés ! |
      | user@gmail.com |      123 | Paramètres de connexion erronés ! |
