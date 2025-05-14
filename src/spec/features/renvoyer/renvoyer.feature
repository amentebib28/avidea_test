@renvoyer
Feature: Order Management  
  As an administrator,  
  I want to view the list of orders  
  So that I can resend them

  Background: 
    Given I enter my email address "ahmed.buat@yopmail.com" and my password "Conan.conan77"
    And I am redirected to the home page

  Scenario: Resending an order
    When I open the list of available orders R
    And I select an order to process R
    And I click on resend
    Then A confirmation message is display R