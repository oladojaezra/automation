Feature: As a user i am automating the login functionality of TopDoc application

  @SignUp @Regression @DailySmoke
  Scenario: User verifies the login functionality of TopDoc application
    Given User click on the sign up button in the home page
    And User enters the enters the first name
    And User enters the enters the last name
    And User enters the enters the address
    And User enters the enters the city
    And User enters the enters the state
    And User enters the enters the zipcode
    And User enters the enters the phone
    And User enters the enters the ssn
    And User enters the enters the username
    And User enters the enters the password
    And User enters the enters the confirm password
    When User clicks on Register link
    Then User able to verify registration of account
    And User click on Account Overview Link
    Then User verifies the account amount as 500
    And User click on Open New Account Link
    And User select the Saving Account
    And User clicks on new open account link
    And User saves the new open account id





