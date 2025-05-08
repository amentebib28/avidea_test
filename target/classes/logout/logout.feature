@logout
Feature: Faire la déconnexion
  En tant qu utilisateur connecté ,  je veux déconnecter

  Background: 
    Given I open the login page
    When I enter my email address "amenallah.assurance@yopmail.com" and my password "Test123*"
    Then I am redirected to the home page

  @tagLogout
  Scenario: 
    When I click on the user menu
    And I select the Logout option
    Then I am redirected to the login page
