@addgreencard
Feature: Green Card Creation
  As a logged-in user,  
  I want to create a green card  
  So that I can declare my vehicle for insurance purposes

  Background: 
    Given I open the login page
    When I enter my email address "agenceamen@yopmail.com" and my password "Amenallah.28"
    Then I am redirected to the home page
    When I have added a green card from the Cards section

  Scenario: Successful green card creation
    And I enter valid green card information
    And I click the Save button
    Then The green card is created successfully

  Scenario: Green card creation with empty data
    When I verify that the Save button is disabled
