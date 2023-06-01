
@LoginTest
Feature: Login to CRM
  I want to login to CRM

  @ValidTest
  Scenario: I want to login to classic CRM application with Valid credentials.
    Given I am on Classic CRM Page
    And I have verified its title 
    #Free CRM  - CRM software for customer relationship management, sales, and support.
    When I enter valid Email ID and Password
    And click on login button
    Then I logged into crm 
    #CRMPRO title
    And check for login user 
    #shruti automation
   

  @NegativeTest
  Scenario Outline: Checking login function working or not
    Given I am on Classic CRM Page
    When I enter  <username> in username and password <password>
    And click on login button 
    Then I should not redirect to any page

    Examples: 
      | username  | password | 
      | name1 		|    pass1 | 
      | name2			|    pass2 | 
