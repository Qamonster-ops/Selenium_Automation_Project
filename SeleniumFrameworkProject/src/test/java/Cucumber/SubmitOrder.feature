
@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file
  
  Background:
  Given I landed on a Ecommerce page
  

  @tag2
  Scenario Outline: Positive Testvof Submitting the order
    Given  Logged in with username <name> and password <password>
    When   add the product <productname> to cart
    Then   "THANKYOU FOR THE ORDER." message is displayed on confirmation page
    
    Examples: 
      | name                 | password      | productname  |
      | sara.jones@gmail.com | Sahitya@95    | ZARA COAT 3  |
      
