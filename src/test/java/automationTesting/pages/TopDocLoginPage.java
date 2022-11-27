package automationTesting.pages;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import repository.RepositoryContext;
import wrappers.SeleniumWrapper;

public class TopDocLoginPage extends SeleniumWrapper {

    public RepositoryContext context = new RepositoryContext();

    public TopDocLoginPage() throws InterruptedException {
        context.setContextCurrentPage("login_page");
        context.loadRepository();
        Thread.sleep(10000);
//        waitForTitleToLoad("Login - TD", WrapperConstants.MEDIUM_WAIT);

    }


}

