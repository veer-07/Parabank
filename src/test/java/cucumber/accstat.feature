#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file





  @tag1
  Scenario: Title of your scenario
    Given I want to write a step with precondition
    And some other precondition
    When I complete action
    And some other action
    And yet another action
    Then I validate the outcomes
    And check more outcomes


#driver.get("https://parabank.parasoft.com/parabank/index.htm");
#		
#		Registartion r=new Registartion(driver);
#		r.register("veer",  "Password@12");
#//		r.updateContact();

Background:
Given i landed on the bank site


  @tag2
  Scenario Outline: Registering new account with details of the Customers
    Given I want to write a step with username <name> and password <passwords>
    When I check for the <value> in step
    Then I verify the "Thank you for the Account opening!" in step

    Examples: 
      | name  |    passwords    | 
      | veer  |    Password@12 | 
      | veera |    Password@123| 
