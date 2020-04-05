# Tags: optional
@web @LoginAws
Feature: Run AWS EC2 Instances
  As a performance test engineer
  I should be able to select the test servers
  So that I can turn them on

@InvalidLogin
  Scenario: Unsuccessful Login to AWS EC2 Site
    Given I access the AWS EC2 site
    And I click on Other Sites Radio button
    And I select 'Amazon Web Services' site in the dropdown
    And I click Sign in button in the first page
    And I enter my email in the login page
    And I enter an invalid password in the login page
    When I click Sign in button in the login page
    Then I should see an error message displayed
    """
    Incorrect user ID or password. Type the correct user ID and password, and try again.
    """