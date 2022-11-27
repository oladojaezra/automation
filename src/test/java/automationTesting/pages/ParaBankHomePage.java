package automationTesting.pages;

import cucumber.api.java.en.Given;
import repository.RepositoryContext;
import wrappers.SeleniumWrapper;
import wrappers.WrapperConstants;

public class ParaBankHomePage extends SeleniumWrapper {
    public RepositoryContext context = new RepositoryContext();

    public ParaBankHomePage() throws InterruptedException {

        context.setContextCurrentPage("home_page");
        context.loadRepository();
        waitForTitleToLoad("ParaBank | Welcome | Online Banking", WrapperConstants.MEDIUM_WAIT);

    }

    @Given("User click on the sign up button in the home page")
    public void signUpLogin(){
        waitUntilElementVisible(context.getElement("registerLink"),  WrapperConstants.MEDIUM_WAIT);
        click(context.getElement("registerLink"), "User clicks on the Register button");
    }
}

