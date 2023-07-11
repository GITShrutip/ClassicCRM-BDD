@ContactPage
Feature: As a user I need to add contact in the system
  I want to use this template for my feature file

  @ContactPageNavigation
  Scenario: Navigate to contect Page
    Given Login to CRM Page
    And check contact option is available in menu bar
    When I click on add new contact option
    Then I validate whether contact form is available
   

 