package automationTesting.pages;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import repository.RepositoryContext;
import wrappers.SeleniumWrapper;
import wrappers.WrapperConstants;

public class ParaBankLoginHomePage extends SeleniumWrapper {
    public RepositoryContext context = new RepositoryContext();

    public ParaBankLoginHomePage() throws InterruptedException {

        context.setContextCurrentPage("login_home_page");
        context.loadRepository();
        waitForTitleToLoad("ParaBank | Customer Created", WrapperConstants.MEDIUM_WAIT);

    }

    @Then("User able to verify registration of account")
    public void userAbleToVerifyRegistrationOfAccount() {
        waitUntilElementVisible(context.getElement("welcomeLabel"),  WrapperConstants.MEDIUM_WAIT);
        verifyText(locateElement(context.getElement("welcomeLabel")), "Welcome " +frameworkData.get("username"),"User verifies the account creation");
    }

    @And("User click on Open New Account Link")
    public void userClickOnOpenNewAccountLink() {
        waitUntilElementVisible(context.getElement("openNewAccount"),  WrapperConstants.MEDIUM_WAIT);
        click(context.getElement("openNewAccount"),"User clicks on Open New Account Link");
    }

    @And("User click on Account Overview Link")
    public void userClickOnAccountOverviewLink() {
        waitUntilElementVisible(context.getElement("accountOverview"),  WrapperConstants.MEDIUM_WAIT);
        click(context.getElement("accountOverview"),"User clicks on Account Overview Link");

    }
}

