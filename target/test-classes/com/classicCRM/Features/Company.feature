
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
  
   


