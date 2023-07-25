@CompanyTest
Feature: As a User I want to configure company details into system and use them in other sections 
					like creating new contact and new Deal #only verifying on page that company is visible is handled in seperate scenarios

  @DataCreationForCompany
  Scenario: Add new Record for Company
    Given Login to CRM Page
    And Navigate to New Company Section
    When I complete filling data form from excel data  
    Then I click on save button
    And then data should get saved successfully
    
  @TestFilterOnCompanyPage
  Scenario Outline: Filter on Company Page
  Given Navigate to Company Filter Section
  When I am on filter page for company
  And I apply Valid filter for <status>,<Category>and<Name>
  And I click on Search
  Then I should get results matching to my filter
  And search result should contain <CompanyNameOnResult>
  Examples:
  | status | Category | Name           | CompanyNameOnResult |
  | Active | Client   | Company1       | Company1            |
  | Active | Client   | newCompanyIDE  | newCompanyIDE       |
  | Active | Client   | CRMAppCompany1 | CRMAppCompany1      |
  
   


