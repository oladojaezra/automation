$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/Automation/SignUp.feature");
formatter.feature({
  "name": "As a user i am automating the login functionality of TopDoc application",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "User verifies the login functionality of TopDoc application",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@SignUp"
    },
    {
      "name": "@Regression"
    },
    {
      "name": "@DailySmoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User click on the sign up button in the home page",
  "keyword": "Given "
});
formatter.match({
  "location": "ParaBankHomePage.signUpLogin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters the enters the first name",
  "keyword": "And "
});
formatter.match({
  "location": "ParaBankSignUpPage.userEntersTheEntersTheFirstName()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters the enters the last name",
  "keyword": "And "
});
formatter.match({
  "location": "ParaBankSignUpPage.userEntersTheEntersTheLastName()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters the enters the address",
  "keyword": "And "
});
formatter.match({
  "location": "ParaBankSignUpPage.userEntersTheEntersTheAddress()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters the enters the city",
  "keyword": "And "
});
formatter.match({
  "location": "ParaBankSignUpPage.userEntersTheEntersTheCity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters the enters the state",
  "keyword": "And "
});
formatter.match({
  "location": "ParaBankSignUpPage.userEntersTheEntersTheState()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters the enters the zipcode",
  "keyword": "And "
});
formatter.match({
  "location": "ParaBankSignUpPage.userEntersTheEntersTheZipcode()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters the enters the phone",
  "keyword": "And "
});
formatter.match({
  "location": "ParaBankSignUpPage.userEntersTheEntersThePhone()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters the enters the ssn",
  "keyword": "And "
});
formatter.match({
  "location": "ParaBankSignUpPage.userEntersTheEntersTheSsn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters the enters the username",
  "keyword": "And "
});
formatter.match({
  "location": "ParaBankSignUpPage.userEntersTheEntersTheUsername()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters the enters the password",
  "keyword": "And "
});
formatter.match({
  "location": "ParaBankSignUpPage.userEntersTheEntersThePassword()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters the enters the confirm password",
  "keyword": "And "
});
formatter.match({
  "location": "ParaBankSignUpPage.userEntersTheEntersTheConfirmPassword()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on Register link",
  "keyword": "When "
});
formatter.match({
  "location": "ParaBankSignUpPage.userClicksOnRegisterLink()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User able to verify registration of account",
  "keyword": "Then "
});
formatter.match({
  "location": "ParaBankLoginHomePage.userAbleToVerifyRegistrationOfAccount()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click on Account Overview Link",
  "keyword": "And "
});
formatter.match({
  "location": "ParaBankLoginHomePage.userClickOnAccountOverviewLink()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User verifies the account amount as 500",
  "keyword": "Then "
});
formatter.match({
  "location": "ParaBankAccountOverviewPage.userVerifiesTheAccountAmountAs(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click on Open New Account Link",
  "keyword": "And "
});
formatter.match({
  "location": "ParaBankLoginHomePage.userClickOnOpenNewAccountLink()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User select the Saving Account",
  "keyword": "And "
});
formatter.match({
  "location": "ParaBankOpenAccountPage.userSelectTheSavingAccount()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on new open account link",
  "keyword": "And "
});
formatter.match({
  "location": "ParaBankOpenAccountPage.userClicksOnNewOpenAccountLink()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User saves the new open account id",
  "keyword": "And "
});
formatter.match({
  "location": "ParaBankOpenAccountPage.userSavesTheNewOpenAccountId()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});