package automationTesting.pages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import repository.RepositoryContext;
import wrappers.SeleniumWrapper;
import wrappers.WrapperConstants;

public class ParaBankAccountOverviewPage extends SeleniumWrapper {
    public RepositoryContext context = new RepositoryContext();

    public ParaBankAccountOverviewPage() throws InterruptedException {

        context.setContextCurrentPage("account_overview");
        context.loadRepository();
        waitForTitleToLoad("ParaBank | Accounts Overview", WrapperConstants.MEDIUM_WAIT);

    }

    @Then("User verifies the account amount as {int}")
    public void userVerifiesTheAccountAmountAs(int amount) {
        waitUntilElementVisible(context.getElement("balanceAmount"),  WrapperConstants.MEDIUM_WAIT);
        String balanceAmount = getText(locateElement(context.getElement("balanceAmount")));
        Assert.assertTrue(balanceAmount.contains(String.valueOf(amount)),amount + " expected balance amount not matches with actual balance amount " + balanceAmount);
    }
}

