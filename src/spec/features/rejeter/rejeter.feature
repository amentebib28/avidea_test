@rejeter
Feature: Order Management  
  As an administrator,  
  I want to view the list of orders  
  So that I can reject them

  Background: 
    Given I enter my email address "ahmed.buat@yopmail.com" and my password "Conan.conan77"
    And I am redirected to the home page

  Scenario: Rejecting an order
    When I open the list of available orders Rej
    And I select an order to process Rej
    And I click on reject
    Then A confirmation message is displayed Rej