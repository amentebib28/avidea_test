@commande
Feature: Feature: Green Card Order Creation
  As an insurance company,  
  I want to create an order of 20 green cards  
  So that I can provide them to my insured clients

  Background: 
    Given I enter my email address "amenallah.assurance@yopmail.com" and my password "Test123*"
    And I am redirected to the home page

  Scenario: Successful order creation
    When I have added an order from the Orders section
    And I have filled in the required fields to create an order
    And I clicked the Save button
    And I submitted the green card order
    And I downloaded the purchase order
    And I clicked the Pay button
    And I filled in the payment information for the order
    And I clicked the Confirm button
    Then The order is successfully paid
   
