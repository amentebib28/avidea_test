@validate
Feature: Order Management  
  As an administrator,  
  I want to view the list of orders  
  So that I can validate them

  Background: 
    Given I open the login page
    When I enter my email address "ahmed.buat@yopmail.com" and my password "Conan.conan77"
    Then I am redirected to the home page

  Scenario: Valider une commande
    When I open the list of available orders
    And I select an order to process
    And I click on validate
    Then A confirmation message is displayed
