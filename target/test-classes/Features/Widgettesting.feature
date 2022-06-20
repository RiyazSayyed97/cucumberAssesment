
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
Feature: Testing https://shark-2000.github.io/test-website/ContactMe.html
  I want to use this template for my feature file

  @TestBenchCheck
  Scenario: Title of your scenario
    Given User should be on test bench
    When user enters <full name> in full name field
    And user enters <email> in email field
    And selects gender
    And selects reason
    And clicks on simple alert
    And clicks on alert with dismiss option
    Then mouseovers on images

      Examples: 
      | full name  | email            | 
      | katyayan 	 | Ks4342@gmail.com | 
      | raj 		   | RajS@netlink.com | 
